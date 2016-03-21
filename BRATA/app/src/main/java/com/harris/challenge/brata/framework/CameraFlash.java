package com.harris.challenge.brata.framework;

import android.content.Context;
import android.hardware.Camera;
import android.widget.Toast;

/**
 * Class which abstracts control of sending a timed flash of the camera's led.
 *
 * @author Harris Corporation
 *
 */
public class CameraFlash {

    /**
     * Flash a code where the values of 0-7 are provided and the number of flashes generated is
     * two more than the value provided.  A flash consists of approximately 225 ms on followed by
     * 225 ms off. After each value a gap of approximately 225*3 ms is generated.
     *
     * @param values
     *            The values to send. Although any number can be supplied for the 2016 challenge it
     *            is expected there will be for values inclusive of 0-7.
     *
     * @param onTuning
     *            A value between 0 and 1.
     *            The camera takes a variable amount of time to turn the flash on. This is the
     *            percentage of time believed for the time into the call that the particular phone
     *            needs to turn on.  For example 0.8 implies the camera will turn on after 80% of
     *            the time into the function call to turn on the flash is when the flash actually
     *            turns on. It is recommended to start at 0.5 and move up based on integration
     *            testing results.
     *
     * @param offTuning
     *            A value between 0 and 1.
     *            The camera takes a variable amount of time to turn the flash off. This is the
     *            percentage of time believed for the time into the call that the particular phone
     *            needs to turn off.  For example 0.8 implies the camera will turn off after 80% of
     *            the time into the function call to turn off the flash is when the flash actually
     *            turns off. It is recommended to start at 0.5 and move up based on integration
     *            testing results.
     *
     * @return
     *            A string describing some statistics of the hardware performance for enabling and
     *            dissabling the flash.  For the 2016 challenge using an on off interval of 225 ms
     *            allows for +/- 25 ms of error.  This means that if the average time for your
     *            device exceeds 50 ms and turns on or off at approximately 50% of the call you will
     *            just barely be within tolerance.  If either average or max exceed 50 ms contact
     *            your HSDC representative for help, and consider trying another team member's
     *            phone.  If the average value is trending closer to the max a greater tuning value
     *            may be needed, otherwise if trending lower should be tuned down.  Note that each
     *            run is likely to give different results it is VERY important when tuning and
     *            during the competition to ensure that nothing else is running in the background
     *            of your phone that can lead to variations in the timing.  A restart of your phone
     *            is highly recommended both before tuning and before starting the competition.
     */
    public static String flash(short[] values,
                             double onTuning, double offTuning) {
        String calibrationCheck = "Unknown Error";
        Camera cam = Camera.open();
        Camera.Parameters onParams = cam.getParameters();
        onParams.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        Camera.Parameters offParams = cam.getParameters();
        offParams.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);

        int onInterval = 225;
        int offInterval = 225;
        try {
            cam.setParameters(offParams);
            cam.startPreview();
            Thread.sleep(offInterval);
            double maxOn = 0;
            double minOn = 100;
            double maxOff = 0;
            double minOff = 100;
            double totalOn = 0;
            double totalOff = 0;
            double pulses = 0;
            // Typically the following values would be created onlyin the scope they are needed,
            // however, the timing here is so critical that all variable creation needs to happen
            // before we enter into the loops with the critical timing.
            long startTime = 0;
            long endTime = 0;
            double timeToTurnOn = 0;
            long startTime2 = 0;
            long endTime2 = 0;
            double timeToTurnOff = 0;

            for(int i=0; i<values.length; i++) {
                // For each value n generate n+2 pulses
                for(int j=0; j<values[i]+2;j++) {
                    // We need to time the duration to
                    pulses++;
                    startTime = System.nanoTime();
                    cam.setParameters(onParams);
                    endTime = System.nanoTime();
                    timeToTurnOn = (endTime - startTime)/1e6;
                    totalOn += timeToTurnOn;
                    if (timeToTurnOn > maxOn){maxOn=timeToTurnOn;}
                    if (timeToTurnOn < minOn){minOn=timeToTurnOn;}
                    Thread.sleep(onInterval
                            -Math.round(timeToTurnOn*onTuning)
                            +Math.round(timeToTurnOff*(1-offTuning)));
                    startTime2 = System.nanoTime();
                    cam.setParameters(offParams);
                    endTime2 = System.nanoTime();
                    timeToTurnOff = (endTime2 - startTime2)/1e6;
                    totalOff += timeToTurnOff;
                    if (timeToTurnOff > maxOff){maxOff=timeToTurnOff;}
                    if (timeToTurnOff < minOff){minOff=timeToTurnOff;}
                    Thread.sleep(offInterval-Math.round(timeToTurnOff*offTuning));
                }
                // Keep it off for the gap between values
                Thread.sleep(offInterval*2);
                // Factor out the duration of time we are trying to get it on but it is still off
                Thread.sleep(offInterval-Math.round(timeToTurnOn*(1-onTuning)));
            }
            double averageTimeToTurnOn = totalOn/pulses;
            double averageTimeToTurnOff = totalOff/pulses;
            calibrationCheck = String.format(
                        "minOn=%1.1f, maxOn=%1.1f, averageTimeToTurnOn=%1.1f, minOff=%1.1f, maxOff=%1.1f, averageTimeToTurnOff=%1.1f",
                        minOn, maxOn, averageTimeToTurnOn, minOff, maxOff, averageTimeToTurnOff);
            cam.stopPreview();
            cam.release();
        } catch (InterruptedException e) {
            calibrationCheck=e.getMessage();
        }
        return calibrationCheck;
    }
}
