package com.cn.javaFrame.demo.demo02.singleton;

public final class Singleton {
	private volatile static Singleton intance=null;
	private static Object INSTANCE_LOCKER = new Object();;
	private Singleton(){
		//do something
	}
	public static Singleton getSingleton(){
		if(null==intance){
			synchronized(INSTANCE_LOCKER){
				if(null==intance){
					intance = new Singleton();
				}
			}
		}
		return intance;
	}
	
}




