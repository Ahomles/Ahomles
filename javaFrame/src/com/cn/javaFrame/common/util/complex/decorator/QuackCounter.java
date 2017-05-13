package com.cn.javaFrame.common.util.complex.decorator;

import com.cn.javaFrame.common.util.complex.interfaces.Quackable;
import com.cn.javaFrame.common.util.complex.observer.Observer;

public class QuackCounter implements Quackable{
	public Quackable quackable;
	static int numberOfQuack;

	
	public QuackCounter(Quackable quackable) {
		this.quackable = quackable;
	}

	@Override
	public void quack() {
		quackable.quack();
		numberOfQuack++;
	}

	public static int getNumberOfQuack(){
		return numberOfQuack;
	}

	
	//装饰者对观察对象的处理
	@Override
	public void registerObserver(Observer observer) {
		quackable.registerObserver(observer);
	}

	@Override
	public void notifyObservers() {
		quackable.notifyObservers();
	}
}
