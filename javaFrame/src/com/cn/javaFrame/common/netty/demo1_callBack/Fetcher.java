package com.cn.javaFrame.common.netty.demo1_callBack;

public interface Fetcher {
	
	void fetchDate(FetcherCallBack fcb);

	void addFilter(MyFilter myFilter);
}
