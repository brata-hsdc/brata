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
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.harris.challenge.brata.R;

public class RegistrationTool extends Activity {

    
    /**
     * Registration tool widgets 
     */
    Button buttonSubmitRegistration;
    TextView textEncodedMessage;
    TextView textDecodedMessage;
            
    /**
     * Initialize registration widgets after activity creation
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_registration);
        
        textEncodedMessage = (TextView)findViewById(R.id.text_encodedMsg);
        textEncodedMessage.setText( MessageDecoder.encodedMessage);
        textDecodedMessage = (TextView)findViewById(R.id.text_decodedMsg);
        textDecodedMessage.setText( MessageDecoder.decodedMessage);
        
        buttonSubmitRegistration = (Button)findViewById(R.id.button_SubmitTeamID);
        buttonSubmitRegistration.setEnabled(true);
        buttonSubmitRegistration.setOnClickListener(new Button.OnClickListener() {
            
            @Override
            public void onClick(View v) {
                // Register via scan of registraation QR code

                MasterServerCommunicator.getInstructionUsingQR(RegistrationTool.this);
            }
        });
    }
    
    /**
     * If the activity get onResume after returning to the foreground update the 
     * MasterServer response data on the screen.  This event will be triggered after 
     * MasterServerCommunicator.getMessageUsingQR() has returned with the result.
     */
    @Override
    protected void onResume() {
        // Auto-generated method stub
        super.onResume();
        Log.e("BRATA", "MasterServerCommunicator  onResume");
        
        textEncodedMessage.setText( MessageDecoder.encodedMessage);
        textDecodedMessage.setText( MessageDecoder.decodedMessage);
    }
    
    
}
