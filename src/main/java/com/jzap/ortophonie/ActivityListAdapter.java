package com.jzap.ortophonie;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.joanzap.android.BaseAdapterHelper;
import com.jzap.ortophonie.model.TherapyActivity;

public class ActivityListAdapter extends BaseAdapter {

	private final List<TherapyActivity> activities;
	private final Context context;

	public ActivityListAdapter(Context context) {
		this.context = context;
		activities = new ArrayList<TherapyActivity>();
	}

	@Override
	public int getCount() {
		return activities.size();
	}

	@Override
	public Object getItem(int position) {
		return activities.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TherapyActivity activity = activities.get(position);
		return BaseAdapterHelper
				.get(context, convertView, parent, R.layout.activity_main_item)
				.setText(R.id.name, activity.getName())
				.setText(R.id.description, activity.getDescription())
				.getView();
	}

	public void addActivities(List<TherapyActivity> activities) {
		this.activities.addAll(activities);
		notifyDataSetChanged();
	}

}
