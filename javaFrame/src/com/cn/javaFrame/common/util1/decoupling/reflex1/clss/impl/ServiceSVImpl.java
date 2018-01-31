package com.cn.javaFrame.common.util1.decoupling.reflex1.clss.impl;

import java.util.Map;

import com.cn.javaFrame.common.util1.decoupling.reflex1.clss.interfaces.IServiceSV;


public class ServiceSVImpl implements IServiceSV{

	@Override
	public Map test01(Map name) throws Exception {
		System.out.println("test01");
		return null;
	}

	@Override
	public Map test02(Map name) throws Exception {
		System.out.println("test02");
		return null;
	}

	@Override
	public Map test03(Map name) throws Exception {
		System.out.println("test03");
		return null;
	}

	@Override
	public Map test04(Map name) throws Exception {
		System.out.println("test04");
		return null;
	}


}
