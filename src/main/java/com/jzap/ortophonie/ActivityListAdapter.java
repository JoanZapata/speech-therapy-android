package com.jzap.ortophonie;

import java.util.List;

import com.jzap.ortophonie.model.TherapyActivity;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityListAdapter extends BaseAdapter {

	private final List<TherapyActivity> activities;
	private final Context context;

	public ActivityListAdapter(Context context, List<TherapyActivity> activities) {
		this.context = context;
		this.activities = activities;
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

	private static class ViewHolder {
		public final TextView nameView;
		public final TextView descriptionView;
		public final ImageView imageView;

		public ViewHolder(TextView nameView, TextView descriptionView, ImageView imageView) {
			this.nameView = nameView;
			this.descriptionView = descriptionView;
			this.imageView = imageView;
		}
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = View.inflate(context, R.layout.activity_main_item, null);
			ViewHolder viewHolder = new ViewHolder(
					(TextView) convertView.findViewById(R.id.name),
					(TextView) convertView.findViewById(R.id.description),
					(ImageView) convertView.findViewById(R.id.image));
			convertView.setTag(viewHolder);
		}

		TherapyActivity activity = activities.get(position);
		ViewHolder viewHolder = (ViewHolder) convertView.getTag();
		viewHolder.nameView.setText(activity.getName());
		viewHolder.descriptionView.setText(activity.getDescription());
		viewHolder.imageView.setImageResource(activity.getImageId());

		return convertView;
	}

}
