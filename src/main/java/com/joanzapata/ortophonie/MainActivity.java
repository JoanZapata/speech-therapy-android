package com.joanzapata.ortophonie;

import android.app.Activity;
import android.content.Intent;
import android.widget.ListView;
import com.joanzapata.ortophonie.model.TherapyActivity;
import com.joanzapata.ortophonie.rest.RestClient;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.rest.RestService;

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
