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

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

/**
 * @author Andrew Falendysz
 *
 */
public class ActivityAdapter implements ListAdapter {
    Context mContext;
    List<ActivityItem> mActivities = new ArrayList<ActivityItem>();
    
    public ActivityAdapter(Context context, List<ActivityItem> items) {
        mContext = context;
        mActivities = items;
    }

    /* (non-Javadoc)
     * @see android.widget.Adapter#getCount()
     */
    public int getCount() {
        return mActivities.size();
    }

    /* (non-Javadoc)
     * @see android.widget.Adapter#getItem(int)
     */
    public ActivityItem getItem(int arg0) {
        return mActivities.get(arg0);
    }

    /* (non-Javadoc)
     * @see android.widget.Adapter#getItemId(int)
     */
    public long getItemId(int arg0) {
        return arg0;
    }

    /* (non-Javadoc)
     * @see android.widget.Adapter#getItemViewType(int)
     */
    public int getItemViewType(int arg0) {
        return 0;
    }

    /* (non-Javadoc)
     * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
     */
    public View getView(int position, View view, ViewGroup parent) {
        TextView itemView;
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService
                      (Context.LAYOUT_INFLATER_SERVICE);
            itemView = (TextView) inflater.inflate(R.layout.activity_item, null);
        } else {
            itemView = (TextView) view;
        }
        ActivityItem item = mActivities.get(position);
        itemView.setText(item.mLabel);
        Drawable iconDrawable = mContext.getResources().getDrawable(item.mIcon);
        itemView.setCompoundDrawablesWithIntrinsicBounds(null,iconDrawable, null, null);
        
        return itemView;
    }

    /* (non-Javadoc)
     * @see android.widget.Adapter#getViewTypeCount()
     */
    public int getViewTypeCount() {
        return 1;
    }

    /* (non-Javadoc)
     * @see android.widget.Adapter#hasStableIds()
     */
    public boolean hasStableIds() {
        return false;
    }

    /* (non-Javadoc)
     * @see android.widget.Adapter#isEmpty()
     */
    public boolean isEmpty() {
        return mActivities.isEmpty();
    }

    /* (non-Javadoc)
     * @see android.widget.Adapter#registerDataSetObserver(android.database.DataSetObserver)
     */
    public void registerDataSetObserver(DataSetObserver arg0) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see android.widget.Adapter#unregisterDataSetObserver(android.database.DataSetObserver)
     */
    public void unregisterDataSetObserver(DataSetObserver arg0) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see android.widget.ListAdapter#areAllItemsEnabled()
     */
    public boolean areAllItemsEnabled() {
        return true;
    }

    /* (non-Javadoc)
     * @see android.widget.ListAdapter#isEnabled(int)
     */
    public boolean isEnabled(int arg0) {
        return true;
    }
}
