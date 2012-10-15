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
import com.harris.challenge.brata.tools.NavigationActivity;
import com.harris.challenge.brata.tools.RangingActivity;
import com.harris.challenge.brata.tools.RequestClueActivity;
import com.harris.challenge.brata.tools.SensorExamplesActivity;

public class BrataLauncherActivity extends Activity implements OnItemClickListener{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_brata_launcher);
        
        GridView activityGrid = (GridView) findViewById(R.id.mainActivityGrid);
                
        List<ActivityItem> items = new ArrayList<ActivityItem>();
        items.add(new ActivityItem("Request Clue",    R.drawable.ic_launcher, new Intent(this, RequestClueActivity.class)));
        items.add(new ActivityItem("Send Response",   R.drawable.ic_launcher, new Intent(this, RequestClueActivity.class)));
        items.add(new ActivityItem("Navigate",        R.drawable.ic_launcher, new Intent(this, NavigationActivity.class)));
        items.add(new ActivityItem("Ranging",         R.drawable.ic_launcher, new Intent(this, RangingActivity.class)));
        items.add(new ActivityItem("Sensor Examples", R.drawable.ic_launcher, new Intent(this, SensorExamplesActivity.class)));
        
        ActivityAdapter activities = new ActivityAdapter(getApplicationContext(), items);

        activityGrid.setAdapter(activities);
        activityGrid.setOnItemClickListener(this);
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
