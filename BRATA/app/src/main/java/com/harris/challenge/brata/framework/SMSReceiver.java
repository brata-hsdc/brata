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

package com.harris.challenge.brata.framework;

import com.harris.challenge.brata.tools.RequestAssignmentActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

/**
 * Broadcast receiver to intercept SMS messages before they are passed on to
 * the default SMS app on the device.
 * 
 * @author Harris Corporation
 *
 */
public class SMSReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) 
    {
         Bundle pudsBundle = intent.getExtras();
         Object[] pdus = (Object[]) pudsBundle.get("pdus");
         SmsMessage messages =SmsMessage.createFromPdu((byte[]) pdus[0]);    
         
         // this code will cause a brief message to be displayed on the screen
         Toast.makeText(context, "Encoded Msg Received! ", Toast.LENGTH_LONG).show();

         //  send's our encoded clue to our RequestClueActivity & SubmitRequestActivity
         //  only the current active activity will process it...
         RequestAssignmentActivity.DecodeReceivedMsg(messages.getMessageBody(), context);  
    }
}
