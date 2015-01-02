/*------------------------------------------------------------------------------
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *------------------------------------------------------------------------------
 */

package com.harris.challenge.secret_agent_tools;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.harris.challenge.brata.R;
import com.harris.challenge.brata.framework.IntentIntegrator;
import com.harris.challenge.brata.framework.IntentResult;
import com.harris.challenge.brata.framework.ServerQueryTask;

public class MasterServerCommunicator extends Activity{    
    
    final static String MESSAGE_TO_SEND = "MESSAGE_TO_SEND";
    
    /**
     * Initiate the process of scanning a QR code and decoding the returned response.  
     * Static method available for all SAT Challenge activities to use.
     * 
     * @param activity  The calling activity (Input for this parameter usually 
     *                     will be 'this'). 
     */
    public static void getInstructionUsingQR(Activity activity)
    {
        sendMessageUsingQR(activity, "");
    }
    
    /**
     * Initiate the process of scanning a QR code, sending the message to the 
     * MasterServer and decoding the returned response.  Static method available 
     * for all SAT Challenge activities to use.
     * 
     * @param activity  The calling activity (Input for this parameter usually 
     *                     will be 'this'). 
     * @param message     The string message to send to the master server after 
     *                     the QR code URL has been returned.
     */
    public static void sendMessageUsingQR(Activity activity, String message)
    {
        Intent intent = new Intent(activity, MasterServerCommunicator.class);
        intent.putExtra(MESSAGE_TO_SEND, message);
        activity.startActivity(intent);
    }
    
    /**
     * MasterServer activity is started.  This activity currently will immediately 
     * initiate an intent to scan a QR code. No need for a layout.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IntentIntegrator.initiateScan(this);
    }
    
    /**
     * Handle data received from the QR Code reader.  Interpret the result 
     * and on success send QR code message to MasterServer.  If anything fails 
     * return to the calling activity with finish().
     */
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        
        // Validate QRCode reader intent result and inputs for communication with MasterServer
        if(requestCode != IntentIntegrator.REQUEST_CODE && resultCode == RESULT_CANCELED) {
            Log.w("BRATA", "MasterServerCommunicator  onActivityResult() - "
                    + "Activity result canceled or unexpected request code.");
            finish();
            return;
        }
        
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (scanResult == null) {
            Log.w("BRATA", "MasterServerCommunicator  onActivityResult() - "
                    + "Returned scanResult is null.");
            finish();
            return;
        }
        
        String message = getIntent().getStringExtra(MESSAGE_TO_SEND);
        if (message == null) {
            Log.w("BRATA", "MasterServerCommunicator  onActivityResult() - "
                    + "Returned message is null.");
            finish();
            return;
        }
        
        SharedPreferences settings = getSharedPreferences(getResources().getString(R.string.app_name), 0);
        String teamId = settings.getString(RegistrationTool.TEAM_ID_KEY, "");
        if(teamId == "")
        {
            Log.w("BRATA", "MasterServerCommunicator  onActivityResult() - "
                    + "Team ID is invalid.");
            finish();
            return;
        }
        
        // Get the message to send and the URL from the QR code and 
        // Send message to MasterServer with the team ID
        Log.i("BRATA", "MasterServerCommunicator  onActivityResult() - QRcode result received.");
        String QRMessageUrl = scanResult.getContents();
        ServerQueryTask serverQueryTask = new ServerQueryTask(this, QRMessageUrl, teamId);
        serverQueryTask.execute(message);
    }
}
