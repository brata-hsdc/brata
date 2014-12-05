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

package com.harris.challenge.brata.tools;

import com.harris.challenge.brata.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This is an example activity for requesting clues from the clue server. This
 * example doesn't actually do any useful work for you, it just provides a few
 * input and output examples so you can quickly try out your design.
 * 
 * This Activity, unmodified, is intentionally not very pretty or useful. It's
 * up to you to make it implement your awesome design and look great while 
 * doing it! * 
 * 
 * @author Harris Corporation
 */
public class RequestAssignmentActivity extends Activity implements OnClickListener{

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
        setContentView(R.layout.activity_request_clue);
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
    
    /**
     * Performs the actual submission of text
     * 
     * @param text
     *         the text to be submitted
     */
    private void submitText(String text) {
        
        String MyRequestMessage = text; 
        
        // TODO - DON'T LEAVE THIS VALUE AT 5556!
        // Make sure this function gets updated to put in a real beacon phone number 
        // into BeaconPhoneNumber!
        // HINT This function may have to be updated to take in another parameter.
        String BeaconPhoneNumber = "5556";  
        
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(BeaconPhoneNumber, null, MyRequestMessage, null, null);
    }
    
    // These two variables should always contain the last decoded response
    // (even if you leave and return to this activity).
    // If you would like to keep track of more than just the last one,
    // you may have to implement some type of response logger.    
    static String myResponse = "N/A";  
    static TextView ResponseTextView = null;
    
    /**
     * this function will be automatically called each time the beacon sends a message
     * to our BRATA app.  It should be used to decode the clue and display it on the screen.
     * 
     * @param EncodedClue
     *         the encoded clue
     */
    public static void DecodeReceivedMsg(String encodedMsg, Context context)
    {
        if (ResponseTextView != null)
        {
            String decodedMsg = encodedMsg;

            /*
             * 
             * Put clue decoding logic here
             * by the end of your code the 
             * decoded text string should 
             * be in your decodedClue variable
             * 
             */

            myResponse = decodedMsg;

            ResponseTextView.setText(myResponse);

             // this code will cause a brief message to be displayed on the screen
             Toast.makeText(context, "Msg Decoded : "+ myResponse, 
                            Toast.LENGTH_LONG).show();
        }
    } 
    
    /**
     * Gets called when back button is pressed
     *      
     */    
    public void onBackPressed()
    {
        ResponseTextView = null;
        finish();
    }     
}
