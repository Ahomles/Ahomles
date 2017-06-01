package com.cn.javaFrame.common.util.dataConvert.factory;

import com.cn.javaFrame.common.util.dataConvert.busi.impl.EsbBusiImpl;
import com.cn.javaFrame.common.util.dataConvert.busi.interfaces.IEsbBusi;

public class ServiceFactory {
	//具体的实现暂时不管

	public static IEsbBusi getService(Class<?> class1) {
		return new EsbBusiImpl();
	}
}
