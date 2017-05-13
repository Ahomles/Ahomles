package com.cn.javaFrame.common.util.complex.factory;

import com.cn.javaFrame.common.util.complex.interfaces.Quackable;

public abstract class AbstractDuckFactory {
	public abstract Quackable createMallardDuck();
	public abstract Quackable createRedheadDuck();
	public abstract Quackable createDuckCall();
	public abstract Quackable createRubberDuck();
}
