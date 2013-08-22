package com.example.iddangexam.contents;

import java.util.HashMap;
import java.util.Iterator;

public class Contents extends Common{
	
	private HashMap<String, SubContents> sContents = new HashMap<String, SubContents>();
	private int CtsType;
	
	public Contents() {
		
	}
	public Contents(String mTitle) {
		setmTitle(mTitle);
	}
	
	public SubContents getSubContentsByID(int idNum){
		
		SubContents sContent=null;
		Iterator itr = getList().keySet().iterator();
		
		while(itr.hasNext()){
			String key = (String)itr.next();
			if(get(key).getBtnID()==idNum)
			{
				sContent = get(key);
				break;
			}
		}
		return sContent;
	}
	
	
	public HashMap<String, SubContents> getList(){
		return sContents;
	}
	public SubContents get(String subContentTitle){
		return sContents.get(subContentTitle);
		
	}
	public void add(String subContentTitle){
		SubContents sContent = new SubContents(subContentTitle);
		sContents.put(sContent.getmTitle(), sContent);
		iCount();
	}
	public void del(String subContentTitle){
		sContents.remove(subContentTitle);
		dCount();
	}
	
	public void add(SubContents sContent){
		sContents.put(sContent.getmTitle(), sContent);
	}
	public void del(SubContents sContent){
		sContents.remove(sContent.getmTitle());
	}
	public int getCtsType() {
		return CtsType;
	}
	public void setCtsType(int ctsType) {
		CtsType = ctsType;
	}

	
}
