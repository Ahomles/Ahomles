package com.cn.javaFrame.demo.demo02.afactory;

import java.util.HashMap;

public final class CacheFactory {
	//    private static transient Log log;
	private static final HashMap INSTANCE;
    private static boolean IS_READONLY;

	static{
		INSTANCE=new HashMap();
        IS_READONLY = false;
		//初始化一些属性,初始化一些配置文件，加载实现类
//        cacheInstance = (ICache)Class.forName(objCache[i].getId()).newInstance();
//        INSTANCE.put(Class.forName(objCache[i].getId()), cacheInstance);
	}
	private CacheFactory(){
	}

//	    public static boolean containsKey(Class clazz, Object key);
//      public static HashMap getAll(Class clazz);
//      public static Object get(Class clazz, Object key);



	
}
