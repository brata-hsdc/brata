package com.harris.challenge.secret_agent_tools;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.harris.challenge.brata.R;

public class RegistrationTool extends Activity {
	
	public static String TeamRegistrationId = "";
	EditText editTextTeamId;
	Button buttonSubmitRegistration;
			
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_registration);
        
        editTextTeamId = (EditText)findViewById(R.id.editText_TeamId);
        editTextTeamId.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// Auto-generated method stub
				TeamRegistrationId = s.toString();
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				// Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// Auto-generated method stub
				
			}
		});
        
        
        buttonSubmitRegistration = (Button)findViewById(R.id.button_SubmitTeamID);
        buttonSubmitRegistration.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Auto-generated method stub
				MasterServerCommunicator.getMessageUsingQR(RegistrationTool.this, TeamRegistrationId);
			}
		});
	}
	
	
	@Override
	protected void onPause() {
		// Auto-generated method stub
		super.onPause();
		Log.e("BRATA", "RegistrationTool  onPause");
	}
	
	@Override
	protected void onResume() {
		// Auto-generated method stub
		super.onResume();
		Log.e("BRATA", "RegistrationTool  onResume");
	}
}
