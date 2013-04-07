package com.jzap.ortophonie.activity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import com.jzap.ortophonie.R;

@EActivity(R.layout.activity_syllabe_cible)
public class SyllabeCibleActivity extends Activity implements
		OnPageChangeListener {

	enum State {
		CURRENT(R.color.item_current), //
		UNDONE(R.color.item_undone), //
		DONE_GOOD(R.color.item_done_good), //
		DONE_MISTAKE(R.color.item_done_mistake), //
		DONE_BAD(R.color.item_done_bad);

		private int colorId;

		private State(int colorId) {
			this.colorId = colorId;
		}

		public int getColorId() {
			return colorId;
		}
	}

	private static final String TAG = SyllabeCibleActivity.class
			.getSimpleName();

	private Map<SyllabeCibleModel, View> modelToProgressItem;

	@ViewById
	ViewPager viewPager;

	@ViewById
	LinearLayout progress;

	private SyllabeCibleAdapter adapter;

	private SyllabeCibleModel currentItem;

	@AfterViews
	protected void init() {
		prepareProgressBar(SyllabeCibleModel.syllabeCibleItems);
		adapter = new SyllabeCibleAdapter(this,
				SyllabeCibleModel.syllabeCibleItems);
		viewPager.setAdapter(adapter);
		viewPager.setOnPageChangeListener(this);
		viewPager.setCurrentItem(0);
		onPageSelected(0);
	}
	
	private void prepareProgressBar(List<SyllabeCibleModel> syllabecibleitems) {
		modelToProgressItem = new HashMap<SyllabeCibleModel, View>();
		for (SyllabeCibleModel syllabeCibleModel : syllabecibleitems) {
			TextView textView = new TextView(this);
			textView.setAlpha(0f);
			LayoutParams params = new LayoutParams(0,
					LayoutParams.MATCH_PARENT, 1);
			progress.addView(textView, params);
			modelToProgressItem.put(syllabeCibleModel, textView);
		}
	}

	private void setItemState(SyllabeCibleModel model, State state) {
		View view = modelToProgressItem.get(model);
		view.setBackgroundColor( //
		getResources().getColor(state.getColorId()));
		if (view.getAlpha() == 0f) {
			view.setAlpha(1f);
			AlphaAnimation translateAnimation = new AlphaAnimation(0f, 1f);
			translateAnimation.setDuration(500);
			translateAnimation.setFillAfter(true);
			view.startAnimation(translateAnimation);
		}
	}

	public void onPageScrolled(int position, float positionOffset,
			int positionOffsetPixels) {
	}

	@Override
	public void onPageSelected(int position) {
		Log.i(TAG, "Page selected : " + position);
		if (currentItem != null) {
			setItemState(currentItem, State.DONE_GOOD);
		}
		currentItem = adapter.getItemAt(position);
		setItemState(currentItem, State.CURRENT);
	}

	@Override
	public void onPageScrollStateChanged(int state) {
	}

}
