package com.cn.javaFrame.common.util.complex.service;

import com.cn.javaFrame.common.util.complex.adapter.GooseAdapter;
import com.cn.javaFrame.common.util.complex.composite.Flock;
import com.cn.javaFrame.common.util.complex.decorator.QuackCounter;
import com.cn.javaFrame.common.util.complex.factory.AbstractDuckFactory;
import com.cn.javaFrame.common.util.complex.factory.CountingDuckFactory;
import com.cn.javaFrame.common.util.complex.impl.RedGoose;
import com.cn.javaFrame.common.util.complex.interfaces.Goose;
import com.cn.javaFrame.common.util.complex.interfaces.Quackable;
import com.cn.javaFrame.common.util.complex.observer.Quackologist;

public class DuckSimulator3 {
	public static void main(String[] args) {
		DuckSimulator3 duckSim=new DuckSimulator3();
		AbstractDuckFactory factory = new CountingDuckFactory();
		duckSim.simulator(factory);
	}
	
	
	void simulator(AbstractDuckFactory factory){
		
		//创建一群鸭子
		Flock ducks=createDucks(factory);
		
		//鸭子群的观察者
		Quackologist quackologist=new Quackologist();
		ducks.registerObserver(quackologist);
		
		//群鸭子叫
		simulator(ducks);
		
		//群鸭子叫了多少下
		int numberCount=QuackCounter.getNumberOfQuack();
		System.out.println(numberCount);
		
	}
	
	public Flock createDucks(AbstractDuckFactory factory){
		Quackable mallDuck= factory.createMallardDuck();
		Quackable redDuck=factory.createRedheadDuck();
		Quackable duckCall=factory.createDuckCall();
		Quackable rubbleDuck=factory.createRubberDuck();
		
		
		
		//将鹅适配成鸭子
		Goose redGoose=new RedGoose();
		Quackable gooseDuck=new QuackCounter(new GooseAdapter(redGoose));

		Flock flock=new Flock();
		flock.add(mallDuck);
		flock.add(redDuck);
		flock.add(duckCall);
		flock.add(rubbleDuck);
		
		Flock mainFlock=new Flock();   
		mainFlock.add(flock);
		mainFlock.add(gooseDuck);
		
		return mainFlock;
	}
	
	void simulator(Quackable duck){
		duck.quack();
	}
}
