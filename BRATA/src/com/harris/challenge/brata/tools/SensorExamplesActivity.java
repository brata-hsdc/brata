/**
 * 
 */
package com.harris.challenge.brata.tools;

import com.harris.challenge.brata.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * @author Andrew
 *
 */
public class SensorExamplesActivity extends Activity implements OnClickListener{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_request_clue);
        
        Button submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(this);

    }
    
    @Override
    protected void onSaveInstanceState(Bundle outState) {
    	super.onSaveInstanceState(outState);
    }
    
    /* (non-Javadoc)
     * @see android.view.View.OnClickListener#onClick(android.view.View)
     */
    public void onClick(View view) {
    	switch(view.getId()) {
    	
    	case R.id.submitButton:
    		//TODO: handle what happens when the submit button is pressed
    		break;
    	}
    }

}
