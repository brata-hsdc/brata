package com.harris.challenge.secret_agent_tools;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;

import com.harris.challenge.brata.R;


/**
 * Note: 
 * Some SAT challenges will require you to perform a task by starting a new activity on top of the 
 * current activity then return to the first activity once finished.  For example, in an activity 
 * you might start a challenge then use a brata tool to navigate to a location and return the SAT 
 * activity to proceed with the challenge.
 * 
 * Two ways to do this would be to call, from the originating activity, 
 * 'startActivity(new Intent(this, BrataToolActivity.class))' or 
 * 'startActivityForResult(BrataToolActivity.class, 0)' if a result is needed.  In response to 
 * 'startActivityForResult(...)', use 'onActivityResult(..., Intent intent)' in the originating 
 * activity to retrieve task results from the intent. In either, case after the task is done you 
 * must call 'finish()' to return to the originating activity.
 * 
 * You may pass data to the new activity and/or back to the original activity by inserting data 
 * into the intent like so:
 * 
 * Intent intent = new Intent();
 * intent.putExtra(<key_string>, "Some data as a string");
 * setResult(RESULT_OK, intent);
 * 
 * Within an activity the data can be extracted from the intent like so; (<key_string> must match 
 * when inserting an extracting data)
 * 
 * String data = intent.getStringExtra(<key_string>, ...);
 */

public class FindTheSecretLaboratory extends Activity{
	AlertDialog dialog;
	
	/**
	 * Function used for initializing activity variables, such as 
	 * widgets that need to be interactive. 
	 */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // load the xml layout before initializing widgets
        setContentView(R.layout.activity_find_the_secret_laboratory);
    }
    
	/**
	 * If the activity gets onResume update the screen with the decoded MasterServer response data.  This 
	 * event will be triggered after MasterServerCommunicator.getInstructionUsingQR() or 
	 * MasterServerCommunicator.sendMessageUsingQR() has returned with a result.  The decoded string 
	 * MessageDecoder.decodedMessage is a public variable that should be displayed on all challenge 
	 * activities. See MessageDecoder.java for details about messages received from the MasterServer.
	 */
	@Override
	protected void onResume() {
		super.onResume();
		// Here update the correct TextView with MessageDecoder.decodedMessage any time the activity is resumed.
	}
    
	/**
     * Display a dialog for confirmation before leaving this activity 
     * using the back button.  The back button with exit this activity
     * eliminating any progress made between challenge checkpoints.
     */
	@Override
	public void onBackPressed() {
		// Use the Builder class for convenient dialog construction
		// Create the AlertDialog object and return it
        dialog = new AlertDialog.Builder(this)
        	.setTitle("Close Activity")
        	.setMessage("Any recorded values will be lost!")
        	.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface dialog, int id) {
                 finish();
              }
    		})
    		.setNegativeButton("No", null)
    		.create();
        dialog.show();
        
        // Temporarily disable the affirmative button as a safeguard
        Button button = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
    	button.setEnabled(false);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
            	Button button = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
            	button.setEnabled(true);
            }   
        }, 2000);
	}
}