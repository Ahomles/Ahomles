package com.cn.javaFrame.common.util1.decoupling.reflex1.clss.impl;

import com.cn.javaFrame.common.util1.decoupling.reflex1.clss.interfaces.IParentSV;

public class ChildCSVImpl implements IParentSV{

	@Override
	public void invoke() throws Exception {
		System.out.println("C");
	}

}
