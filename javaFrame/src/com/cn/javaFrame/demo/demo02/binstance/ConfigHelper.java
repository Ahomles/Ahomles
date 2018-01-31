package com.cn.javaFrame.demo.demo02.binstance;
/**
 * 单例实例1
 * 懒加载，懒汉式
 * 案例：加载配置文件中的配置对象
 * @author zhunb3
 *
 */
public class ConfigHelper {
	//1.日志属性
    //2.RemoteTransportServer核心属性对象
    //List和Map相关容器，解析的配置对象
    private static class LazyHolder
    {
        private static final ConfigHelper INSTANCE = new ConfigHelper();
        private LazyHolder()
        {
        }
    }
    
	private ConfigHelper(){
		//3.加载配置文件,解析配置文件为一个对象
		//do something ,解析xml文件
		init();
	}
	
	private void init(){
		//4.实例化配置文件的中的对象，并做一些初始化工作
		//do something ,根据xml配置，对类做一些初始化工作
	}
	
	//5.返回单例实例
    public static final ConfigHelper getInstance()
    {
        return LazyHolder.INSTANCE;
    }
    
    //6.更新配置文件的内容
    public void updateConfig(String server){
    	//1.Clear掉Map.clear(),Object=null; 
    	//2.重新像构造方法中一样读取配置文件。
    	//do something ,重新解析xml文件
    	//3.初始化init()
    	init();
    }
}
