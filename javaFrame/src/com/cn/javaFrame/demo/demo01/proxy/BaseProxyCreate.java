package com.cn.javaFrame.demo.demo01.proxy;

import javassist.ClassPool;

public class BaseProxyCreate {
	protected ClassPool pool;
	protected String tmpDir;
	public BaseProxyCreate(String aTempDir,ClassPool apool) {
		tmpDir=aTempDir;
		pool=apool;
	}
	
	
	
}
