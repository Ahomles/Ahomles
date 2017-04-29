package com.cn.javaFrame.common.util.newInstance;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceManager {
	private ServiceManager(){
	}
	private static final Map<String,Provider> providers=new ConcurrentHashMap<String, Provider>();
	private static final String DEFAULT_PROVIDER_NAME="def";
	public static void registerProvider(Provider provider){
		providers.put(DEFAULT_PROVIDER_NAME, provider);
	}
	public static void registerProvider(String name,Provider provider){
		providers.put(name, provider);
	}
	
	public static Service getSerivceInstance() throws Exception{
		return newInstance(DEFAULT_PROVIDER_NAME);
	}
	public static Service newInstance(String name) throws Exception{
		Provider provider=providers.get(name);
		if(provider==null){
			throw new Exception("No provider registered with name:"+name);
		}
		return provider.newService();
	}
}
