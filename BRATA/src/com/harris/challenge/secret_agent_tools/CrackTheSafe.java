package com.harris.challenge.secret_agent_tools;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.harris.challenge.brata.R;


public class CrackTheSafe extends Activity{
	AlertDialog dialog;
	Button buttonStartChallenge;
	
	/**
	 * Function used for initializing activity variables, such as 
	 * widgets that need to be interactive. 
	 */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // load the xml layout before initializing widgets
        setContentView(R.layout.activity_crack_the_safe);

		buttonStartChallenge = (Button)findViewById(R.id.buttonCtsStartChallenge);
		buttonStartChallenge.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				/**
				 * Either of these functions can be used to send and/or get messages from the MasterServer.
			     * 
			     * MasterServerCommunicator.getInstructionUsingQR(ActivityName.this);
			     * MasterServerCommunicator.sendMessageUsingQR(ActivityName.this, message);
			     * 
			     * In this case the MasterServer will update your progress and send back a clue that must
			     * be decoded. The decoded string MessageDecoder.decodedMessage is a public variable that 
			     * should be displayed on all challenge activities. See MessageDecoder.java for details 
			     * about messages received from the MasterServer.
			     */
				MasterServerCommunicator.getInstructionUsingQR(CrackTheSafe.this);
			}
		});
    }
	
	/**
	 * Function which handles the result from another activity for a measured angle.
	 * 
	 * @param requestCode: Can be used to check this is the response for the correct request.
	 * @param resultCode: Can be used to check the success status of the request
	 * @param intent: The intent containing the result
	 * 
	 * Note: 
	 * Use the function below to start the appropriate BRATA tool activity 
	 * which can measure an angle and return the angle as result.  The function 
	 * should be called in the onClickListener of the measure angle button.
	 * 
	 * startActivityForResult(BrataToolActivity.class, 0);
	 * 
     * In response to startActivityForResult(...) this function, onActivityResult(..., Intent intent) 
     * is called when the activity fulfilling the request finishes.  This function should try to get 
     * the result returned in the Intent. The Brata tool activity or the activity serving a request, 
     * should set the result (in this case the measured angle) and exit, returning to the requesting 
     * activity like so.  
	 * 
	 * double value = .. // Some value we want to return  
	 * Intent result = new Intent();              
	 * result.putExtra(<key_string>, value);
     * setResult(Activity.RESULT_OK, result);
     * finish();
     * 
     * The result can be extracted using the using a method like this:
	 * 
	 * double value = intent.getDoubleExtra(<key_string>, ...);
	 * 
     * <key_string> must match in the requesting and serving activities to get a valid result value.
     * This method for communicating between activities will be used with other 
     * SAT challenges to get results from Brata tools.
	 */
	// 
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
		super.onActivityResult(requestCode, resultCode, intent);
		
		// Extract the Brata tool's result from the intent
		double value = intent.getDoubleExtra("MEASURE_ANGLE_RESULT", Double.MIN_VALUE);
		if (Double.MIN_VALUE != value)
		{
			Log.d("Brata", "Measured angle is " + value + " CrackTheSafe::onActivityResult().");
			// Display the value in the appropriate widget
		} 
		else 
		{
			// Use LogCat output to view the sequence of events using Log statements in Android.  
			// Open Window > Show View > Other... In the dialog select Android > LogCat and click OK.
			Log.d("Brata", "Failed to get result in CrackTheSafe::onActivityResult().");
		}
	}
	
	
	/**
     * This function should be called from the onClickListener of a compute button.  This
     * function should test all possible 3 permutations of the 5 measured angles on myHash() 
     * The correct answer will be a set of 3 digits in a specific order that gets myHash() to 
     * returns a string matching the 4 character clue. Display the answer on the screen. Once you 
     * are sure you have the right answer you should send it as a message to the master server.
     * 
     * @param a-e: the measured angles to check
     */
	public void computeCtsAnswer(int a, int b, int c, int d, int e)
	{
		// Check result from myHash(a, b, c) until it returns the 4 character clue 
	}
	
	/**
     * Return a hash key given 3 integers.  Used to create a simple hash key 
     * string given 3 integers. The integers are angles in the range 0..90. 
     * No need for modification.
     */
	public static String myHash( int a, int b, int c ) {	    
	    String XLATE = "BCDGHJKLMNPQRSTVWZbcdghjkmnpqrstvwz";
	    int h = (a*127 + b)*127 + c;
	    char[] k = new char[4];
	    for ( int i = 0; i < 4; i++ ) {
	        k[i] = XLATE.charAt(h % XLATE.length());
	        h = h / XLATE.length();
	    }
	    return new String( k );
	}

// May not need this
//	/**
//     * Function for calculating and displaying 
//	 * 
//	 * @param code: Array of 3 digits in the order needed to generate the clue 
//	 *        using myHash()
//     */
//	void computeAnswer(int[] code)
//	{
//		String message = "Insert correctly formatted message containing the code.";
//		MasterServerCommunicator.sendMessageUsingQR(CrackTheSafe.this, message);
//	}
//	
	
	/**
     * Display a dialog for confirmation before leaving this activity 
     * using the back button.  The back button with exit this activity
     * eliminating any progress made between challenge checkpoints.
     */
//	@Override
//	public void onBackPressed() {
//		super.onBackPressed();
//		
//		// Use the Builder class for convenient dialog construction
//		// Create the AlertDialog object and return it
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Closing Activity").
//           setMessage("Any recorded values will be lost!").
//    	   setPositiveButton("", new DialogInterface.OnClickListener() {
//              public void onClick(DialogInterface dialog, int id) {
//                 finish();
//              }
//           });
//        dialog = builder.create();
//        
//        // Temporarily disable the affirmative button as a safeguard
//        Button button = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
//    	button.setEnabled(false);
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            public void run() {
//            	Button button = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
//            	button.setEnabled(true);
//            }   
//        }, 1500);
//	}
}
