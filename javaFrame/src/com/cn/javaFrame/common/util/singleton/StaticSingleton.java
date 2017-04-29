package com.cn.javaFrame.common.util.singleton;

public class StaticSingleton {
	private StaticSingleton(){
		System.out.println("StaticSingleton is create");
	}
	/**
	 * 1��ʹ���ڲ�����ά��������ʵ��
	 * >ʵ���ӳټ��أ�������getInstanceʱ����SingletonHolder��
	 * >���ö��̣߳����ü�ͬ���ؼ���
	 * >���л��ͷ����л����ܻ��ƻ�������һ�㲻�ǶԵ������л�������ע��
	 * @author zhunb3
	 *
	 */
	private static class SingletonHolder{
		private static StaticSingleton instance=new StaticSingleton();
	}
	
	public static StaticSingleton getInstance(){
		return SingletonHolder.instance;
	}
	
}
