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

import com.harris.challenge.brata.R;
import com.harris.challenge.incidents.DudeMyCar;
import com.harris.challenge.incidents.SkidMarks;
import com.harris.challenge.incidents.StraightAsAnArrow;
import com.harris.challenge.incidents.TwoPlacesAtOnce;
import com.harris.challenge.secret_agent_tools.RegistrationTool;

public class SATChallengeLauncherActivity extends Activity implements OnItemClickListener {
	

	@Override
    public void onCreate(Bundle savedInstanceState) {
    	  super.onCreate(savedInstanceState);
          requestWindowFeature(Window.FEATURE_NO_TITLE);
          setContentView(R.layout.activity_incident);
          
          GridView activityGrid = (GridView) findViewById(R.id.mainActivityGrid);
                  
          List<ActivityItem> items = new ArrayList<ActivityItem>();
          items.add(new ActivityItem("Team Registration",    R.drawable.ic_launcher, new Intent(this, RegistrationTool.class)));
//          items.add(new ActivityItem("Skid Marks",   R.drawable.ic_launcher, new Intent(this, SkidMarks.class)));
//          items.add(new ActivityItem("Skid Marks",   R.drawable.ic_launcher, new Intent(this, SkidMarks.class)));
//          items.add(new ActivityItem("Two Places At Once",        R.drawable.ic_launcher, new Intent(this, TwoPlacesAtOnce.class)));
//          items.add(new ActivityItem("Dude, What Happened To My Car",         R.drawable.ic_launcher, new Intent(this, DudeMyCar.class)));
          
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
