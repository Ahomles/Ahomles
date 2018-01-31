package com.cn.javaFrame.demo.demo01.proxy;

import com.cn.javaFrame.demo.demo01.proxy.handler.ServiceManagerHandle;

public interface BaseProxy {
	public ServiceManagerHandle getServiceManagerHandle();
	
	public void setServiceManagerHandle(ServiceManagerHandle servicemanagerhandle);

	public String getServiceName();
	
	public void setServiceName(String serviceName);
	
	public String getTransactionName();
	
	public void setTransactionName(String transactionName);

	public String getTransactionType();

	public void setTransactionType(String transactionType);
}
