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

package com.harris.challenge.brata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.view.View.OnClickListener;


public class MainLauncher extends Activity implements OnClickListener{
	
	  TextView incidentsLauncher;
	  TextView brataToolsLauncher;
	  TextView secretAgentToolsLauncher;
	
	  /** Called when the activity is first created. */
	  @Override
	  public void onCreate(Bundle savedInstanceState)
	  {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.activity_main_launcher);
	        
	        //setup buttons
	        incidentsLauncher = (TextView) findViewById(R.id.launchIndicents);
	        brataToolsLauncher = (TextView) findViewById(R.id.launchTools);
	        secretAgentToolsLauncher = (TextView) findViewById(R.id.LaunchChallenges);
	        
	        //setup click listeners
	        incidentsLauncher.setOnClickListener(this);
	        brataToolsLauncher.setOnClickListener(this);
	        secretAgentToolsLauncher.setOnClickListener(this);
	        
	  }

	@Override
	public void onClick(View view) {
		switch(view.getId()) {
		
		case R.id.launchIndicents:
			startActivity(new Intent(this, IncidentLauncherActivity.class));
			break;
			
		case R.id.launchTools:
			startActivity(new Intent(this, BrataLauncherActivity.class));
			break;
			
		case R.id.LaunchChallenges:
			startActivity(new Intent(this, SATChallengeLauncherActivity.class));
			break;
		}
		
	}

}
