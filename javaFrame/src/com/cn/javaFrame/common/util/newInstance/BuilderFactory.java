package com.cn.javaFrame.common.util.newInstance;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BuilderFactory {
	 //获得创建者的本地方法
    private static Map<String , Method> builderMethod= new ConcurrentHashMap<String , Method>();
                                                                                                                                                      
    static {
    	Method[] methods=BuilderFactory.class.getMethods();
    	for(Method method:methods){
    		if(!method.getName().equalsIgnoreCase("newBuider")&&method.getParameterTypes().length ==0){
    			  String rtnClassName =method.getReturnType().getName();
                  builderMethod.put(rtnClassName ,method);
    		}
    	}
    }
    //ServiceBuilder(String):newServiceBuilder(Method)
    public static ServiceBuilder newServiceBuilder(){
    	return new ServiceBuilder();
    }
    
    public static<T> T newBuilder(Class clazz) throws Exception{
    	Method method=builderMethod.get(clazz.getName());
    	if(method!=null){
    		return (T) method.invoke(null);
    	}
    	throw new RuntimeException("没有这种创建对象的构造方法");
    }
}
