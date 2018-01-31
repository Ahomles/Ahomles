package com.cn.javaFrame.common.netty.demo1_callBack;

import java.util.Date;

public class Worker {
	public void doWork() {
		Fetcher f=new MyFetcher(new Date());
//		FetcherCallBack fcb=new MyFetcherCallBack();
//		f.fetchDate(fcb);
		
		f.addFilter(new MyFilter(){
			@Override
			public void doFilter(){
				System.out.println("过滤器1");
			}
			@Override
			public void handlerException(){
				System.out.println("异常过滤器1");
			}
		});
		f.fetchDate(new FetcherCallBack() {
			
			@Override
			public void onError(Exception e) {
				System.out.println("异常已经处理");
			}
			
			@Override
			public void onDate(Date date) {
				int i=5/0;
				System.out.println(date);
			}
		});
		
	}
}
