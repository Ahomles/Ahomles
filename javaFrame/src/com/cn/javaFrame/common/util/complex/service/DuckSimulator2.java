package com.cn.javaFrame.common.util.complex.service;

import com.cn.javaFrame.common.util.complex.adapter.GooseAdapter;
import com.cn.javaFrame.common.util.complex.composite.Flock;
import com.cn.javaFrame.common.util.complex.decorator.QuackCounter;
import com.cn.javaFrame.common.util.complex.factory.AbstractDuckFactory;
import com.cn.javaFrame.common.util.complex.factory.CountingDuckFactory;
import com.cn.javaFrame.common.util.complex.impl.RedGoose;
import com.cn.javaFrame.common.util.complex.interfaces.Goose;
import com.cn.javaFrame.common.util.complex.interfaces.Quackable;

public class DuckSimulator2 {
	public static void main(String[] args) {
		DuckSimulator2 duckSim=new DuckSimulator2();
		AbstractDuckFactory factory = new CountingDuckFactory();
		duckSim.simulator(factory);
	}
	
	
	void simulator(AbstractDuckFactory factory){
//		Quackable mallDuck=new MallardDuck();
//		Quackable redDuck=new RedheadDuck();
//		Quackable duckCall=new DuckCall();
//		Quackable rubbleDuck=new RubberDuck();
		
		//将鹅适配成鸭子
//		Goose redGoose=new RedGoose();
//		Quackable gooseDuck=new GooseAdapter(redGoose);
		
//		Quackable mallDuck=new QuackCounter(new MallardDuck());
//		Quackable redDuck=new QuackCounter(new RedheadDuck());
//		Quackable duckCall=new QuackCounter(new DuckCall());
//		Quackable rubbleDuck=new QuackCounter(new RubberDuck());
		
		
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
		
		simulator(mainFlock);
		
		int numberCount=QuackCounter.getNumberOfQuack();
		System.out.println(numberCount);
		
	}
	
	void simulator(Quackable duck){
		duck.quack();
	}
}
