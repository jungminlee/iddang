package com.example.iddangexam.contents;

public class Common {
	
	private String mTitle;
	private int mChildCount;
	
	public Common() {
		this.mChildCount=0;
	}
	public void iCount(){
		this.mChildCount++;
	}
	public void dCount(){
		if(this.mChildCount>0) this.mChildCount--; 
	}
	public String getmTitle() {
		return mTitle;
	}
	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}
	public int getmChildCount() {
		return mChildCount;
	}
	public void setmChildCount(int mChildCount) {
		this.mChildCount = mChildCount;
	}
}
