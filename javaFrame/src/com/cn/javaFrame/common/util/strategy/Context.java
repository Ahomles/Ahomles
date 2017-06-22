package com.cn.javaFrame.common.util.strategy;

/**
 * 环境类
 * @author zhunb3
 *
 */
public class Context {
	private IStrategy strategy;

	public Context(IStrategy strategy) {
		this.strategy=strategy;
	}
	public void setStrategy(IStrategy strategy) {
		this.strategy = strategy;
	}
	
	public void invoke(){
		
		strategy.invoke();
		
	}
	
	public static void main(String[] args) {
		
	}
	
}
