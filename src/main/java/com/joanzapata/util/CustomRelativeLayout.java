package com.joanzapata.util;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class CustomRelativeLayout extends RelativeLayout {

	public static interface OnSizeChangedListener {
		void onSizeChanged(int w, int h);
	}

	OnSizeChangedListener onSizeChangedListener;

	public void setOnSizeChangedListener(
			OnSizeChangedListener onSizeChangedListener) {
		this.onSizeChangedListener = onSizeChangedListener;
	}

	public CustomRelativeLayout(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
	}

	public CustomRelativeLayout(Context context) {
		super(context);
	}

	public CustomRelativeLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		if (this.onSizeChangedListener != null) {
			onSizeChangedListener.onSizeChanged(w, h);
		}

	};
}
