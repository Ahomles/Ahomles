package com.cn.javaFrame.common.netty.demo1_callBack;

import java.util.Date;

public class MyFetcherCallBack implements FetcherCallBack {

	@Override
	public void onDate(Date date) {
		System.out.println(date);
	}

	@Override
	public void onError(Exception e) {
		System.out.println("异常已经处理");
	}

}
