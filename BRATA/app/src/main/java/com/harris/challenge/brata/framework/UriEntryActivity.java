package com.harris.challenge.brata.framework;

import com.harris.challenge.brata.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class UriEntryActivity extends Activity {

	EditText submitText;
	Button submitButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_uri_entry);
		
		submitButton = (Button)findViewById(R.id.button_SubmitMSURI);
		submitText = (EditText)findViewById(R.id.button_EditMSURI);
		submitButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
			    intent.putExtra("SCAN_RESULT", submitText.getText().toString());
			    setResult(RESULT_OK, intent);
			    finish();
				
			}
		});
	}
}
