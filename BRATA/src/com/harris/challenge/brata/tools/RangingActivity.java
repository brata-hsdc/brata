/**
 * 
 */
package com.harris.challenge.brata.tools;

import com.harris.challenge.brata.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

/**
 * @author Andrew
 *
 */
public class RangingActivity extends Activity {
	// Distance in meters of earth's equitorial radius
	final float EARTH_EQUITORIAL_RADIUS_METERS = 63781370.0f;
	
	// We will be basing our calculations on this constant for earth's 
	// radius assuming a perfect sphere and ignoring any elliptical adjustments.
	// You may also assume that the curvature of the earth is negligible for
	// distances we need to measure (If so use latitude and longitude distances
	// appropriate for Melbourne FL.)
	
	
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
		setContentView(R.layout.activity_ranging);
		
		/*
		 * This activity needs widgets that can take input of 2 sets of latitude and 
		 * longitude coordinates.
		 * 
		 * Initialize widgets from layout resources here using findViewById().
		 * For functional widgets assign the widgets an action listener function 
		 * defined by this activity.    
		 */
	}
	
	/*
	 * Need some method for calculating the distance between 
	 * 2 sets of latitude and longitude coordinates. That method could 
	 * follow the format of this function.
	 */
	public double calculateDistance(double latitude_A, double longitude_A, double latitude_B, double longitude_B)
	{
		return 0.0;
	}
	
	/*
	 * This function could be used to update any layout elements 
	 * each time the distance between coordinates has been calculated
	 */
	public void UpdateUI()
	{
		
	}
	
	
	
	
	
	
	
	
    /* (non-Javadoc)
     * @see android.view.View.OnClickListener#onClick(android.view.View)
     */
    public void onClick(View view) {
    	// In this example, we only have one button. However, if you had 
    	// several buttons, all of them set to use this Activity as their click
    	// listener, you can figure out which button was clicked by doing a
    	// switch() on the button's view id.
    	switch(view.getId()) {
    	
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
    		InputMethodManager inputManager = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE); 
    		inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                       InputMethodManager.HIDE_NOT_ALWAYS);
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
     * 		the text to be submitted
     */
    private void submitText(String text) {
        TextView value2 = (TextView) findViewById(R.id.row2value);
        
        // this will cause the message you here you can see the message you sent
        value2.setText(text);
        
        String MyRequestMessage = text; 
        
        // TODO - DON'T LEAVE THIS VALUE AT 5556!
        // Make sure this function gets updated to put in a real beacon phone number 
        // into BeaconPhoneNumber!
        // HINT This function may have to be updated to take in another parameter.
        String BeaconPhoneNumber = "5556";  
        
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(BeaconPhoneNumber, null, MyRequestMessage, null, null);
    }
	
}
