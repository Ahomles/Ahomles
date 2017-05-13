package com.cn.javaFrame.common.util.order.commandImpl;

import com.cn.javaFrame.common.util.order.Command;

public class GarageDoorOpenCommand implements Command {

	public GarageDoor garageDoor;
	
	public GarageDoorOpenCommand(GarageDoor garageDoor) {
		this.garageDoor = garageDoor;
	}


	@Override
	public void execute() {

	}
	
	
	private void upCommand() {

	}
	
	private void domnCommand() {

	}
	
	private void stopCommand() {

	}
	
	private void lightOnCommand() {

	}
	
	private void lightOff() {
		// TODO Auto-generated method stub

	}

}
