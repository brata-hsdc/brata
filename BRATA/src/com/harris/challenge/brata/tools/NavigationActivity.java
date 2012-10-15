/**
 * 
 */
package com.harris.challenge.brata.tools;

import com.harris.challenge.brata.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * @author Andrew
 * 
 */
public class NavigationActivity extends Activity implements OnClickListener {

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

	}

	@Override
	protected void onPause() {
		// Acquire a reference to the system Location Manager
		LocationManager locationManager = (LocationManager) this
				.getSystemService(Context.LOCATION_SERVICE);
		// Register the listener with the Location Manager to receive location
		// updates
		locationManager.removeUpdates(locationListener);
		super.onPause();
	}

	@Override
	protected void onResume() {
		// Acquire a reference to the system Location Manager
		LocationManager locationManager = (LocationManager) this
				.getSystemService(Context.LOCATION_SERVICE);
		// Unregister the listener with the Location Manager to stop receiving
		// location updates
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0,
				0, locationListener);
		super.onResume();
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

	/*
	 * This section
	 */
	// Define a listener that responds to location updates
	LocationListener locationListener = new LocationListener() {
		public void onLocationChanged(Location location) {
			// Called when a new location is found by the network location
			// provider.
			makeUseOfNewLocation(location);
		}

		public void onStatusChanged(String provider, int status, Bundle extras) {
		}

		public void onProviderEnabled(String provider) {
		}

		public void onProviderDisabled(String provider) {
		}
	};

	/**
	 * Takes action on each new location update
	 * 
	 * @param location 
	 */
	private void makeUseOfNewLocation(Location location) {
		double latitude = location.getLatitude();
		double longitude = location.getLongitude();
		double altitude = location.getAltitude();
		
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
