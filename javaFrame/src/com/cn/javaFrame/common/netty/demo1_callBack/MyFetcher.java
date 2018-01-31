package com.cn.javaFrame.common.netty.demo1_callBack;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyFetcher implements Fetcher {
	List<MyFilter> list=new ArrayList<MyFilter>();
	
	private Date date;
	
	public MyFetcher(Date date) {
		this.date=date;
	}

	@Override
	public void fetchDate(FetcherCallBack fcb) {
		try{
			//前置任务
			for(int i=0;i<list.size();i++){
				list.get(i).doFilter();
			}
			
			fcb.onDate(date);
		}catch (Exception e) {
			//后置任务
			for(int i=0;i<list.size();i++){
				list.get(i).handlerException();
			}
			
			fcb.onError(e);
		}
	}

	@Override
	public void addFilter(MyFilter myFilter) {
		if(null!=myFilter){
			list.add(myFilter);
		}
	}

}
