package com.harris.challenge.brata;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;

import com.harris.challenge.secret_agent_tools.Secure;
import com.harris.challenge.secret_agent_tools.Dock;
import com.harris.challenge.secret_agent_tools.Return;
import com.harris.challenge.secret_agent_tools.Launch;
import com.harris.challenge.secret_agent_tools.RegistrationTool;

public class SATChallengeLauncherActivity extends Activity implements OnItemClickListener {
	

	@Override
    public void onCreate(Bundle savedInstanceState) {
    	  super.onCreate(savedInstanceState);
          requestWindowFeature(Window.FEATURE_NO_TITLE);
          setContentView(R.layout.activity_sat_challenges);
          
          GridView activityGrid = (GridView) findViewById(R.id.mainActivityGrid);
                  
          List<ActivityItem> items = new ArrayList<ActivityItem>();
          items.add(new ActivityItem("Team Registration",    		R.drawable.ic_launcher, new Intent(this, RegistrationTool.class)));
          items.add(new ActivityItem("Return",   			R.drawable.ic_launcher, new Intent(this, Return.class)));
          items.add(new ActivityItem("Dock",   		R.drawable.ic_launcher, new Intent(this, Dock.class)));
          items.add(new ActivityItem("Launch",     R.drawable.ic_launcher, new Intent(this, Launch.class)));
          items.add(new ActivityItem("Secure",  R.drawable.ic_launcher, new Intent(this, Secure.class)));
          
          ActivityAdapter activities = new ActivityAdapter(getApplicationContext(), items);

          activityGrid.setAdapter(activities);
          activityGrid.setOnItemClickListener((OnItemClickListener) this);
    }
    
    @Override
    protected void onDestroy() {
    	super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_brata_launcher, menu);
        return true;
    }
  
	public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
		ActivityItem item = (ActivityItem) adapter.getItemAtPosition(position);

		startActivity(item.mActivity);
	}

}
