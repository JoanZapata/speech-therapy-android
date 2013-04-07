package com.jzap.ortophonie.activity;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;
import static android.text.Html.fromHtml;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import com.jzap.ortophonie.R;
import com.jzap.util.CustomRelativeLayout;
import com.jzap.util.CustomRelativeLayout.OnSizeChangedListener;

public class SyllabeCibleAdapter extends PagerAdapter {

	private static final String TAG = "SyllabeCibleAdapter";
	private final List<SyllabeCibleModel> syllabecibleitems;
	private final Map<SyllabeCibleModel, View> modelToView;
	private final Context context;

	public SyllabeCibleAdapter(Context context,
			List<SyllabeCibleModel> syllabecibleitems) {
		this.context = context;
		this.syllabecibleitems = syllabecibleitems;
		this.modelToView = new HashMap<SyllabeCibleModel, View>();
	}

	@Override
	public int getCount() {
		return syllabecibleitems.size();
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		LayoutInflater inflater = (LayoutInflater) context //
				.getSystemService(LAYOUT_INFLATER_SERVICE);
		CustomRelativeLayout view = (CustomRelativeLayout) inflater //
				.inflate(R.layout.activity_syllabe_cible_item, null);
		final SyllabeCibleModel model = syllabecibleitems.get(position);
		modelToView.put(model, view);

		final ImageView imageView = (ImageView) view.findViewById(R.id.image1);
		final ImageView imageView2 = (ImageView) view.findViewById(R.id.image2);
		final ImageView imageView3 = (ImageView) view.findViewById(R.id.image3);
		final ImageView imageView4 = (ImageView) view.findViewById(R.id.image4);
		final TextView textView = (TextView) view.findViewById(R.id.syllabe);
		final TextView word = (TextView) view.findViewById(R.id.word);
		final Button next = (Button) view.findViewById(R.id.next);

		textView.setText(model.getSyllabe());
		imageView.setImageResource(model.getRightImageId().getImageId());
		imageView2.setImageResource(model.getWrongImageIds().get(0)
				.getImageId());
		imageView3.setImageResource(model.getWrongImageIds().get(1)
				.getImageId());
		imageView4.setImageResource(model.getWrongImageIds().get(2)
				.getImageId());

		final Map<ImageView, String> imageToWord = new HashMap<ImageView, String>();
		imageToWord.put(imageView, model.getRightImageId().getText());
		imageToWord.put(imageView2, model.getWrongImageIds().get(0).getText());
		imageToWord.put(imageView3, model.getWrongImageIds().get(1).getText());
		imageToWord.put(imageView4, model.getWrongImageIds().get(2).getText());

		final List<ImageView> allViews = Arrays.asList(imageView, imageView2,
				imageView3, imageView4);
		OnClickListener onClickListener = new OnClickListener() {
			
			boolean answered = false;
			
			@Override
			public void onClick(View v) {
				if (answered) {
					return;
				}
				answered = true;
				
				ScaleAnimation scaleAnimationUp = new ScaleAnimation(
						Animation.RELATIVE_TO_SELF, 1.3f,
						Animation.RELATIVE_TO_SELF, 1.3f, v.getWidth() / 2,
						v.getHeight() / 2);
				scaleAnimationUp.setDuration(300);
				scaleAnimationUp.setFillAfter(true);
				v.startAnimation(scaleAnimationUp);

				Log.i(TAG, "at this point, pivot x = " + v.getPivotX());
				AlphaAnimation alphaAnimationDown = new AlphaAnimation(1f, 0.1f);
				alphaAnimationDown.setDuration(300);
				alphaAnimationDown.setFillAfter(true);
				for (View view2 : allViews) {
					if (view2 != v) {
						view2.startAnimation(alphaAnimationDown);
					}
				}

				word.setText(fromHtml(format(imageToWord.get(v))));
				word.setVisibility(View.VISIBLE);
				Animation showsUp = new TranslateAnimation(0, 0, -500, 0);

				BounceInterpolator bounceInterpolator = new BounceInterpolator();
				showsUp.setInterpolator(bounceInterpolator);
				showsUp.setDuration(1000);
				showsUp.setStartOffset(500);
				showsUp.setFillAfter(true);
				word.startAnimation(showsUp);
				
				if (v == imageView || v == imageView3){
					((LayoutParams) word.getLayoutParams()).addRule(RelativeLayout.LEFT_OF, -1);
					((LayoutParams) next.getLayoutParams()).addRule(RelativeLayout.LEFT_OF, -1);
					((LayoutParams) word.getLayoutParams()).addRule(RelativeLayout.RIGHT_OF, R.id.image1);
					((LayoutParams) next.getLayoutParams()).addRule(RelativeLayout.RIGHT_OF, R.id.image1);
				} else {

					((LayoutParams) word.getLayoutParams()).addRule(RelativeLayout.RIGHT_OF, -1);
					((LayoutParams) next.getLayoutParams()).addRule(RelativeLayout.RIGHT_OF, -1);
					((LayoutParams) word.getLayoutParams()).addRule(RelativeLayout.LEFT_OF, R.id.image2);
					((LayoutParams) next.getLayoutParams()).addRule(RelativeLayout.LEFT_OF, R.id.image2);
				}

				Animation showsUp2 = new AlphaAnimation(0f, 1f);
				showsUp2.setDuration(1000);
				showsUp2.setFillAfter(true);
				showsUp2.setStartOffset(900);
				next.setVisibility(View.VISIBLE);
				next.startAnimation(showsUp2);
			}

			private String format(String string) {
				return string.replaceAll("\\*(.*?)\\*", "<font color='green'>$1</font>");
			}
		};

		view.setOnSizeChangedListener(new OnSizeChangedListener() {
			@Override
			public void onSizeChanged(int w, int h) {
				int availableHeight = h * 4 / 5;

				((LayoutParams) imageView.getLayoutParams()).topMargin = h
						- availableHeight;
				imageView.getLayoutParams().width = w / 2;
				imageView.getLayoutParams().height = availableHeight / 2;
				imageView2.getLayoutParams().width = w / 2;
				imageView2.getLayoutParams().height = availableHeight / 2;
				imageView3.getLayoutParams().width = w / 2;
				imageView3.getLayoutParams().height = availableHeight / 2;
				imageView4.getLayoutParams().width = w / 2;
				imageView4.getLayoutParams().height = availableHeight / 2;
			}
		});

		imageView.setOnClickListener(onClickListener);
		imageView2.setOnClickListener(onClickListener);
		imageView3.setOnClickListener(onClickListener);
		imageView4.setOnClickListener(onClickListener);

		view.setTag(model);
		((ViewPager) container).addView(view, 0);

		return model;
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view.getTag() == object;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		((ViewPager) container).removeView(modelToView.get(object));
	}

	public SyllabeCibleModel getItemAt(int position) {
		return syllabecibleitems.get(position);
	}

}
