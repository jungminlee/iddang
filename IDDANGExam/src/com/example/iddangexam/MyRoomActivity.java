package com.example.iddangexam;

import java.util.HashMap;
import java.util.Iterator;

import com.example.iddangexam.contents.Contents;
import com.example.iddangexam.contents.SubContents;
import com.example.iddangexam.util.StaticClass;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyRoomActivity extends Activity {

	HashMap<String, Contents> hmContens;
	Context context=null;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activiry_myroom);
	    
	    context = getApplicationContext();
	    hmContens = new HashMap<String, Contents>();
	    hmContens.put(StaticClass.contents1.getmTitle(),StaticClass.contents1);
	    hmContens.put(StaticClass.contents2.getmTitle(),StaticClass.contents2);
	    hmContens.put(StaticClass.contents3.getmTitle(),StaticClass.contents3);
	    hmContens.put(StaticClass.contents4.getmTitle(),StaticClass.contents4);
	    hmContens.put(StaticClass.contents5.getmTitle(),StaticClass.contents5);
	    
	    drawMenu();
	}
	
	private void drawMenu(){
		
		Iterator itr = null;
		itr = hmContens.keySet().iterator();
		
		TextView textTitle = (TextView)findViewById(R.id.myroom_text_title);
		textTitle.setText(StaticClass.contents7.getmTitle());
		
		while(itr.hasNext()){
			String key = (String)itr.next();
			Contents contents = hmContens.get(key);
			if(contents.getmChildCount()!=0){
				LinearLayout linearLayout = (LinearLayout)findViewById(R.id.myroom_layout_ver);
				TextView tv = new TextView(context);
				tv.setText(contents.getmTitle());
				tv.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
				linearLayout.addView(tv);
				
				LinearLayout.LayoutParams hLinearParam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
				LinearLayout hLinearLayout = new LinearLayout(context);
				hLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
				hLinearLayout.setGravity(Gravity.CENTER_HORIZONTAL);
				hLinearLayout.setLayoutParams(hLinearParam);
				linearLayout.addView(hLinearLayout);
				
				HashMap<String, SubContents>  hmSContents = new HashMap<String, SubContents>();
				hmSContents = contents.getList();
				Iterator inItr = hmSContents.keySet().iterator();
				while(inItr.hasNext()){
					String inKey = (String)inItr.next();
					ImageView iv = new ImageView(context);
					iv.setImageResource(R.drawable.ic_launcher);
					hLinearLayout.addView(iv);
				}
			}
			
		}
	}
}
