package com.cn.javaFrame.common.util.complex.observer;

public class Quackologist implements Observer {

	@Override
	public void update(QuackObservable duck) {
		System.out.println("Quackologist: "+duck+" just quacked.");
	}

}
