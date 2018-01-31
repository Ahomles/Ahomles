package com.cn.javaFrame.demo.demo02.binstance;

import com.cn.javaFrame.demo.demo02.binstance.xmlHelper.Caches;
import com.cn.javaFrame.demo.demo02.binstance.xmlHelper.Defaults;
/**
 * 变形单例实例3
 * 模拟读取配置文件，并初始化
 * @author zhunb3
 * XMLHelper.getInstance().getDefaults();
 */
public class XMLHelper {
	 static 
	 {
	        isInit = Boolean.FALSE;
	        isCacheInit = Boolean.FALSE;
	 }
	 
     private static Boolean isInit;
     private static Boolean isCacheInit;
     private static XMLHelper instance = null;
     private static Defaults defaults  = null;
     private static Caches caches  = null;

	 private XMLHelper()
	 {
	 }
	 public static XMLHelper getInstance()throws Exception
	 {
	        if(isInit.equals(Boolean.FALSE))
	        {
	            synchronized(isInit)
	            {
	                if(isInit.equals(Boolean.FALSE))
	                {
	                	//主要的配置文件
	                    defaults = createDefaults();
	                    isInit = Boolean.TRUE;
	                }
	            }
	            instance = new XMLHelper();
	        }
	        return instance;
	 }
	 public Defaults getDefaults(){
		 return defaults;
	 }
	 
     public Caches getCaches()
     {
        if(caches == null)
            synchronized(isCacheInit)
            {
                if(isCacheInit.equals(Boolean.FALSE))
                    try
                    {
                        caches = createCaches();
                        isCacheInit = Boolean.TRUE;
                    }
                    catch(Throwable ex)
                    {
                        throw new RuntimeException(ex);
                    }
            }
        return caches;
     }
     
     private static Defaults createDefaults(){
    	 //读取配置文件
    	 return null;
     }
     private static Caches createCaches(){
    	 //读取配置文件
    	 return null;
     }

}
