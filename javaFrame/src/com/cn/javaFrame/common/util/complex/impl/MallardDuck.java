package com.cn.javaFrame.common.util.complex.impl;

import com.cn.javaFrame.common.util.complex.interfaces.Quackable;
import com.cn.javaFrame.common.util.complex.observer.Observable;
import com.cn.javaFrame.common.util.complex.observer.Observer;

public class MallardDuck implements Quackable {
	Observable observable;
	
	
	public MallardDuck() {
		this.observable = new Observable(this);
	}

	@Override
	public void quack() {
		System.out.println("Quack");
		notifyObservers();
	}

	
	//委托类即代理
	public void registerObserver(Observer observer) {
		observable.registerObserver(observer);
	}

	public void notifyObservers() {
		observable.notifyObservers();
	}

}
