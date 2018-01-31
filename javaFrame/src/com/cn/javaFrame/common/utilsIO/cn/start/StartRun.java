package com.cn.javaFrame.common.utilsIO.cn.start;

import com.cn.javaFrame.common.utilsIO.cn.service.Receive;

public class StartRun {
	public static void main(String[] args) throws InterruptedException {
		Receive run=new Receive();
		run.await();
	}
}
