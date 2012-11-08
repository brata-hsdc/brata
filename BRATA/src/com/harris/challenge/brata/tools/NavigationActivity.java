/**
 * 
 */
package com.harris.challenge.brata.tools;

import com.harris.challenge.brata.R;
import com.harris.challenge.brata.framework.GPSService;
import com.harris.challenge.brata.framework.GPSService.GPSServiceListener;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Andrew
 * 
 */
public class NavigationActivity extends Activity implements OnClickListener, GPSServiceListener{

	private GPSService gpsService = null;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 * 
	 * This will be called whenever this activity is created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// This applies the layout specified in
		// res->layout->activity_request_clue.xml
		// to our Activity. We can now find views within that layout and
		// manipulate them. Don't try to call findViewById() before this!
		setContentView(R.layout.activity_request_clue);

		// First, grab a TextView out of the layout and set it's text to
		// something else
		TextView value1Label = (TextView) findViewById(R.id.row1name);
		value1Label.setText("Request:");

		TextView value1 = (TextView) findViewById(R.id.row1value);
		value1.setText("Ready!");

		TextView value2Label = (TextView) findViewById(R.id.row2name);
		value2Label.setText("Value 2:");

		// We can change the background color of the text by using
		// setBackgroundColor
		TextView value2 = (TextView) findViewById(R.id.row2value);
		value2.setText("Hello World!");
		value2.setBackgroundColor(Color.DKGRAY);

		TextView value3Label = (TextView) findViewById(R.id.row3name);
		value3Label.setText("Value 3:");

		// We can also change the color of the text by using setTextColor
		TextView value3 = (TextView) findViewById(R.id.row3value);
		value3.setText("Oh no!");
		value3.setTextColor(Color.RED);

		// setVisibility lets you hide or show an entire view. Use
		// View.INVISIBLE to hide a view and View.VISIBLE to bring it back.
		// There is also View.GONE, which is similar to INVISIBLE, but means
		// the view won't be considered when laying out other views, which
		// could affect how the rest of your layout looks.
		TextView value4Label = (TextView) findViewById(R.id.row4name);
		value4Label.setText("Invisible");
		value4Label.setVisibility(View.INVISIBLE);

		// You can also set the size of text in a TextView
		TextView value5 = (TextView) findViewById(R.id.row4value);
		value5.setText("BIG");
		value5.setTextSize(24f);

		// setHint just changes the grey text that shows up before you type
		// anything into an EditText box.
		EditText submission = (EditText) findViewById(R.id.submissionText);
		submission.setHint("Type submission here");

		// setOnClickListener tells the button whose onClick to call when
		// you click on it. Here, we're telling it to call the onClick in
		// this Activity. If you don't set a listener, the button won't do
		// anything.
		// The click listener has to be a class that implements the java
		// interface OnClickListener, which is why you see
		// implements OnClickListener
		// in the class signature at the top of this Activity class.
		// If this doesn't make sense, read up on Java interfaces and why
		// they're important!
		Button submitButton = (Button) findViewById(R.id.submitButton);
		submitButton.setOnClickListener(this);
		
		// The GPS Service runs independently of the applications 
		// activities.  The bindService() function allows this 
		// activity to interact to the GPS service to retrieve location  
		// information. 
		Intent serviceIntent = new Intent(this, GPSService.class);
        bindService(serviceIntent, this, Context.BIND_AUTO_CREATE);
	}
	
//	/**
//	 * This activity goes to the background.  The activity is running and active.
//	 */
//	@Override
//	protected void onPause() {
//      unbindService(this);
//		super.onPause();
//	}

	/**
	 * This activity returns to the foreground.  The activity becomes active.
	 */
	@Override
	protected void onResume() {
		// Rebind activity to gps service
		Intent mServiceIntent = new Intent(this, GPSService.class);
        bindService(mServiceIntent, this, Context.BIND_AUTO_CREATE);
		super.onResume();
	}
	
	/**
	 * The activity is finished running
	 */
	@Override
	protected void onStop() {
		super.onStop();
		unbindService(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	public void onClick(View view) {
		// In this example, we only have one button. However, if you had
		// several buttons, all of them set to use this Activity as their click
		// listener, you can figure out which button was clicked by doing a
		// switch() on the button's view id.
		switch (view.getId()) {

		case R.id.submitButton:
			// Get the text we want to submit
			String textToSubmit = getTextToSubmit();

			// Actually do the submitting
			submitText(textToSubmit);

			// The following two lines are just some code to make the soft
			// keyboard hide when you press the submit button. Feel free to
			// look up how SystemServices work, but for now you can just
			// copy and paste these lines anywhere you just want to make the
			// keyboard go away.
			InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			inputManager.hideSoftInputFromWindow(getCurrentFocus()
					.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
			break;

		// Here you could add more cases for any other buttons you may
		// add. Make sure to put a break; after each case!
		}
	}

	/**
	 * Generates the text to submit
	 * 
	 * @return the text to be submitted
	 */
	private String getTextToSubmit() {
		// This is just an example of how you may want to split out some of
		// your larger tasks into smaller chunks to logically break down the
		// problem into simpler and easier-to-read pieces.

		EditText submission = (EditText) findViewById(R.id.submissionText);
		return submission.getText().toString();
	}

	/**
	 * Performs the actual submission of text
	 * 
	 * @param text
	 *            the text to be submitted
	 */
	private void submitText(String text) {
		TextView value2 = (TextView) findViewById(R.id.row2value);
		value2.setText(text);
	}
	
	
	
	
	
	// As a GPSServiceListener this activity must implement the following functions
	// 		onServiceConnected()
	//		onServiceDisconnected()
	//		onLocationChanged()
	/**
	 * Called when the connection with the GPS service is established
	 * 
	 * @param ComponentName
	 * @param service binder
	 */
	@Override
    public void onServiceConnected(ComponentName className, IBinder binder) {
        // Because we have bound to an explicit
        // service that is running in our own process, we can
        // cast its IBinder to a concrete class and directly access it.
		Toast.makeText(getBaseContext(), "GPS service connected", Toast.LENGTH_SHORT).show();
		GPSService.LocalBinder gpsBinder = (GPSService.LocalBinder) binder;
		GPSService gpsService = gpsBinder.getService();
		gpsService.addGPSListener(NavigationActivity.this);
    }

	/**
	 * Called when the connection with the GPS service disconnects
	 * 
	 * @param classname
	 */
    @Override
    public void onServiceDisconnected(ComponentName className) {
    	if(gpsService != null) 
    	{
    		gpsService.removeGPSListener(NavigationActivity.this);
    	}
    }

	/**
	 * Takes action on each new location update
	 * 
	 * @param location 
	 */
	@Override
	public void onLocationChanged(Location location) {
		double latitude = location.getLatitude();
		double longitude = location.getLongitude();
		double altitude = location.getAltitude();
		float accuracy = location.getAccuracy();
		
		// Use Toast to display a messages briefly. It is a great tool
		// for debugging.  It is useful for determining the details of
		// an event such as a button press as well as when it occurred.  
		// However Android's Log tool is a better alternative for
		// debugging multiple recurring events and application crashes. 
		// Set this variable to true to view the GPS toast message.
		boolean GPS_show_updates = true;
		if(GPS_show_updates)
		{
			Toast.makeText(getBaseContext(), 
				"Latitude: "+latitude+
				"; Longitude: "+longitude+
				"; Altitude: "+altitude+
				"; Accuracy: "+accuracy,
                Toast.LENGTH_SHORT).show();
		}
		Log.i("BRATA", 
			"Latitude: "+latitude+
			"; Longitude: "+longitude+
			"; Altitude: "+altitude+
			"; Accuracy: "+accuracy);
		
		//TODO:  Use the location coordinates to do something useful
		
		new Handler().post(new Runnable() {
			public void run() {
				// Update the user interface
				updateUI();
			}
		});
	}
	
	private void updateUI() {
		
	}
}
