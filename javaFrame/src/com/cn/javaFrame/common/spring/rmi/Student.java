package com.cn.javaFrame.common.spring.rmi;

import java.rmi.RemoteException;

public class Student implements IStudent{

	@Override
	public String qryName() throws RemoteException {
		return "hello znb";
	}

}	
