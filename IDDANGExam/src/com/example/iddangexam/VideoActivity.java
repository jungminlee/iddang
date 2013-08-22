package com.example.iddangexam;

import com.example.iddangexam.video.MyVideoView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.SeekBar.OnSeekBarChangeListener;

@SuppressLint("HandlerLeak")
public class VideoActivity extends Activity implements OnTouchListener {

	ProgressThread progressThread=null;
	TextView time_position = null;
	TextView time_max = null;
	Context context;
	boolean isVisible=false;
	Point startPoint = new Point();
	RelativeLayout videoCommand;
	SeekBar timeBar;
	AlphaAnimation aniCmdVisible = new AlphaAnimation(0, 1);
	AlphaAnimation aniCmdInVisible = new AlphaAnimation(1, 0);
	String playPath=null;
	
	MyVideoView video;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_videoplay);
	    context = getApplicationContext();
	    
	    /* 이전 Activity에서 전달받은 파일경로 */
	    Intent intent = new Intent(this.getIntent());
	    playPath = intent.getStringExtra("playPath");
	    
	    /* Video View */
//	    findViewById(R.id.videoView1).setOnTouchListener(this);
	    findViewById(R.id.videoView1).setOnTouchListener(this);
	    /* 상단 영상제어 버튼들*/
	    findViewById(R.id.video_btn_play).setOnTouchListener(this);
	    findViewById(R.id.video_btn_endpoint).setOnTouchListener(this);
	    findViewById(R.id.video_btn_startpoint).setOnTouchListener(this);
	    findViewById(R.id.video_btn_stop).setOnTouchListener(this);
	    /*--------------------*/
	    
	    videoCommand = (RelativeLayout)findViewById(R.id.video_command);
	  
	    time_position = (TextView)findViewById(R.id.video_text_currenttime);
	    time_max = (TextView)findViewById(R.id.video_text_endtime);
	    timeBar = (SeekBar)findViewById(R.id.video_seekbar);
	    
	    Toast.makeText(context, playPath, Toast.LENGTH_SHORT).show();
	    video = (MyVideoView)findViewById(R.id.videoView1);
	    video.setVideoPath(playPath);
	    video.seekTo(1);
	    timeBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				video.seekTo(timeBar.getProgress());
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				
			}
		});
	    video.setOnPreparedListener(new OnPreparedListener() {
			
			@Override
			public void onPrepared(MediaPlayer mp) {
				timeBar.setMax(video.getDuration());
				String sTime = convertTime(timeBar.getMax());
				time_max.setText(sTime);
			}
		});
	    video.setOnCompletionListener(new OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
				// TODO Auto-generated method stub
				finish();
				
			}
		});
	    aniCmdVisible.setDuration(100);
	    aniCmdInVisible.setDuration(100);
	    aniCmdVisible.setAnimationListener(aniListener);
	    aniCmdInVisible.setAnimationListener(aniListener);
	    
		isVisible=false;
		videoCommand.setAnimation(aniCmdInVisible);
		videoCommand.startAnimation(aniCmdInVisible);
		
	}
	
	
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		Point point = new Point((int)event.getX(),(int)event.getY());
		
		if(v.getId()==R.id.videoView1)
		{
			if(event.getAction()==MotionEvent.ACTION_UP){
				if(Math.abs(startPoint.x - point.x) < 5 && Math.abs(startPoint.y - point.y) < 5 ){
					if(!isVisible){
						isVisible=true;
						videoCommand.setAnimation(aniCmdVisible);
						videoCommand.startAnimation(aniCmdVisible);
						Toast.makeText(context, "visible", Toast.LENGTH_SHORT).show();
						
						
					}else{
						isVisible=false;
						videoCommand.setAnimation(aniCmdInVisible);
						videoCommand.startAnimation(aniCmdInVisible);
						Toast.makeText(context, "invisible", Toast.LENGTH_SHORT).show();
						
						
					}
				}
			}else if(event.getAction()==MotionEvent.ACTION_DOWN){
				startPoint.set(point.x, point.y);
			}else if(event.getAction()==MotionEvent.ACTION_MOVE){
				
			}
		}else if(v.getId()==R.id.video_btn_stop){
			video.pause();
		}else if(v.getId()==R.id.video_btn_play){
			video.start();
			if(progressThread == null) progressThread = new ProgressThread(video);
			if(progressThread.isAlive() == false) progressThread.start();
			
			
		}else if(v.getId()==R.id.video_btn_startpoint){
			video.seekTo(0);
			timeBar.setProgress(0);
		}else if(v.getId()==R.id.video_btn_endpoint){
			video.seekTo(timeBar.getMax());
			timeBar.setProgress(timeBar.getMax());
		}
		return true;
	}
	
	/*상하단 영상제어/SeekBar 레이아웃 등장 에니메이션*/

	Animation.AnimationListener aniListener = new AnimationListener() {
		@Override
		public void onAnimationStart(Animation animation) {
			// TODO Auto-generated method stub
		}
		@Override
		public void onAnimationRepeat(Animation animation) {
			// TODO Auto-generated method stub
		}
		@Override
		public void onAnimationEnd(Animation animation) {
			// TODO Auto-generated method stub
			if(isVisible)
			{
				videoCommand.setVisibility(View.VISIBLE);
			}else{
				videoCommand.setVisibility(View.GONE);
			}
			
		}
	};
	
	class ProgressThread extends Thread{
		MyVideoView videoView;
		public ProgressThread(MyVideoView videoView) {
			this.videoView = videoView;
			// TODO Auto-generated constructor stub
		}
		@Override
		public void run() {
			while(true){
				mHandler.sendEmptyMessage(videoView.getCurrentPosition());
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
	}
	
	Handler mHandler = new Handler(){
		public void handleMessage(android.os.Message msg){
//			
			String sTime = convertTime(msg.what);
			time_position.setText(sTime);
			timeBar.setProgress(msg.what);
		};
	};
	
	private String convertTime(int millisec)
	{
		int intTime = millisec/1000;
		int time=0, min=0, sec=0;
		int inputSec = intTime;
		
		time = inputSec / 3600;
		min = inputSec%3600/60;
		sec = inputSec%3600%60%60;
		
		
		return String.format("%02d:%02d:%02d", time,min,sec);
	}
	
}
