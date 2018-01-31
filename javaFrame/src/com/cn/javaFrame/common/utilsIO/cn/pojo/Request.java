package com.cn.javaFrame.common.utilsIO.cn.pojo;

import java.io.IOException;
import java.io.InputStream;

import com.cn.javaFrame.common.utilsIO.util.FileUtil;

public class Request {
	private InputStream in=null;
	private String uri="";
	private String content="";
	
	public Request() {
	}
	public Request(InputStream in) {
		this.in=in;
	}
	
	
	
	public void parse(){
		StringBuffer sb=new StringBuffer(2048);
		int i;
		byte[] buffer=new byte[2048];
		try{
			i=in.read(buffer);
		}catch (Exception e) {
			e.printStackTrace();
			i=-1;
		}
		for(int j=0;j<i;j++){
			sb.append((char) buffer[j]);
		}
		
		uri=parseUri(sb.toString());
		content=parseContent(sb.toString());
		
		String newStr="uri="+uri+"\ncontent="+content;
	    //记录日志
	    try {
			FileUtil.writeFileContent(FileUtil.logPah(), newStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//
	private String parseUri(String requestStr){
		int index1,index2;
		index1=requestStr.indexOf(" ");
		if(-1!=index1){
			index2=requestStr.indexOf(' ',index1+1);
			if(index2>index1){
				return requestStr.substring(index1,index2);
			}
			
		}
		return "";
	}
	
	private String parseContent(String requestStr){
		  int index=requestStr.indexOf("content:");
		  if(-1!=index){
			  return requestStr.substring(index+8).trim();
		  }else{
//			  int index2=requestString.indexOf("Accept-Language:");
			  return "";
		  }
	}
	
	public String getUri(){
		return uri;
	}
	
	public String getContent(){
		return content;
	}
}
