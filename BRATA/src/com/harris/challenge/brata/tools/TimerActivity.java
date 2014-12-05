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

// Need the following import to get access to the app resources, since this
// class is in a sub-package.

import com.harris.challenge.brata.R;
import java.util.Date;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TimerActivity extends Activity {
    TextView timer;
    Button button_reset;
    Button button_start_stop;
    Button button_submit;
    EditText edit_submission;
    
    Handler handler = new Handler();
    
    boolean timer_started = false;
    boolean timer_zero_reset = true;
    
    long start_time;
    long pause_time;
    
    final int SECONDS_TO_MILLISECONDS = 1000;
    final int MINUTES_TO_MILLISECONDS = 60 * 1000;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // This applies the layout specified in 
        //   res->layout->activity_request_clue.xml
        // to our Activity. We can now find views within that layout and
        // manipulate them. Don't try to call findViewById() before this!
        setContentView(R.layout.timer);

        // setup activity widgets
        timer = (TextView) findViewById(R.id.TextTimer);
        timer.setText("00:00:000");
        pause_time = 0;
        edit_submission = (EditText) findViewById(R.id.EditSubmission);
        edit_submission.setHint("Type submission here");

        // Assign functions to buttons
        button_reset = (Button) findViewById(R.id.ButtonReset);
        button_reset.setOnClickListener(reset);
        
        button_start_stop = (Button) findViewById(R.id.ButtonStartStop);
        button_start_stop.setOnClickListener(startStopPressed);
        button_start_stop.setText("Start");
        
        button_submit = (Button) findViewById(R.id.ButtonSubmit);
        button_submit.setOnClickListener(submit);
    }
    
    @Override
    protected void onDestroy() {
        timer_started = false;
        super.onDestroy();
    }
    
    /**
     * React to pressing the reset button
     */ 
    View.OnClickListener reset = new OnClickListener() {
        public void onClick(View v) {
            // On reset simply set the timer text to zeroes 
            // and reset the starting point in time to now
            start_time = (new Date()).getTime();
            timer_zero_reset = true;
            timer.setText("00:00:000");
        }
    };
    
    /**
     * React to pressing the start/stop button
     */    
    View.OnClickListener startStopPressed = new OnClickListener() {
        public void onClick(View v) {
            // If the timer is running then stop the timer
            // and recorded the paused point in time
            if(timer_started)
            {
                pause_time = (new Date()).getTime();
                timer_started = false;
                button_start_stop.setText("Start");
            }
            else
            {// If the timer is stopped then start the timer

                if(timer_zero_reset)
                {// set the starting point in time to now if the timer was previously reset
                    start_time = (new Date()).getTime();
                }
                else
                {    // since the timer was pause the start reference point in time 
                    // needs to be adjusted for the time spent paused
                    start_time += (new Date()).getTime() - pause_time;
                }

                timer_started = true;
                timer_zero_reset = false;
                button_start_stop.setText("Stop");
                // post event to thread to execute an update to the UI with 0 wait time
                handler.postDelayed(update, 0);
            }
        }
    };

    /**
     * This function is used to periodically update the UI
     */    
    private final Runnable update = new Runnable() {
        public void run() {
            // if timer is running then update the text for the timer
            if(timer_started)
            {
                long timer_diff = (new Date()).getTime() - start_time;
                timer.setText(String.format("%02d", timer_diff/MINUTES_TO_MILLISECONDS)+":"
                        + String.format("%02d", (timer_diff%MINUTES_TO_MILLISECONDS) / SECONDS_TO_MILLISECONDS)+":"
                        + String.format("%03d", timer_diff%SECONDS_TO_MILLISECONDS));
                // post this function again to the thread to run 80 milliseconds in the future
                handler.postDelayed(update, 80);
            }
        }
    };


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
