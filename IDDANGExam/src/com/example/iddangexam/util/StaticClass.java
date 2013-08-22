package com.example.iddangexam.util;

import android.os.Environment;

import com.example.iddangexam.contents.Contents;

public class StaticClass {
	public static Contents contents1 = new Contents("contents1");
	public static Contents contents2 = new Contents("contents2");
	public static Contents contents3 = new Contents("contents3");
	public static Contents contents4 = new Contents("contents4");
	public static Contents contents5 = new Contents("contents5");
	public static Contents contents6 = new Contents("contents6");
	public static Contents contents7 = new Contents("contents7");
	
	public static final int CONTENTS_ID = 10000000;
	public static final int CONTENTS_ID_SUB = 20000000;
	public static final int CONTENTS_ID_DETAIL = 30000000;
	public static final int CONTENTS_ID_RES = 1;
	public static final int CONTENTS_ID_SUB_RES = 2;
	public static final int CONTENTS_ID_DETAIL_RES = 3;
	
	public static final int CONTENTS_TYPE_STORYBOOK = 1; 
	public static final int CONTENTS_TYPE_LIBRARY = 2;
	public static final int CONTENTS_TYPE_PLAYGROUND = 3; 
	public static final int CONTENTS_TYPE_KARAOKE = 4;
	public static final int CONTENTS_TYPE_BROADSTATION = 5; 
	public static final int CONTENTS_TYPE_DEPARTSTORE = 6;
	public static final int CONTENTS_TYPE_MYROOM = 7;
	public static final int CONTENTS_TYPE_VIDEO = 8;
	
	public static final int STORYBOOK_TYPE_BOOK = 1; 
	public static final int STORYBOOK_TYPE_VIDEO = 2; 
	public static final int STORYBOOK_TYPE_IMAGE = 3; 
	
	public static final String getRootDir(){
		return Environment.getExternalStorageDirectory().getAbsolutePath();
	}
}
