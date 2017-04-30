package com.cn.javaFrame.common.util.newInstance.Test;

import java.util.Map;

import com.cn.javaFrame.common.util.newInstance.Call;

public class CommonBuilder {
	public static Call setBuilder(Map map){
		return BuilderUtil.userBuilder(map);
	}
	
}
