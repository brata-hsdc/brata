package com.harris.challenge.incidents;

import com.harris.challenge.brata.R;

import android.app.Activity;
import android.os.Bundle;

public class SkidMarks extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // This applies the layout specified in 
        //   res->layout->activity_request_clue.xml
        // to our Activity. We can now find views within that layout and
        // manipulate them. Don't try to call findViewById() before this!
        setContentView(R.layout.activity_skid_marks);
    }
}
