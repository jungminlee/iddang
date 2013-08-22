package com.example.iddangexam.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.opengl.Visibility;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.example.iddangexam.MainActivity;
import com.example.iddangexam.MyRoomActivity;
import com.example.iddangexam.R;
import com.example.iddangexam.StoryBookActivity;
import com.example.iddangexam.VideoActivity;
import com.example.iddangexam.contents.DetailSubContents;
import com.example.iddangexam.util.StaticClass;

public class CtsIcon extends LinearLayout{
	private static final String TAG = "";
	DetailSubContents contents;
	
	ImageView iconImage=null;			//컨텐츠 아이콘(초기접속시 다운)
	ImageView kakaoImage=null;
	private String iconImagePath=null;	//아이콘이미지 경로
	private String downloadUrl;			//다운로드 받을 URL
	private String playURL;				//컨텐츠URL
	
	Context context;
	View view;
	
	int iConWidth;
	int iConHeight;
	

	 
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		
		
		switch (event.getAction() & MotionEvent.ACTION_MASK) {
		case MotionEvent.ACTION_DOWN:
			this.setBackgroundColor(Color.BLUE);
			break;
			
			
		case MotionEvent.ACTION_UP:
			this.setBackgroundColor(Color.GREEN);
			break;
			
		case MotionEvent.ACTION_MOVE:
			if(this.getWidth()<event.getX() || event.getX() <0 || this.getHeight()<event.getY() || 0>event.getY() )
				this.setBackgroundColor(Color.GREEN);
			break;
		default:
			this.setBackgroundColor(Color.GREEN);
			break;
			
		}
		return true;
	}
	
	
	public CtsIcon(final Context context,DetailSubContents contents) {
		super(context);
		this.context = context;
		this.contents = contents;
		init(this.context);
		
		
		iconImage.setOnClickListener(iconClick);
		
	}

	View.OnClickListener iconClick = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			if(contents.isHave()){
			//보유컨텐츠
				switch(contents.getmContentsType()){
				
				case StaticClass.CONTENTS_TYPE_BROADSTATION:
					break;
				case StaticClass.CONTENTS_TYPE_DEPARTSTORE:
					break;
				case StaticClass.CONTENTS_TYPE_KARAOKE:
					break;
				case StaticClass.CONTENTS_TYPE_LIBRARY:
					break;
				case StaticClass.CONTENTS_TYPE_MYROOM:
					break;
				case StaticClass.CONTENTS_TYPE_PLAYGROUND:
					break;
				case StaticClass.CONTENTS_TYPE_STORYBOOK:
					{
						Intent intent = new Intent(context,StoryBookActivity.class);
						intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						((Activity) context).overridePendingTransition(R.animator.slide_in_top, R.animator.slide_out_bottom);
						((Activity) context).startActivity(intent);
						((Activity) context).finish();
					}
					
					break;
				case StaticClass.CONTENTS_TYPE_VIDEO:
					{
							
						Intent intent = new Intent(context,VideoActivity.class);
						intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						intent.putExtra("playPath", contents.getmPlayPath());
						((Activity) context).overridePendingTransition(R.animator.slide_in_top, R.animator.slide_out_bottom);
						((Activity) context).startActivity(intent);
						((Activity) context).finish();

					}
					break;
				}
				
			
			}else{
			//미보유컨텐츠	
				
				//다운로드
			
			}
			
			
//			Intent intent = new Intent(context,MyRoomActivity.class);
//			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//			context.startActivity(intent);
//			((Activity) context).finish();
		}
	};
	/**
	 * 
	 * @param argImage 경로 or Bitmap or Drawble or ImageView
	 */
	public void drawIconImage(Object argImage){
		
		if(argImage instanceof ImageView){
			ImageView image = (ImageView)argImage;
			iconImage.setImageDrawable(image.getDrawable());
		}else if(argImage instanceof String){
			
			
		}else if(argImage instanceof Drawable){
			Drawable image = (Drawable)argImage;
			iconImage.setImageDrawable(image);
			
		}else if(argImage instanceof Bitmap){
			Bitmap image = (Bitmap)argImage;
			iconImage.setImageBitmap(image);
			
		}else if(argImage instanceof Integer){
			int resource = (Integer)argImage;
			iconImage.setImageResource(resource);
		}
		iconImage.setScaleType(ScaleType.FIT_XY);
		
		
		
	}
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		
		int parentWidth = MeasureSpec.getSize( widthMeasureSpec );
		int parentHeight = MeasureSpec.getSize( heightMeasureSpec );
		iConWidth = parentWidth/2;
		iConHeight = parentWidth/2;
//		this.setLayoutParams(new LinearLayout.LayoutParams(50, 50));
		
	}
	@Override
	public void onWindowFocusChanged(boolean hasWindowFocus) {
		// TODO Auto-generated method stub
		super.onWindowFocusChanged(hasWindowFocus);
		
	}
	private void init(final Context context){
		
		LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=layoutInflater.inflate(R.layout.view_cts_icon, this);
        
        ProgressBar pBar = new ProgressBar(context);
        iconImage = (ImageView)view.findViewById(R.id.cts_icon_img);
        kakaoImage = (ImageView)view.findViewById(R.id.cts_icon_kakao);
        
        if(contents.isHave()){
			kakaoImage.setVisibility(View.INVISIBLE);
		//play
			
		}else{
		//download	
			
		}
        
	}

	
	
	/**
	 * 이하 getter setter
	 * @return
	 */
	public String getIconImagePath() {
		return iconImagePath;
	}

	public void setIconImagePath(String iconImagePath) {
		this.iconImagePath = iconImagePath;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}
	
	
}
