package com.example.iddangexam;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import com.example.iddangexam.util.StaticClass;
import com.example.iddangexam.view.CtsIcon;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	Context context = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		context = getApplicationContext();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		
		
		
		
		
		findViewById(R.id.main_btn_storybook).setOnClickListener(this);
		findViewById(R.id.main_btn_library).setOnClickListener(this);
		findViewById(R.id.main_btn_karaoke).setOnClickListener(this);
		findViewById(R.id.main_btn_broadstation).setOnClickListener(this);
		findViewById(R.id.main_btn_playground).setOnClickListener(this);
		findViewById(R.id.main_btn_departstore).setOnClickListener(this);
		findViewById(R.id.main_btn_myroom).setOnClickListener(this);
		
		
		StaticClass.contents1.setmTitle("메뉴1");
		StaticClass.contents2.setmTitle("메뉴2");
		StaticClass.contents3.setmTitle("메뉴3");
		StaticClass.contents4.setmTitle("메뉴4");
		StaticClass.contents5.setmTitle("메뉴5");
		StaticClass.contents6.setmTitle("메뉴6");
		StaticClass.contents7.setmTitle("메뉴7");
		
		StaticClass.contents1.add("Sub1-1");
		StaticClass.contents1.add("Sub1-2");
		StaticClass.contents1.add("Sub1-3");
		StaticClass.contents2.add("Sub2-1");
		StaticClass.contents2.add("Sub2-2");
		StaticClass.contents2.add("Sub2-3");
		
		StaticClass.contents1.get("Sub1-1").addContents("D-1");
		StaticClass.contents1.get("Sub1-1").addContents("D-2");
		StaticClass.contents1.get("Sub1-1").addContents("D-3");
		StaticClass.contents1.get("Sub1-1").addContents("D-4");
		StaticClass.contents1.get("Sub1-1").addContents("D-5");
		StaticClass.contents1.get("Sub1-1").addContents("D-6");
		StaticClass.contents1.get("Sub1-1").addContents("D-7");
		StaticClass.contents1.get("Sub1-1").addContents("D-8");
		StaticClass.contents1.get("Sub1-1").addContents("D-10");
		StaticClass.contents1.get("Sub1-1").addContents("D-11");
		StaticClass.contents1.get("Sub1-1").addContents("D-12");
		StaticClass.contents1.get("Sub1-1").addContents("D-13");
		StaticClass.contents1.get("Sub1-1").addContents("D-14");
		
		
		
		String mPlayPath = "/Movies/130810.무한도전 「여름 예능 캠프 두 번째 이야기」.H264.AAC.720p-CineBus.mp4";
		StaticClass.contents1.get("Sub1-1").getContents("D-1").setmPlayPath(mPlayPath);
		StaticClass.contents1.get("Sub1-1").getContents("D-2").setmPlayPath(mPlayPath);
		StaticClass.contents1.get("Sub1-1").getContents("D-3").setmPlayPath(mPlayPath);
		StaticClass.contents1.get("Sub1-1").getContents("D-4").setmPlayPath(mPlayPath);
		StaticClass.contents1.get("Sub1-1").getContents("D-5").setmPlayPath(mPlayPath);
		StaticClass.contents1.get("Sub1-1").getContents("D-6").setmPlayPath(mPlayPath);
		StaticClass.contents1.get("Sub1-1").getContents("D-7").setmPlayPath(mPlayPath);
		StaticClass.contents1.get("Sub1-1").getContents("D-8").setmPlayPath(mPlayPath);
		StaticClass.contents1.get("Sub1-1").getContents("D-10").setmPlayPath(mPlayPath);
		StaticClass.contents1.get("Sub1-1").getContents("D-11").setmPlayPath(mPlayPath);
		StaticClass.contents1.get("Sub1-1").getContents("D-12").setmPlayPath(mPlayPath);
		StaticClass.contents1.get("Sub1-1").getContents("D-13").setmPlayPath(mPlayPath);
		StaticClass.contents1.get("Sub1-1").getContents("D-14").setmPlayPath(mPlayPath);
		StaticClass.contents1.get("Sub1-1").getContents("D-1").setHave(true);
		StaticClass.contents1.get("Sub1-1").getContents("D-2").setHave(true);
		StaticClass.contents1.get("Sub1-1").getContents("D-3").setHave(true);
		StaticClass.contents1.get("Sub1-1").getContents("D-4").setHave(true);
		StaticClass.contents1.get("Sub1-1").getContents("D-5").setHave(true);
		StaticClass.contents1.get("Sub1-1").getContents("D-6").setHave(true);
		StaticClass.contents1.get("Sub1-1").getContents("D-7").setHave(true);
		StaticClass.contents1.get("Sub1-1").getContents("D-8").setHave(true);
		StaticClass.contents1.get("Sub1-1").getContents("D-1").setmContentsType(StaticClass.CONTENTS_TYPE_VIDEO);
		StaticClass.contents1.get("Sub1-1").getContents("D-2").setmContentsType(StaticClass.CONTENTS_TYPE_VIDEO);
		StaticClass.contents1.get("Sub1-1").getContents("D-3").setmContentsType(StaticClass.CONTENTS_TYPE_VIDEO);
		StaticClass.contents1.get("Sub1-1").getContents("D-1").setmPlayPath(mPlayPath);
		StaticClass.contents1.get("Sub1-1").getContents("D-2").setmPlayPath(mPlayPath);
		StaticClass.contents1.get("Sub1-1").getContents("D-3").setmPlayPath(mPlayPath);
		StaticClass.contents1.get("Sub1-1").getContents("D-4").setmContentsType(StaticClass.CONTENTS_TYPE_LIBRARY);
		StaticClass.contents1.get("Sub1-1").getContents("D-5").setmContentsType(StaticClass.CONTENTS_TYPE_LIBRARY);
		StaticClass.contents1.get("Sub1-1").getContents("D-6").setmContentsType(StaticClass.CONTENTS_TYPE_LIBRARY);
		StaticClass.contents1.get("Sub1-1").getContents("D-7").setmContentsType(StaticClass.CONTENTS_TYPE_LIBRARY);
		StaticClass.contents1.get("Sub1-1").getContents("D-8").setmContentsType(StaticClass.CONTENTS_TYPE_LIBRARY);
		
		
		StaticClass.contents1.get("Sub1-2").addContents("Detail1-2-1");
		StaticClass.contents1.get("Sub1-2").addContents("Detail1-2-2");
		
		
		StaticClass.contents1.setCtsType(StaticClass.CONTENTS_TYPE_VIDEO);
		
		StaticClass.contents2.get("Sub2-1").addContents("D-1");
		StaticClass.contents2.get("Sub2-1").addContents("D-2");
		StaticClass.contents2.get("Sub2-2").addContents("D-3");
		StaticClass.contents2.get("Sub2-3").addContents("D-4");
		StaticClass.contents2.setCtsType(StaticClass.CONTENTS_TYPE_STORYBOOK);
		StaticClass.contents7.setCtsType(StaticClass.CONTENTS_TYPE_MYROOM);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		Toast.makeText(context, "MainTouchEvent"+event.getAction(), Toast.LENGTH_SHORT).show();
		return super.onTouchEvent(event);
	}


	@Override
	public void onClick(View v) {
		Intent intent=null;
		Toast.makeText(context, StaticClass.getRootDir()+"/kkk.jpg", Toast.LENGTH_SHORT).show();
		if(v.getId() == R.id.main_btn_myroom){
			intent = new Intent(this,MyRoomActivity.class);
			startActivity(intent);
//			new Thread(new Runnable() {
//				
//				@Override
//				public void run() {
//					
//					try {
//						Socket socket = new Socket("192.168.69.17",11111);
//						
//						FileOutputStream fos = new FileOutputStream(StaticClass.getRootDir()+"/kkk1.jpg");
//						InputStream is = socket.getInputStream();
//						byte buffer[] = new byte[2048];
//						is.read(buffer, 0, 10);
//						String header = new String(buffer,0,10);
//						int bodysize = Integer.parseInt(header);
//						int readsize =0;
//						
//						
//						while(readsize <bodysize){
//							int rsize = is.read(buffer);
//							fos.write(buffer, 0, rsize);
//							readsize += rsize;
//						}
//						fos.flush();
//						is.close();
//						fos.close();
//						
//					} catch (FileNotFoundException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//
//					
//					
//				}
//			}).start();
			
			
		}else {
			intent = new Intent(this, SubActivity.class);
			intent.putExtra("menuSeq", v.getId());
			startActivity(intent);
		}
		
		overridePendingTransition(R.animator.slide_in_top, R.animator.slide_out_bottom);
	}

}
