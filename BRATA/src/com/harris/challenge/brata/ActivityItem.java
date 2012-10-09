/**
 * 
 */
package com.harris.challenge.brata;

import android.content.Intent;

/**
 * @author Andrew
 *
 */
public class ActivityItem {
	CharSequence mLabel;
	int mIcon;
	Intent mActivity;

	public ActivityItem(CharSequence label, int iconResource, Intent target) {
		mLabel = label;
		mIcon = iconResource;
		mActivity = target;
	}

}
