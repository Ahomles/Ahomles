package com.cn.javaFrame.demo.demo02.binstance;
/**
 * 单例实例2
 * 懒加载，懒汉式
 * 案例：
 * @author zhunb3
 *
 */
public class ServerController {
	//1.日志属性
	//2.RemoteTransportServer核心属性对象
	//List和Map相关容器，解析的配置对象
    private static volatile ServerController INSTANCE = null;
    private static Object INSTANCE_LOCKER = new Object();
    
    private ServerController(){
    	
    }
    
    public static ServerController getInstance(){
    	if(null==INSTANCE)
    		 synchronized(INSTANCE_LOCKER)
             {
    			 if(null==INSTANCE){
    				 INSTANCE = new ServerController();
    			 }
             }
    	return INSTANCE;
    }
    
    public void start(String serverCode){
    	
    }
    
}
