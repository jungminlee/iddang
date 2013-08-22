package com.example.iddangexam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import com.example.iddangexam.storybook.MultiLineTextView;
import com.example.iddangexam.util.StaticClass;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class StoryBookActivity extends Activity implements OnClickListener{

	HashMap<Integer, SBPage> hmSBPage = new HashMap<Integer, SBPage>();
	int index = 0;
	Context context=null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    context = this;
	    setContentView(R.layout.activity_storybook);
	    MultiLineTextView mtv = new MultiLineTextView(this, null, 0);
	    mtv = (MultiLineTextView)findViewById(R.id.multiLineTextView1);
		mtv.setText("���� ��� ���� �󸶳� ��� �����~~~??���� ��� ���� �󸶳� ��� �����~~~??���� ��� ���� �󸶳� ��� �����~~~??���� ��� ���� �󸶳� ��� �����~~~??���� ��� ���� �󸶳� ��� �����~~~??���� ��� ���� �󸶳� ��� �����~~~??���� ��� ���� �󸶳� ��� �����~~~??");
		
		
		findViewById(R.id.img_next).setOnClickListener(this);
		findViewById(R.id.img_prev).setOnClickListener(this);
		
		SBPage sb = new SBPage();
		sb.setPageType(StaticClass.STORYBOOK_TYPE_BOOK);
		sb.setImagePath("/Koala.jpg");
		sb.setText("�ƾƾƾƾƾƾƾƾƾƾƾƷ��Ӥ��Ʒ��Ӥ��Ʒ��Ӥ��Ƥø�����Ʒ��ӳ��������ä���");
		sb.setPageNo(1);
		hmSBPage.put(sb.getPageNo(), sb);
		
		sb = new SBPage();
		sb.setPageType(StaticClass.STORYBOOK_TYPE_VIDEO);
		sb.setImagePath("/Penguins.jpg");
		sb.setVideoPath("/Wildlife.wmv");
		sb.setText("kkkk");
		sb.setPageNo(2);
		hmSBPage.put(sb.getPageNo(), sb);
		
		sb = new SBPage();
		sb.setPageType(StaticClass.STORYBOOK_TYPE_BOOK);
		sb.setImagePath("/Penguins.jpg");
		sb.setText("�ƾƾƾƾƾƾƾƾƤ�");
		sb.setPageNo(3);
		hmSBPage.put(sb.getPageNo(), sb);
	
	}
	private void drawText(String text){
		
	}
	private void playMov(String path){
		
	}
	
	@Override
	public void onClick(View v) {
		
		SBPage sbPage=null;
		switch(v.getId()){
		case R.id.img_next: 		//������������ư
			
			sbPage = hmSBPage.get(++index);
			if(sbPage==null) {
				Toast.makeText(context, "������ ������ �Դϴ�.", Toast.LENGTH_SHORT).show();
				index--;
			}else{
				startPage(sbPage);
			}
			break;
		
		case R.id.img_prev: 		//������������ư
			sbPage = hmSBPage.get(--index);
			if(sbPage==null){
				Toast.makeText(context, "ù ������ �Դϴ�.", Toast.LENGTH_SHORT).show();
				index++;
			}else{
				startPage(sbPage);
			}
			break;
		
		}
		
	}
	private void startPage(final SBPage sbPage){
		
		/** 
		 * StoryBook ���� �̹��� ���
		 */
		MultiLineTextView mtv = (MultiLineTextView)findViewById(R.id.multiLineTextView1);
		mtv.setText(sbPage.getText());
		ImageView iv = (ImageView)findViewById(R.id.img_image);
		File file=new File(sbPage.getImagePath());
		try {
			FileInputStream in=new FileInputStream(file);
			Drawable draw=Drawable.createFromStream(in, "aa");
			iv.setImageDrawable(draw);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/**
		 * ������ ���� ó����ƾ
		 * Book or Video
		 */
		if(sbPage.getPageType()==StaticClass.STORYBOOK_TYPE_BOOK){	
			
			
		}else if(sbPage.getPageType()==StaticClass.STORYBOOK_TYPE_VIDEO){
			findViewById(R.id.img_image).setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					startVideo(sbPage.getVideoPath());
				}
			});
			startVideo(sbPage.getVideoPath());
		}
//		else if(sbPage.getPageType().equals(StaticClass.STORYBOOK_TYPE_IMAGE)){
//			
//		}
	}
	private void startVideo(String path){
		Intent intent=null;;
		intent = new Intent(this,VideoActivity.class);
		intent.putExtra("playPath", path);
		overridePendingTransition(R.animator.slide_in_top, R.animator.slide_out_bottom);
		if(intent!=null){
			startActivity(intent);
			
		}
	}
}
class SBPage{
	private int pageNo;
	private int pageType;
	private String text;
	private String imagePath;
	private String videoPath;  // �̹��� or ������(���ϸ�)
	
	public int getPageNo() {
		
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageType() {
		return pageType;
	}
	public void setPageType(int pageType) {
		this.pageType = pageType;
	}

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getVideoPath() {
		return videoPath;
	}
	public void setVideoPath(String videoPath) {
		String sd = Environment.getExternalStorageDirectory().getAbsolutePath();
		this.videoPath = sd+videoPath;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		String sd = Environment.getExternalStorageDirectory().getAbsolutePath();
		this.imagePath = sd+imagePath;
	}
	
}