/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.harris.challenge.brata.tools;

import com.harris.challenge.brata.R;
import com.harris.challenge.brata.framework.IntentIntegrator;
import com.harris.challenge.brata.framework.IntentResult;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Used to scan and decode QR codes
 * 
 * @author Harris Corporation
 *
 */
public class QRCodeReaderActivity extends Activity {    
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // This applies the layout specified in 
        //   res->layout->activity_request_clue.xml
        // to our Activity. We can now find views within that layout and
        // manipulate them. Don't try to call findViewById() before this!
        setContentView(R.layout.activity_qr_reader);
    }
    
    /**
	 * The framework provides the capability to launch a QR Code Scanner.
	 * In order to invoke the QR Code Scanner call this function.
	 */
    private void scanCode()
    {
    	// This function automatically starts a scanner activity
    	IntentIntegrator.initiateScan(QRCodeReaderActivity.this);
    }
    
    /**
	 * After the QR Code Scanner has read a code successfully it will finish
	 * and return to this activity.  The Scanner Activity will return the the 
	 * result of the scan by calling this function.  
	 */
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	if(requestCode == IntentIntegrator.REQUEST_CODE && resultCode != RESULT_CANCELED) {
	    	IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
	    	if (scanResult != null) {
	    		// Use scanResult.getContents() to store the result in a string
		    	String result = scanResult.getContents();
		    	
		    	/*
		    	 * Do something with the scanned message
		    	 */
	    	}
    	}
    }
}
