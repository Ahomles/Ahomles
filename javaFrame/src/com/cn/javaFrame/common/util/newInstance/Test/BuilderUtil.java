package com.cn.javaFrame.common.util.newInstance.Test;

import java.util.Map;

import com.cn.javaFrame.common.util.newInstance.Call;
import com.cn.javaFrame.common.util.newInstance.ServiceBuilder;


public class BuilderUtil {
	public static Call userBuilder(final Map map){
		
		return new Call<ServiceBuilder>(){

			@Override
			public void call(ServiceBuilder serviceBuilder) {
				serviceBuilder.setName(mapString(map,"name"));
			}
		};
	}
	
	public static String mapString(Map map,String key){
		if(map.isEmpty()||map == null)
			return null;
		Object str=map.get(key);
		if(str instanceof String){
			return (String) str;
		}
		return str.toString();
	}
			
}
