package com.example.iddangexam;

import java.util.Iterator;

import com.example.iddangexam.contents.Contents;
import com.example.iddangexam.contents.SubContents;
import com.example.iddangexam.util.StaticClass;
import com.example.iddangexam.view.CtsIcon;


import android.R.color;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SubActivity extends Activity implements OnClickListener {

	int menuSeq;
	int subMenuCnt=0;
	TextView textSubject;
	Context context;
	Context context_this;
	Contents contents = null;
	SubContents sContents = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    
	    context = getApplicationContext();
	    context_this = this;
	    Intent intent = new Intent(this.getIntent());
	    menuSeq = intent.getIntExtra("menuSeq", 0);
	    
	    LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    LinearLayout linear = (LinearLayout)inflater.inflate(R.layout.activity_submenu, null);
	    setContentView(linear);
	    
	    	/**
	    	 * MAIN BUTTON
	    	 */
	    findViewById(R.id.btn_main).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	    
		    /**
	    	 * MYROOM BUTTON
	    	 */
	    findViewById(R.id.btn_myroom).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
	    textSubject = (TextView)findViewById(R.id.video_text_currenttime);
	    readContentsList();
	    drawContentsList();
	    
	    // TODO Auto-generated method stub
	}
	
	
	@Override
	public void onBackPressed() {
		finish();
		overridePendingTransition(R.animator.slide_in_top, R.animator.slide_out_bottom);
		super.onBackPressed();
	}
	
	private void readContentsList(){
		
		if(menuSeq == R.id.main_btn_storybook){
			contents = StaticClass.contents1;
			
		}else if(menuSeq == R.id.main_btn_library){
			contents = StaticClass.contents2;
			
		}else if(menuSeq == R.id.main_btn_karaoke){
			contents = StaticClass.contents3;
			
		}else if(menuSeq == R.id.main_btn_broadstation){
			contents = StaticClass.contents4;
			
		}else if(menuSeq == R.id.main_btn_playground){
			contents = StaticClass.contents5;
			
		}else if(menuSeq == R.id.main_btn_departstore){
			contents = StaticClass.contents6;
			
		}else if(menuSeq == R.id.main_btn_myroom){
			contents = StaticClass.contents7;
		}
		
	}
	private void drawContentsList() {
		
		Iterator itr;
		LinearLayout layout = (LinearLayout)findViewById(R.id.scrollLinearHor);
		textSubject.setText(contents.getmTitle());
		itr = contents.getList().keySet().iterator();
		
		/**
		 * SubContents ���
		 */
		while(itr.hasNext()){
			subMenuCnt++;
			String key = (String)itr.next();
			TextView tv = new TextView(context);
			tv.setText(contents.get(key).getmTitle());
			tv.setTextSize(20);
			tv.setId(StaticClass.CONTENTS_ID_SUB+(subMenuCnt));
			contents.get(key).setBtnID(StaticClass.CONTENTS_ID_SUB+(subMenuCnt));
			tv.setOnClickListener(this);
			layout.addView(tv);
		}
	}
	@Override
	public void onClick(View v) {
		int idNum=0;
		LinearLayout layoutLine=null;
		
		switch(v.getId()/10000000)
		{
		case StaticClass.CONTENTS_ID_RES: break;
		
		/**
		 * SubContents Ŭ��
		 * ���� ��� ���(������Contents)
		 */
		case StaticClass.CONTENTS_ID_SUB_RES:
			
			sContents = contents.getSubContentsByID(v.getId());
			Toast.makeText(context,""+v.getId(), Toast.LENGTH_SHORT).show();
			String subKey = sContents.getmTitle();
			Iterator itr;
			LinearLayout layout = (LinearLayout)findViewById(R.id.scrollLinearVertical);
			layout.removeAllViews();
			itr = sContents.getContentsList().keySet().iterator();
			while(itr.hasNext()){
				idNum++;
				//DETAIL CONTENTS �� ������
				if((idNum%5)==1 || idNum==1){ 
					LinearLayout.LayoutParams param=  new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
					layoutLine = new LinearLayout(context);
					layoutLine.setOrientation(LinearLayout.HORIZONTAL);
					layoutLine.setGravity(Gravity.CENTER_HORIZONTAL);
					layoutLine.setLayoutParams(param);
					layout.addView(layoutLine);
					
				}
				String key = (String)itr.next();
				
//				ImageView iv = new ImageView(context);
//				iv.setImageResource(R.drawable.ic_launcher);
//				iv.setId(StaticClass.CONTENTS_ID_DETAIL+idNum);
				sContents.getContents(key).setBtnID(StaticClass.CONTENTS_ID_DETAIL+idNum);
				
				CtsIcon Icon = new CtsIcon(context_this, sContents.getContents(key));
				Icon.setLayoutParams(new LinearLayout.LayoutParams(layout.getWidth()/5, layout.getWidth()/5));
				Icon.drawIconImage(R.drawable.ic_launcher);
				Icon.setBackgroundColor(Color.GREEN);
//				iv.setOnClickListener(this);
				layoutLine.addView(Icon);
			}
			break;
			/**
			 * �ش� ������ ����
			 */
		case StaticClass.CONTENTS_ID_DETAIL_RES: 
			Intent intent=null;
			
			/**
			 * VIDEO
			 */
			if(contents.getCtsType()==StaticClass.CONTENTS_TYPE_VIDEO)
			{
				intent = new Intent(this,VideoActivity.class);
				intent.putExtra("playPath", sContents.getDetailContentsByID(v.getId()).getmPlayPath());
				overridePendingTransition(R.animator.slide_in_top, R.animator.slide_out_bottom);
			}
			/**
			 * StoryBook
			 */
			else if(contents.getCtsType()==StaticClass.CONTENTS_TYPE_STORYBOOK){
				intent = new Intent(this,StoryBookActivity.class);
				overridePendingTransition(R.animator.slide_in_top, R.animator.slide_out_bottom);
				
			}
			if(intent!=null) startActivity(intent);
			break;
		}
		
		
		
	}




}
