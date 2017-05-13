package com.cn.javaFrame.common.util.complex.factory;

import com.cn.javaFrame.common.util.complex.impl.DuckCall;
import com.cn.javaFrame.common.util.complex.impl.MallardDuck;
import com.cn.javaFrame.common.util.complex.impl.RedheadDuck;
import com.cn.javaFrame.common.util.complex.impl.RubberDuck;
import com.cn.javaFrame.common.util.complex.interfaces.Quackable;

public class DuckFactory extends AbstractDuckFactory{

	@Override
	public Quackable createMallardDuck() {
		return new MallardDuck();
	}

	@Override
	public Quackable createRedheadDuck() {
		return new RedheadDuck();
	}

	@Override
	public Quackable createDuckCall() {
		return new DuckCall();
	}

	@Override
	public Quackable createRubberDuck() {
		return new RubberDuck();
	}

}
