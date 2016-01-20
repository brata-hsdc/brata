package com.harris.challenge.brata.framework;

import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.util.Log;

public class AudioSample {

    private static final int RECORDER_CHANNELS = AudioFormat.CHANNEL_IN_MONO;
    private static final int RECORDER_AUDIO_ENCODING = AudioFormat.ENCODING_PCM_16BIT;
    private static final int BUFFER_INCREASE_FACTOR = 2;
    private static final String TAG = "AudioSample";

    public AudioSample() {
    }

    /**
     * Collect an audio sample at the supplied rate and return a clean sample which reflects the
     * provided duration.  The total returned buffer size will be
     * sampleRate * duration / 1000.  So the nominal case of collectSample(8000,1000) will return
     * a buffer of shorts which has 8000 values. If there was an error the return value is null.
     *
     * @param sampleRate
     *            The sample rate to use given in Hz. For the hsdc 8000 should be good enough, but
     *            for reference CD quality is 44100.
     *
     * @param duration
     *            The length in time in ms reflected in the returned array.  This is not the time
     *            that will be sampled as Android has initial settling time and some known buffering
     *            issues that this code works around smapling longer and then provides a clean array
     *            back that reflects a relatively clean sample.
     */
    public static short[] collectSample(int sampleRate, int duration)
    {
        //get the size of the buffer from milliseconds desired
        // give it extra space to prevent overflow
        int recordingBufferSize = getBufferSizeFromTime(duration, sampleRate, RECORDER_AUDIO_ENCODING);
        int increasedRecordingBufferSize =
                recordingBufferSize * BUFFER_INCREASE_FACTOR;

        final short[] readBuffer = new short[recordingBufferSize];
        // java initializes all arrays to zero by default
        short[] returnBuffer = null;

        AudioRecord recorder = new AudioRecord(MediaRecorder.AudioSource.MIC,
                sampleRate, RECORDER_CHANNELS,
                RECORDER_AUDIO_ENCODING, increasedRecordingBufferSize);

        //Note: possible IllegalStateException
        //if audio recording is already recording or otherwise not available
        //AudioRecord.getState() will be AudioRecord.STATE_UNINITIALIZED
        recorder.startRecording();
        if(recorder.getState()!= AudioRecord.STATE_UNINITIALIZED)
        {
            int bufferResult = recorder.read(readBuffer, 0, recordingBufferSize);
            //in case external code stopped this while read was happening
            // check for error conditions
            if (bufferResult == AudioRecord.ERROR_INVALID_OPERATION)
            {
                Log.e(TAG, "error reading: ERROR_INVALID_OPERATION");
            }
            else if (bufferResult == AudioRecord.ERROR_BAD_VALUE)
            {
                Log.e(TAG, "error reading: ERROR_BAD_VALUE");
            }
            else
            // no errors, do processing to get the clean data range
            {
                int returnBufferSize = sampleRate * duration / 1000;

                returnBuffer = new short[sampleRate * duration / 1000];
                // The algorithm doubled the sample ize so we can ignore the last and first 25%
                System.arraycopy(readBuffer, returnBufferSize/2, returnBuffer, 0, returnBufferSize);
            }
        }

        //we are done with the recorder.  stop and clean up
        Log.d(TAG, "shut down recorder");
        if (recorder != null)
        {
            recorder.stop();
            recorder.release();
            recorder = null;
        }
        return returnBuffer;
    }

    /**
     * Calculate audio buffer size such that it holds numSamplesInBuffer and is
     * bigger than the minimum size
     *
     * @param numSamplesInBuffer
     *            Make the audio buffer size big enough to hold this many
     *            samples
     */
    private static int determineCalculatedBufferSize(final int sampleRate,
                                              int encoding, int numSamplesInBuffer)
    {
        int minBufferSize = determineMinimumBufferSize(sampleRate, encoding);

        int bufferSize = 0;
        // each sample takes two bytes, need a bigger buffer
        if (encoding == AudioFormat.ENCODING_PCM_16BIT)
        {
            bufferSize = numSamplesInBuffer * 2;
        }
        else
        {
            bufferSize = numSamplesInBuffer;
        }

        if (bufferSize < minBufferSize)
        {
            Log.w(TAG, "Increasing buffer to hold enough samples "
                    + minBufferSize + " was: " + bufferSize);
            bufferSize = minBufferSize;
        }

        return bufferSize;
    }

    private static int determineMinimumBufferSize(final int sampleRate, int encoding)
    {
        int minBufferSize =
                AudioRecord.getMinBufferSize(sampleRate,
                        AudioFormat.CHANNEL_IN_MONO, encoding);
        return minBufferSize;
    }

    /**
     * calculate the size of the buffer needed based on seconds desired
     */
    private static int getBufferSizeFromTime(int millisecondsPerAudioClip,
                                     int sampleRate, int encoding)
    {
        float percentOfASecond = (float) millisecondsPerAudioClip / 1000.0f;
        int numSamplesRequired = (int) ((float) sampleRate * percentOfASecond);
        int bufferSize =
                determineCalculatedBufferSize(sampleRate, encoding,
                        numSamplesRequired);

        return bufferSize;
    }
}
