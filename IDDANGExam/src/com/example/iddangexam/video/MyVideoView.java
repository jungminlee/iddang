package com.example.iddangexam.video;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.VideoView;

public class MyVideoView extends VideoView{

	public MyVideoView(Context context, AttributeSet attrs) {
		super(context,attrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
	    if (displayMetrics != null) {
	        setMeasuredDimension(displayMetrics.widthPixels, displayMetrics.heightPixels);
//	    	setMeasuredDimension(100, 100);
	    }

	}
}
