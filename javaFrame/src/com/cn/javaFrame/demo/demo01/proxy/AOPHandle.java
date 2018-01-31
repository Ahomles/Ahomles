package com.cn.javaFrame.demo.demo01.proxy;

public interface AOPHandle {
	public void handleBefore();
	public void handleOK();
	public void handleAfter();
	public void handleException();
}
