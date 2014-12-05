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

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.harris.challenge.brata.R;
import com.harris.challenge.brata.framework.IntentIntegrator;
import com.harris.challenge.brata.framework.IntentResult;

/**
 * Used to scan and decode QR codes
 * 
 * @author Harris Corporation
 *
 */
public class QRCodeReaderActivity extends Activity{  
    Button scanCodeButton;

    private String httpBase = "http://";
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // This applies the layout specified in 
        //   res->layout->activity_request_clue.xml
        // to our Activity. We can now find views within that layout and
        // manipulate them. Don't try to call findViewById() before this!
        setContentView(R.layout.activity_qr_reader);
        scanCodeButton = (Button)findViewById(R.id.scanCodeButton);
        scanCodeButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                scanCode();
            }
        });
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
                 * Launch webview if result is URL
                 */
                if(result.contains("www."))
                {
                    launchWebView(result);
                }
            }
        }
    }
    
    /*
     * This method actually does the work of kicking off the browser.
     * 
     * NOTE: The URL MUST have an http:// prefix so that the OS knows to load the browser and not a different system activity.
     * */
    private void launchWebView(String url)
    {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
