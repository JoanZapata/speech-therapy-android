package com.jzap.ortophonie;

import android.app.Activity;
import android.content.Intent;
import android.widget.ListView;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ItemClick;
import com.googlecode.androidannotations.annotations.ViewById;
import com.googlecode.androidannotations.annotations.rest.RestService;
import com.jzap.ortophonie.model.TherapyActivity;
import com.jzap.ortophonie.rest.RestClient;

@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {

	@RestService
	RestClient restClient;
	
	@ViewById
	ListView activityList;

	@AfterViews
	void afterViews() {
		activityList.setAdapter(new ActivityListAdapter(this, TherapyActivity.activities));
	}

	@ItemClick
	void activityList(TherapyActivity activity){
		Intent activityIntent = new Intent(this, activity.getActivity());
		startActivity(activityIntent);
	}
}
