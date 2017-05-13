package com.cn.javaFrame.common.util.order;

public class SimpleRemoteControl {
	public Command slot;
	public SimpleRemoteControl() {
	}
	public void setCommand(Command command) {
		this.slot = command;
	}
	public void buttonWasPressed(){
		slot.execute();
	}
	
}
