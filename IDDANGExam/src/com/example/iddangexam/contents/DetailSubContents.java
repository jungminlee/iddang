package com.example.iddangexam.contents;

import android.os.Environment;

public class DetailSubContents extends Common{
	private int btnID;
	private int mContentsType;
	private String mImgURL;
	private String mPlayURL;
	private String mImgPath;
	private String mPlayPath;
	
	private boolean isHave=false;				//컨텐츠 보유여부
	int fullSizeOfFile;					//총 파일사이즈
	int recvSizeOfFile;					//현재 받은 파일사이즈
	
	public DetailSubContents() {
		// TODO Auto-generated constructor stub
	}
	public DetailSubContents(String mTitle){
		setmTitle(mTitle);
	}
	
	
	
	public DetailSubContents(String mTitle, String mImgURL, String mPlayURL){
		setmTitle(mTitle);
		setmImgURL(mImgURL);
		setmPlayURL(mPlayURL);
	}
	
	public void setDetailContents(DetailSubContents dc)
	{
		setmTitle(dc.getmTitle());
		setmImgURL(dc.getmImgURL());
		setmPlayURL(dc.getmPlayURL());
	}
	
	public String getmImgPath() {
		return mImgPath;
	}
	public void setmImgPath(String mImgPath) {
		this.mImgPath = mImgPath;
	}
	public String getmPlayPath() {
		return mPlayPath;
	}
	public void setmPlayPath(String mPlayPath) {
		String sd = Environment.getExternalStorageDirectory().getAbsolutePath();
		this.mPlayPath = sd+mPlayPath;
	}
	
	public String getmImgURL() {
		return mImgURL;
	}
	public void setmImgURL(String mImgURL) {
		this.mImgURL = mImgURL;
	}
	public String getmPlayURL() {
		return mPlayURL;
	}
	public void setmPlayURL(String mPlayURL) {
		this.mPlayURL = mPlayURL;
	}
	public int getBtnID() {
		return btnID;
	}
	public void setBtnID(int btnID) {
		this.btnID = btnID;
	}
	public int getmContentsType() {
		return mContentsType;
	}
	public void setmContentsType(int mContentsType) {
		this.mContentsType = mContentsType;
	}
	public boolean isHave() {
		return isHave;
	}
	public void setHave(boolean isHave) {
		this.isHave = isHave;
	}
}
