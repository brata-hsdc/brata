package com.harris.challenge.brata.framework;

import java.util.HashSet;
import java.util.Set;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

public class GPSService extends Service {
	
	// Local variables
    private LocationManager lm;
    private Location location;
    private MyLocationListener locationListener;
    private Set<GPSServiceListener> listeners;
    private int lastStatus = 0;
    private static boolean showingDebugToast = false;
    private final IBinder mBinder = (IBinder) new LocalBinder();

    /**
     * Called when the service is first created.
     */
    @Override
    public void onCreate() {
        super.onCreate();
        
        // The local location listener for the GPS Provider and a
        // list of client GPS Service listeners within the application
        locationListener = new MyLocationListener();
        listeners = new HashSet<GPSServiceListener>();

        // Retrieve the Android system LocationService and request location
        // updates to the GPS Provider by providing the Location Listener.
        // Will receive updates every 15 seconds
        long minTimeMillis = 15000;
        long minDistanceMeters = 15;
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 
                        minTimeMillis, 
                        minDistanceMeters,
                        locationListener);
        
        location = new Location(LocationManager.GPS_PROVIDER);
    }

    /**
     * Called when the service is about to be destroyed
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        if(lm != null)
        {
        	lm.removeUpdates(locationListener);
        }
    }

    /**
     * In the event that a client binds to this GPS Service return the local binder
     */
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    /**
     * Add a GPS Service Listener to the list
     */
    public void addGPSListener(GPSServiceListener listener)
    {
    	listeners.add(listener);
    	listener.onLocationChanged(location);
    }
    
    /**
     * Remove a GPS Service Listener from the list
     */
    public void removeGPSListener(GPSServiceListener listener)
    {
    	listeners.remove(listener);
    }
    
    /**
     * Class that handles updates from the GPS Provider 
     */
    public class MyLocationListener implements LocationListener {
            
        public void onLocationChanged(Location loc) {
        	if (showingDebugToast) Toast.makeText(getBaseContext(), "onLocationChanged",
        			Toast.LENGTH_SHORT).show();
            if (loc != null)
            {
            	location.set(loc);
            	for(GPSServiceListener listener : listeners)
            	{
            		listener.onLocationChanged(location);
            	}
            }
        }

        public void onProviderDisabled(String provider) {
            Toast.makeText(getBaseContext(), "GPS is not enabled on this device.  "
            		+"Must enable GPS Provider for GPS updates.",
                    Toast.LENGTH_LONG).show();
        }

        public void onProviderEnabled(String provider) {
            if (showingDebugToast) Toast.makeText(getBaseContext(), "onProviderEnabled: " + provider,
                            Toast.LENGTH_SHORT).show();
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
            String showStatus = null;
            if (status == LocationProvider.AVAILABLE)
                    showStatus = "Available";
            if (status == LocationProvider.TEMPORARILY_UNAVAILABLE)
                    showStatus = "Temporarily Unavailable";
            if (status == LocationProvider.OUT_OF_SERVICE)
                    showStatus = "Out of Service";
            if (status != lastStatus && showingDebugToast) {
                    Toast.makeText(getBaseContext(),
                                    "new status: " + showStatus,
                                    Toast.LENGTH_SHORT).show();
            }
            lastStatus = status;
        }
    }
    

    /**
     * Class for clients to access the GPS Service. 
     */
    public class LocalBinder extends Binder {
        public GPSService getService() {
                return GPSService.this;
        }
    }
    
    /**
     * GPS listener interface.  Clients of the GPS service will have to 
     * implement specific functions defined by this interface in order 
     * to receive GPS updates.
     */
    public interface GPSServiceListener extends ServiceConnection
    {
    	public void onLocationChanged(Location loc);
    }

}