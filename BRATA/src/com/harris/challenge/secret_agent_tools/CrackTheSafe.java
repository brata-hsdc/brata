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
        Log.d("Brata", myHash( 70, 49,  1 ));
        Log.d("Brata", myHash( 35, 82, 49 ));
   		Log.d("Brata", myHash(  9, 26, 48 ));
   		Log.d("Brata", myHash( 53, 43, 12 ));
		Log.d("Brata", myHash(  5, 88, 78 ));
		Log.d("Brata", myHash( 17, 56, 79 ));
		Log.d("Brata", myHash( 47, 18,  8 ));
		Log.d("Brata", myHash( 34, 14, 23 ));
		Log.d("Brata", myHash( 79, 63, 13 ));
		Log.d("Brata", myHash( 68, 59, 12 ));
		
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
     * Function used to test all possible permutation for 3 of the 5 measured 
     * angles to see if it matches the 4 character clue.  If the function
     * returns the correct 3 ordered digits this should be displayed on the screen. 
     * This function should be called from the onClickListener of the check code button.
     * 
     * @param a-e: the measured angles to check
     * @return If successful should return an array of 3 digits in the order 
     * needed to generate the clue using myHash(). Otherwise return null.
     */
	public int[] checkPermutations(int a, int b, int c, int d, int e)
	{
		int[] safeDigits = null;
		// Check result from myHash(a, b, c)
		// If no permutations produce the 4 character clue using myHash() then return null
		// Otherwise return the 3 digits in the array with the order that produces the clue string 
		return safeDigits;
	}
	
	/**
     * Return a hash key given 3 integers.  Used to create a simple hash key 
     * string given 3 integers. The integers are angles in the range 0..90. 
     * No need for modification.
     */
	public static String myHash( int a, int b, int c ) {
	    // The following can be used to "test" for Python equivalence
	    //   myHash( 70, 49,  1 ) = "rmWn"    myHash( 35, 82, 49 ) = "wRTS"
	    //   myHash(  9, 26, 48 ) = "KMWG"    myHash( 53, 43, 12 ) = "PPDd"
	    //   myHash(  5, 88, 78 ) = "kBJD"    myHash( 17, 56, 79 ) = "ckcK"
	    //   myHash( 47, 18,  8 ) = "ZkmZ"    myHash( 34, 14, 23 ) = "hHrR"
	    //   myHash( 90,  9, 58 ) = "twsw"    myHash( 81, 55, 23 ) = "RLhs"
	    //   myHash( 75, 20, 31 ) = "gdNq"    myHash( 63, 34,  1 ) = "gBqj"
	    //   myHash( 13, 56,  4 ) = "GzCJ"    myHash( 89, 49, 16 ) = "Bvgw"
	    //   myHash( 34, 72, 87 ) = "vKBS"    myHash( 37, 46, 76 ) = "nzCT"
	    //   myHash( 70, 86, 26 ) = "qddn"    myHash( 16, 78, 27 ) = "DpMK"
	    //   myHash( 79, 63, 13 ) = "Vktr"    myHash( 68, 59, 12 ) = "pVnm"
	    
	    String XLATE = "BCDGHJKLMNPQRSTVWZbcdghjkmnpqrstvwz";

	    int h = (a*127 + b)*127 + c;
	    char[] k = new char[4];
	    for ( int i = 0; i < 4; i++ ) {
	        k[i] = XLATE.charAt(h % XLATE.length());
	        h = h / XLATE.length();
	    }
	    return new String( k );
	}
	
	/**
     * Function for sending correct answer to MasterServer. This function 
	 * should be called in the onClickListener of the solve button. 
	 * 
	 * @param code: Array of 3 digits in the order needed to generate the clue 
	 *        using myHash()
     */
	void crackTheSafe(int[] code)
	{
		String message = "Insert correctly formatted message containing the code.";
		MasterServerCommunicator.sendMessageUsingQR(CrackTheSafe.this, message);
	}
	
	
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
