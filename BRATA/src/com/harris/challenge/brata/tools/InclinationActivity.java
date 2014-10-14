package com.harris.challenge.brata.tools;

import com.harris.challenge.brata.R;
import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

/**
 * Used for finding inclination of an object
 * 
 * @author Harris Corporation
 *
 */
public class InclinationActivity extends Activity
{   
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_inclination);        

      // there are a few sensors on the phone.  This guy manages them all.
      SensorManager sensorManager = (SensorManager) this.getSystemService(SENSOR_SERVICE);        
      
      // We make a SensorEventListener which actually listens to our sensor...
      final SensorEventListener mEventListener = new SensorEventListener() 
      {
          public void onAccuracyChanged(Sensor sensor, int accuracy) 
          {
          	// do nothing here.
          }

          // this gets called each time the phone detects and orientation change
          public void onSensorChanged(SensorEvent event) 
          {
              // Handle the events for which we registered
              switch (event.sensor.getType()) 
              {
              	  // the Accelerometer will return to you the orientation of the phone
                  // by giving you a X,Y,Z value.
                  case Sensor.TYPE_ACCELEROMETER:

                	  //Raw sensor values from accelerometer
                      float x = event.values[0];
                      float y = event.values[1];
                      float z = event.values[2];                    
                      
                      break;
              }
          };
      };

      // You have set the event listener up, now just need to register this with the
      // sensor manager along with the sensor wanted.
      setListners(sensorManager, mEventListener);

  }

  // Register the event listener and sensor type.
  public void setListners(SensorManager sensorManager, SensorEventListener mEventListener)
  {
      sensorManager.registerListener(mEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), 
              100000);
  }
}