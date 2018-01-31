package com.cn.javaFrame.common.util1.reflex.impl;

import com.cn.javaFrame.common.util1.reflex.interfaces.IServiceSV;

public class ServiceSVImpl implements IServiceSV {

	@Override
	public String getName(String name) {
		return name+"你好";
	}

	@Override
	public void initName() {
		System.out.println("init");
	}

}
