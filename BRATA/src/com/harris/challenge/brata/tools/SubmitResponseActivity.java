package com.harris.challenge.brata.tools;

import com.harris.challenge.brata.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * This is an example activity for submitting responses to the beacon server. This
 * example doesn't actually do any useful work for you, it just provides a few
 * input and output examples so you can quickly try out your design.
 * 
 * This Activity, unmodified, is intentionally not very pretty or useful. It's
 * up to you to make it implement your awesome design and look great while 
 * doing it! * 
 * 
 * @author Harris Corporation
 */
public class SubmitResponseActivity extends Activity implements OnClickListener{
	
    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     * 
     * This will be called whenever this activity is created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // This applies the layout specified in 
        //   res->layout->activity_request_clue.xml
        // to our Activity. We can now find views within that layout and
        // manipulate them. Don't try to call findViewById() before this!
        setContentView(R.layout.activity_submit_response);
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
    	
    	}
    }   

}
