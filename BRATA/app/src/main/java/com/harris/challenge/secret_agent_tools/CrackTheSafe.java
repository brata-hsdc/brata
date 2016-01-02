package com.harris.challenge.secret_agent_tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

import com.harris.challenge.brata.BrataLauncherActivity;
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
                 * be decoded. 
                 */
                MasterServerCommunicator.getInstructionUsingQR(CrackTheSafe.this);
            }
        });
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
     * This function should test all possible 3 permutations of the 5 measured angles on myHash() 
     * The correct answer will be a set of 3 digits in a specific order that gets myHash() to 
     * returns a string matching the 4 character clue. 
     * 
     * @param clue: the clue to check against
     * @param a-e: the measured angles to check
     * @return The computed answer as a formatted string
     */
    public String computeCtsAnswer(String clue, int a, int b, int c, int d, int e)
    {
        String result = null;
        // Check result from myHash(a, b, c) until it returns a string matching the 4 character clue 
        return result;
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