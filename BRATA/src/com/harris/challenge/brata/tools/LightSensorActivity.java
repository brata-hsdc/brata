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
	
	boolean sensor_started = false;
	int light_value = 0;
	ImageView needle;
	ProgressBar light_bar;
	TextView light_text;
	Button button_start_stop;
	Button button_submit;
	EditText edit_submission;
	
	SensorManager sm;
	Handler handler = new Handler();
	
	final float min_guage_angle = -48; 
	final float max_guage_angle = 48;
		
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // This applies the layout specified in 
        //   res->layout->activity_request_clue.xml
        // to our Activity. We can now find views within that layout and
        // manipulate them. Don't try to call findViewById() before this!
        setContentView(R.layout.light_sensor);
		
        // setup activity widgets
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
    
	View.OnClickListener startStopPressed = new OnClickListener() {
		public void onClick(View v) {
			if(sensor_started)
			{
				sensor_started = false;
				button_start_stop.setText("Start");
				sm.unregisterListener(LightSensorActivity.this);
			}
			else
			{
				sensor_started = true;
				button_start_stop.setText("Stop");
				
			    // Check if there is at least one light sensor
			    if (sm.getSensorList(Sensor.TYPE_LIGHT).size() == 0)
			    {
			    	Toast.makeText(getBaseContext(), "No light sensor installed", 2).show();
			    }
			    else
			    {
			        sm.registerListener(LightSensorActivity.this, sm.getSensorList(Sensor.TYPE_LIGHT).get(0), SensorManager.SENSOR_DELAY_GAME);
			    }
				
				handler.postDelayed(update, 0);
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
     * 		the text to be submitted
     */
    private void submitText(String text) {
    	// should confirm submission then submit
    }
	
	private final Runnable update = new Runnable() {
    	public void run() {
    		if(sensor_started)
    		{
	    		float gauge_value = (float) (Math.log10((double)light_value) * 25.0f);
	    		if(gauge_value > 100)
	    			gauge_value = 100;
	    		if(gauge_value < 0)
	    			gauge_value = 0;
	    		
	    		float gauge_angle = gauge_value / 100.0f * (max_guage_angle - min_guage_angle) + min_guage_angle;
	    		RotateAnimation anim = new RotateAnimation(gauge_angle, gauge_angle,
	                    Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,1.09f);
	    		
	    		anim.setDuration(0);
	            anim.setFillEnabled(true);
	    		anim.setFillBefore(true);
	    		anim.setFillAfter(true);
	            needle.startAnimation(anim);
	            
	            light_bar.setProgress((int) gauge_value);
	            light_text.setText(String.valueOf(light_value));
	            
	    		handler.postDelayed(update, 80);
    		}
        }
	};
	
	@Override
	public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
        	light_value = (int) event.values[0];
        }
	}
	
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
	}
	
	@Override
	protected void onDestroy() {
		sensor_started = false;
    	sm.unregisterListener(LightSensorActivity.this);
		super.onDestroy();
	}
}
