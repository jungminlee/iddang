package com.example.iddangexam.contents;

import java.util.HashMap;
import java.util.Iterator;

public class SubContents extends Common{
	private int btnID;
	private HashMap<String, DetailSubContents> dsContents = new HashMap<String, DetailSubContents>();
	private HashMap<String, DetailSubContents> haveDSContents = new HashMap<String, DetailSubContents>();
	public SubContents() {
		// TODO Auto-generated constructor stub
	}
	public SubContents(String Title){
		setmTitle(Title);
	}
	
	
	public DetailSubContents getDetailContentsByID(int idNum){
		
		DetailSubContents dsContent=null;
		Iterator<String> itr = getContentsList().keySet().iterator();
		
		while(itr.hasNext()){
			String key = (String)itr.next();
			if(getContents(key).getBtnID()==idNum)
			{
				dsContent = getContents(key);
				break;
			}
		}
		return dsContent;
	}
	
	/**
	 * º¸À¯ÄÁÅÙÃ÷ Ãß°¡
	 */
	private void addHaveContents(DetailSubContents dsContent){
		haveDSContents.put(dsContent.getmTitle(), dsContent);
	}
	/**
	 * º¸À¯ÄÁÅÙÃ÷ ¸®½ºÆ®
	 */
	private HashMap<String, DetailSubContents> getHaveContentsList(){
		return haveDSContents;
	}
	/**
	 * ÄÁÅÙÃ÷ 
	 * @return
	 */
	public HashMap<String, DetailSubContents> getContentsList(){
		return dsContents;
	}
	
	public DetailSubContents getContents(String subContentTitle){
		return dsContents.get(subContentTitle);
		
	}
	public void addContents(String detailContentTitle){
		DetailSubContents dsContent = new DetailSubContents(detailContentTitle);
		dsContents.put(dsContent.getmTitle(), dsContent);
	}
	public void delContents(String detailContentTitle){
		dsContents.remove(detailContentTitle);
	}
	public void addContents(DetailSubContents dsContent){
		dsContents.put(dsContent.getmTitle(), dsContent);
	}
	public void delContents(DetailSubContents dsContent){
		dsContents.remove(dsContent.getmTitle());
	}
	public int getBtnID() {
		return btnID;
	}
	public void setBtnID(int btnID) {
		this.btnID = btnID;
	}
}
