package com.cn.javaFrame.common.netty.demo1_callBack;

import java.util.Date;

public interface FetcherCallBack {

	void onDate(Date date);

	void onError(Exception e);
		
}
