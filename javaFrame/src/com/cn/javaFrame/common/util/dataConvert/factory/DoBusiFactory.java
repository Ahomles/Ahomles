package com.cn.javaFrame.common.util.dataConvert.factory;

import com.cn.javaFrame.common.util.dataConvert.busi.interfaces.IEsbBusi;

public class DoBusiFactory {
	public static IEsbBusi getIRuleSVWithLog() throws Exception {
		IEsbBusi busiSV =  ServiceFactory.getService(IEsbBusi.class);
		//这个地方使用了代理
		//这个地方从SessionManager中获取operId和orgId进行岗位获取，进行权限判断
		//将岗位ID放到SessionManager中
        return busiSV;
	}
}
