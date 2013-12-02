/**
 * 
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
