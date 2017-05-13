package com.cn.javaFrame.common.util.complex.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.cn.javaFrame.common.util.complex.interfaces.Quackable;
import com.cn.javaFrame.common.util.complex.observer.Observer;

/**
 *  组合模式
 * @author zhunb3
 *
 */
public class Flock implements Quackable{
	
	List quackers=new ArrayList();
	
	public void add(Quackable quacker){
		quackers.add(quacker);
	}
	

	@Override
	public void quack() {	
		Iterator iterator=quackers.iterator();
		while(iterator.hasNext()){
			Quackable quacker=(Quackable)iterator.next();
			quacker.quack();
		}
	}


	@Override
	public void registerObserver(Observer observer) {
		Iterator iterator=quackers.iterator();
		while(iterator.hasNext()){
			Quackable quacker=(Quackable)iterator.next();
			quacker.registerObserver(observer);
		}
	}


	@Override
	public void notifyObservers() {
		Iterator iterator=quackers.iterator();
		while(iterator.hasNext()){
			Quackable quacker=(Quackable)iterator.next();
			quacker.notifyObservers();
		}
	}
}
