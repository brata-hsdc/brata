package com.harris.challenge.brata.tools;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.harris.challenge.brata.R;

/**
 * This class handles the recording of audio files.
 * 
 * Note that it requires the WRITE_EXTERNAL_STORAGE and RECORD_AUDIO permissions.
 * 
 * Code based on example code from http://developer.android.com/guide/topics/media/audio-capture.html
 * Used under CC BY 2.5 license: http://creativecommons.org/licenses/by/2.5/
 * 
 * @author Jeremy
 *
 */
public class SoundRecordingActivity extends Activity {
	private static final String LOG_TAG = "SoundRecordingActivity";
	
	private static String mFolder = null;
	
	private TextView mFileName = null;
	
	boolean mStartRecording = true;
	boolean mStartPlaying = true;
	
	private Button mRecordButton = null;
    private MediaRecorder mRecorder = null;

    private Button   mPlayButton = null;
    private MediaPlayer   mPlayer = null;
    
    public SoundRecordingActivity() {
    	mFolder = Environment.getExternalStorageDirectory().getAbsolutePath();
    	mFolder += "/brata/";
    	
    	File brataDir = new File(mFolder);
    	brataDir.mkdirs();
    }
    
    private void onRecord(boolean start) {
        if (start) {
            startRecording();
        } else {
            stopRecording();
        }
    }

    private void onPlay(boolean start) {
        if (start) {
            startPlaying();
        } else {
            stopPlaying();
        }
    }

    private void startPlaying() {
        mPlayer = new MediaPlayer();
        try {
            mPlayer.setDataSource(mFolder + mFileName.getText().toString());
            mPlayer.prepare();
            mPlayer.start();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }
    }

    private void stopPlaying() {
        mPlayer.release();
        mPlayer = null;
    }

    private void startRecording() {
        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mRecorder.setOutputFile(mFolder + mFileName.getText().toString());
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            mRecorder.prepare();
            mRecorder.start();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }
    }

    private void stopRecording() {
        mRecorder.stop();
        mRecorder.release();
        mRecorder = null;
    }
    
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        
        setContentView(R.layout.activity_sound);

        mFileName = (TextView)findViewById(R.id.TextFileName);
        mRecordButton = (Button)findViewById(R.id.RecordButton);
        mPlayButton = (Button)findViewById(R.id.PlayButton);
        
        mRecordButton.setOnClickListener(record);
        mPlayButton.setOnClickListener(play);
        
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mRecorder != null) {
            mRecorder.release();
            mRecorder = null;
        }

        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }
    
	OnClickListener record = new OnClickListener() {
		public void onClick(View v) {
			onRecord(mStartRecording);
            if (mStartRecording) {
                mRecordButton.setText("Stop recording");
            } else {
            	mRecordButton.setText("Start recording");
            }
            mStartRecording = !mStartRecording;
		}
	};
	
	OnClickListener play = new OnClickListener() {
		public void onClick(View v) {
            onPlay(mStartPlaying);
            if (mStartPlaying) {
                mPlayButton.setText("Stop playing");
            } else {
            	mPlayButton.setText("Start playing");
            }
            mStartPlaying = !mStartPlaying;
		}
	};
}
