/*------------------------------------------------------------------------------
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *------------------------------------------------------------------------------
 */

package com.harris.challenge.brata.tools;

import com.harris.challenge.brata.R;
import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

/**
 * Used for finding rotational bearing
 * 
 * @author Harris Corporation
 *
 */
public class BearingActivity extends Activity implements SensorEventListener
{   
  Float reading_in_radians;  // View to draw a compass
  SensorManager sensorManager = null;
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_bearing);        

      // there are a few sensors on the phone.  This guy manages them all.
      SensorManager sensorManager = (SensorManager) this.getSystemService(SENSOR_SERVICE);        

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
      float rotation[] = new float[9];
      float inclination[] = new float[9];
      boolean success = SensorManager.getRotationMatrix(rotation, inclination, mGravity, mGeomagnetic);
      if (success)
      {
        float orientation[] = new float[3];
        SensorManager.getOrientation(rotation, orientation);
        reading_in_radians = orientation[0]; 
        
        // Insert code here
        // update UI with bearing
      }
    }
  }
}
