package com.harris.challenge.brata.tools;

import com.harris.challenge.brata.R;
import android.app.Activity;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.harris.challenge.brata.framework.*;

public class DistanceFinderActivity extends Activity {
	
	private Camera mCamera;
	private CameraPreview mPreview;
	FrameLayout preview;
	ImageView mImageView;
	
	/** A safe way to get an instance of the Camera object. */
	public static Camera getCameraInstance(){
	    Camera c = null;
	    try {
	        c = Camera.open(); // attempt to get a Camera instance
	    }
	    catch (Exception e){
	        // Camera is not available (in use or does not exist)
	    }
	    return c; // returns null if camera is unavailable
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_distance_finder);
        // Create an instance of Camera
        mCamera = getCameraInstance();
        
        // Create our Preview view and set it as the content of our activity.
        mPreview = new CameraPreview(this, mCamera);
        mImageView = new ImageView(this);
        
        preview = (FrameLayout) findViewById(R.id.camera_preview);
        
        mImageView.setImageResource(R.drawable.grid);
        
        preview.addView(mPreview);
        preview.addView(mImageView);
        
    }
 
    @Override
    protected void onPause(){
    	super.onPause();
    	
    }
    
   
}
