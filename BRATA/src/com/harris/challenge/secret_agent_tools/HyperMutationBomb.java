package com.harris.challenge.secret_agent_tools;

import com.harris.challenge.brata.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;

public class HyperMutationBomb extends Activity{
    AlertDialog dialog;
    
    /**
     * Function used for initializing activity variables, such as 
     * widgets that need to be interactive. 
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // load the xml layout before initializing widgets
        setContentView(R.layout.activity_hypermutation_bomb);
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
     * This function should calculate the overall period at which the 3 input measured 
     * periods sync up.  It should return a formated string containing the answer.
     * 
     * @param clue: the clue to check against
     * @param a-e: the measured angles to check
     * @return The computed answer as a formatted string
     */
    String computeHmbAnswer(int period1, int period2, int period3)
    {
        String result = "";
        return result;
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