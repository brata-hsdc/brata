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
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;



public class LightSensorActivity extends Activity implements SensorEventListener {

    // Declare layout elements and widgets
    private ImageView needle;
    private ProgressBar light_bar;
    private TextView light_text;
    private Button button_start_stop;
    private Button button_submit;
    private EditText edit_submission;

    private boolean sensor_started = false;
    private int light_value = 0;

    private SensorManager sm;
    private Handler handler = new Handler();

    final float min_guage_angle = -48; 
    final float max_guage_angle = 48;

    /**
     * This will be called whenever this activity is created.
     */  
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // This applies the layout specified in 
        //   res->layout->activity_request_clue.xml
        // to our Activity. We can now find views within that layout and
        // manipulate them. Don't try to call findViewById() before this!
        setContentView(R.layout.light_sensor);

        // Setup activity widgets
        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        needle = (ImageView) findViewById(R.id.ImageNeedle);        
        light_bar = (ProgressBar) findViewById(R.id.ProgressLight);
        light_text = (TextView) findViewById(R.id.TextLightReading);
        light_text.setText("0");
        edit_submission = (EditText) findViewById(R.id.EditSubmission);
        edit_submission.setHint("Type submission here");

        // Assign functions to buttons
        button_start_stop = (Button) findViewById(R.id.ButtonStartStop);
        button_start_stop.setOnClickListener(startStopPressed);
        
        button_submit = (Button) findViewById(R.id.ButtonSubmit);
        button_submit.setOnClickListener(submit);
    }
    
    /**
     * This will be called whenever this activity finishes and is destroyed.
     * Use this function to cleanup anything your activity has done
     */  
    @Override
    protected void onDestroy() {
        // Stop sensor from updating in the future and unregister for light sensor updates
        sensor_started = false;
        sm.unregisterListener(LightSensorActivity.this);
        super.onDestroy();
    }
    
    /**
     * Function to process LightSensor Start/Stop button presses
     */    
    View.OnClickListener startStopPressed = new OnClickListener() {
        public void onClick(View v) {
            // If is sensor is running when button is pressed then stop it by 
            // unregistering for lightsensor updates
            if(sensor_started)
            {
                sensor_started = false;
                button_start_stop.setText("Start");
                sm.unregisterListener(LightSensorActivity.this);
            }
            else
            {
                // Set sensor to running
                sensor_started = true;
                button_start_stop.setText("Stop");

                // Check if there is at least one light sensor then register for updates
                if (sm.getSensorList(Sensor.TYPE_LIGHT).size() == 0)
                {
                    Toast.makeText(getBaseContext(), "No light sensor installed", 2).show();
                }
                else
                {
                    // Register this activity to the sensor for updates
                    sm.registerListener(LightSensorActivity.this, sm.getSensorList(Sensor.TYPE_LIGHT).get(0), SensorManager.SENSOR_DELAY_GAME);
                }
                
                // post the update function to this activities thread run with 0 wait time
                handler.postDelayed(update, 0);
            }
        }
    };

    // This activity implements the SensorEventListener interface so that it may 
    // register itself for LightSensor updates.  It is required to implement the 
    // following two functions:
    //
    //
    /**
     * This function is used to update the layout elements with a new intensity value
     */    
    private final Runnable update = new Runnable() {
        public void run() {
            if(sensor_started)
            {
                // The light intensity value which varies exponentially is transformed 
                // into a simpler gauge value which varies linearly from 0-100
                float gauge_value = (float) (Math.log10((double)light_value) * 25.0f);
                if(gauge_value > 100)
                    gauge_value = 100;
                if(gauge_value < 0)
                    gauge_value = 0;

                // The gauge value is used to determine the angle of the needle image 
                // which is tuned to line up and rotate correctly with the gauge image
                // A simple way to rotate an image to to use the RotationAnimation with 0 delay
                float gauge_angle = gauge_value / 100.0f * (max_guage_angle - min_guage_angle) + min_guage_angle;
                RotateAnimation anim = new RotateAnimation(gauge_angle, gauge_angle,
                        Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,1.09f);
                // Set options to adjust the animation
                anim.setDuration(0);
                anim.setFillEnabled(true);
                anim.setFillBefore(true);
                anim.setFillAfter(true);
                needle.startAnimation(anim);

                // Also set progress bar to reflect light intensity
                light_bar.setProgress((int) gauge_value);

                // Display the actual light intensity value in a text view
                light_text.setText(String.valueOf(light_value));

                // Post this function to to the thread to update the UI again after 80 milliseconds
                handler.postDelayed(update, 80);
            }
        }
    };



    // This activity implements the SensorEventListener interface so that it may 
    // register itself for LightSensor updates.  It is required to implement the 
    // following two functions:
    //        onSensorChanged()
    //        onAccuracyChanged()

    /**
     * When the Android light sensor detects that light intensity has changed it will 
     * call this function on all registered listeners with parameters that contain 
     * the new light value.
     */

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
            light_value = (int) event.values[0];
        }
    }

    /**
     * Function called on all listeners for a sensor when accuracy has changed
     */ 
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // TODO Auto-generated method stub
    }








    View.OnClickListener submit = new OnClickListener() {
        public void onClick(View v) {
            String textToSubmit = getTextToSubmit();

            // Actually do the submitting
            submitText(textToSubmit);

            // The following two lines are just some code to make the soft
            // keyboard hide when you press the submit button. Feel free to
            // look up how SystemServices work, but for now you can just 
            // copy and paste these lines anywhere you just want to make the
            // keyboard go away.
            InputMethodManager inputManager = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE); 
            inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                       InputMethodManager.HIDE_NOT_ALWAYS);
        }
    };
    
    /**
     * Generates the text to submit
     * 
     * @return the text to be submitted
     */
    private String getTextToSubmit() {
        // This is just an example of how you may want to split out some of
        // your larger tasks into smaller chunks to logically break down the
        // problem into simpler and easier-to-read pieces.

        return edit_submission.getText().toString();
    }
    
    /**
     * Performs the actual submission of text
     * 
     * @param text
     *         the text to be submitted
     */
    private void submitText(String text) {
        // should confirm submission then submit
    }
}
