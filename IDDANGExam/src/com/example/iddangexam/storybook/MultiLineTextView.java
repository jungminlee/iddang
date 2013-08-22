package com.example.iddangexam.storybook;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

public class MultiLineTextView extends TextView{

	Context context;
	String str="";
	
	public MultiLineTextView(Context context) {
		super(context);
		this.context = context;
		// TODO Auto-generated constructor stub
	}
	public MultiLineTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
		// TODO Auto-generated constructor stub
	}
	
	public MultiLineTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.context = context;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void setText(CharSequence text, BufferType type) {
		// TODO Auto-generated method stub
		
		super.setText(text,type);
		str=text.toString();
	}
		
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		// TODO Auto-generated method stub
		super.onSizeChanged(w, h, oldw, oldh);
		if(this!=null)setText(breakText(this.getPaint(), str,this.getWidth()));
	}
	
	
	protected String breakText(Paint textPaint, String strText, int breakWidth) {
		StringBuilder sb = new StringBuilder();
		int endValue = 0;
		do {
			endValue = textPaint.breakText(strText, true, breakWidth, null);
			if (endValue > 0) {
				sb.append(strText.substring(0, endValue)).append("\n");
				strText = strText.substring(endValue);
			}
		} while (endValue > 0);
		return sb.toString().substring(0, sb.length());  

	}

}
