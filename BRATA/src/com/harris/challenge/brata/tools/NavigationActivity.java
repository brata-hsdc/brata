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

import com.harris.challenge.brata.R;
import com.harris.challenge.brata.framework.GPSService;
import com.harris.challenge.brata.framework.GPSService.GPSServiceListener;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

/**
 * @author Andrew
 * 
 */
public class NavigationActivity extends Activity implements OnClickListener, GPSServiceListener{

    private GPSService gpsService = null;

    /*
     * (non-Javadoc)
     * 
     * @see android.app.Activity#onCreate(android.os.Bundle)
     * 
     * This will be called whenever this activity is created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // This applies the layout specified in
        // res->layout->activity_request_clue.xml
        // to our Activity. We can now find views within that layout and
        // manipulate them. Don't try to call findViewById() before this!
        setContentView(R.layout.activity_navigation);

        // The GPS Service runs independently of the applications 
        // activities.  The bindService() function allows this 
        // activity to interact to the GPS service to retrieve location  
        // information. 
        Intent serviceIntent = new Intent(this, GPSService.class);
        bindService(serviceIntent, this, Context.BIND_AUTO_CREATE);
    }

    /**
     * This activity returns to the foreground.  The activity becomes active.
     */
    @Override
    protected void onResume() {
        // Rebind activity to gps service
        Intent mServiceIntent = new Intent(this, GPSService.class);
        bindService(mServiceIntent, this, Context.BIND_AUTO_CREATE);
        super.onResume();
    }

    /**
     * The activity is finished running
     */
    @Override
    protected void onStop() {
        super.onStop();
        unbindService(this);
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.view.View.OnClickListener#onClick(android.view.View)
     */
    public void onClick(View view) {
    }

    /**
     * Called when the connection with the GPS service is established
     * 
     * @param ComponentName
     * @param service binder
     */
    @Override
    public void onServiceConnected(ComponentName className, IBinder binder) {
        // Because we have bound to an explicit
        // service that is running in our own process, we can
        // cast its IBinder to a concrete class and directly access it.
        Toast.makeText(getBaseContext(), "GPS service connected", Toast.LENGTH_SHORT).show();
        GPSService.LocalBinder gpsBinder = (GPSService.LocalBinder) binder;
        GPSService gpsService = gpsBinder.getService();
        gpsService.addGPSListener(NavigationActivity.this);
    }

    /**
     * Called when the connection with the GPS service disconnects
     * 
     * @param classname
     */
    @Override
    public void onServiceDisconnected(ComponentName className) {
        if(gpsService != null) 
        {
            gpsService.removeGPSListener(NavigationActivity.this);
        }
    }

    /**
     * Takes action on each new location update
     * 
     * @param location 
     */
    @Override
    public void onLocationChanged(Location location) {
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();

        // Use Toast to display a messages briefly. It is a great tool
        // for debugging.  It is useful for determining the details of
        // an event such as a button press as well as when it occurred.  
        // However Android's Log tool is a better alternative for
        // debugging multiple recurring events and application crashes. 
        // Set this variable to true to view the GPS toast message.
        boolean GPS_show_updates = false;

        // The default GPS update time is 3 seconds.  You can set this to a 
        // different time by changing GPSUpdateDelay in GPSService.java.  
        // You should disable this toast message if that time is less than 2 secs.
        if(GPS_show_updates)
        {
            Toast.makeText(getBaseContext(), 
                "Latitude: "+latitude+
                "; Longitude: "+longitude,
                Toast.LENGTH_SHORT).show();
        }

        //TODO:  Use the location coordinates to do something useful

        new Handler().post(new Runnable() {
            public void run() {
            }
        });
    }
}
