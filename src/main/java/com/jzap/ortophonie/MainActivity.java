package com.jzap.ortophonie;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.widget.ListView;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Background;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ItemClick;
import com.googlecode.androidannotations.annotations.UiThread;
import com.googlecode.androidannotations.annotations.ViewById;
import com.googlecode.androidannotations.annotations.rest.RestService;
import com.jzap.ortophonie.activity.SyllabeCibleActivity_;
import com.jzap.ortophonie.model.TherapyActivity;
import com.jzap.ortophonie.rest.RestClient;

@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {

	@RestService
	RestClient restClient;

	@ViewById
	ListView activityList;

	private ActivityListAdapter activityListAdapter;

	@AfterViews
	void afterViews() {
		activityListAdapter = new ActivityListAdapter(this);
		activityList.setAdapter(activityListAdapter);
		loadActivities();
	}

	@Background
	void loadActivities() {
		List<TherapyActivity> activities = restClient.getActivities().activities;
		displayActivities(activities);
	}

	@UiThread
	void displayActivities(List<TherapyActivity> activities) {
		activityListAdapter.addActivities(activities);
	}

	@ItemClick
	void activityList(TherapyActivity activity) {
		Intent activityIntent = new Intent(this, SyllabeCibleActivity_.class);
		startActivity(activityIntent);
	}
}
