package com.harris.challenge.brata.tools;

import com.harris.challenge.brata.R;
import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

//  I have included this so students can use it to help their code compute some
//  complex math functions.  See Math Examples below.
import 	java.lang.Math;


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
      
      TextView Angle_Value = (TextView) findViewById(R.id.textView21);
      TextView XYZ_Values = (TextView) findViewById(R.id.textView20);
      
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
                  	// 3 array values are returned in an array 
                  	// event.values [0] = x 
                  	// event.values [1] = y
                  	// event.values [2] = z
                      
                      float x = event.values[0];
                      float y = event.values[1];
                      float z = event.values[2];
                      
                      // The values x, y, z are 3D coordinate values                      
                      // You can add code here to display these values to the screen.
                      // Once you can see the values on the screen try rotating your phone
                      // around to try and understand the orientation values that your 
                      // phone is reporting.
                      // Hint:  You can probably ignore the Z value.  2D coordinates (x,y)
                      // can be used to find angels just fine.
                      
                      //    XYZ_Values.setText(...
                      
                      
                      // Once you have a better idea of what your X and Y values stand for, you
                      // should be able to use some simple trig to find the angle in which your
                      // phone is currently tilted.  
                      
                      //    Angle_Value.setText(...
                      
                      
                      // MATH examples
                      
                      // find the absolute value of a negative number
                      //     int negNumber = -1;
                      //     int posNumber = Math.abs(negNumber);
                      
                      // posNumber value should be 1
                      
                      // other math functions can be found online... just do some googling.
                      
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
              SensorManager.SENSOR_DELAY_NORMAL);
  }
}