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


public class BearingActivity extends Activity implements SensorEventListener
{   

  Float reading_in_radians;  // View to draw a compass
  final float rad2deg = (float)(180.0f/Math.PI);
  TextView Angle_Value = null;
  SensorManager sensorManager = null;
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_bearing);        

      // there are a few sensors on the phone.  This guy manages them all.
      SensorManager sensorManager = (SensorManager) this.getSystemService(SENSOR_SERVICE);        
      
      Angle_Value = (TextView) findViewById(R.id.textView21);
      
      // You have set the event listener up, now just need to register this with the
      // sensor manager along with the sensor wanted.
      sensorManager.registerListener(this, 
    		  sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), 
              SensorManager.SENSOR_DELAY_NORMAL);
      sensorManager.registerListener(this, 
    		  sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD), 
              SensorManager.SENSOR_DELAY_NORMAL);

  }
  
  
  public void onAccuracyChanged(Sensor sensor, int accuracy) 
  {
  	// do nothing here.
  }
  
  // Arrays of sensor values for each sensor
  float[] mGravity;
  float[] mGeomagnetic;
  public void onSensorChanged(SensorEvent event) {
	  
	// Save accelerometer sensor update
    if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
    {
       mGravity = event.values;
    }
    
    // Save magnetic sensor update
    if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD)
    {
      mGeomagnetic = event.values;
    }
    
    // If data is available for both sensors
    // This logic uses Android rotation and orientaion functions 
    // to derive the rotation in radians relative to the north pole 
    if (mGravity != null && mGeomagnetic != null)
    {
      float R[] = new float[9];
      float I[] = new float[9];
      boolean success = SensorManager.getRotationMatrix(R, I, mGravity, mGeomagnetic);
      if (success)
      {
        float orientation[] = new float[3];
        SensorManager.getOrientation(R, orientation);
        reading_in_radians = orientation[0]; 
        
        // Insert code here
        // update UI with bearing
      }
    }
  }
}