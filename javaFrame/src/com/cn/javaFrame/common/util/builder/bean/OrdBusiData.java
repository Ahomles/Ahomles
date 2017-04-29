package com.cn.javaFrame.common.util.builder.bean;

import java.util.ArrayList;
import java.util.List;

public class OrdBusiData {
	private OrdBusi ordBusi;
	private List<OrdUser> ordUsers=new ArrayList<OrdUser>();

	
	public OrdBusi getOrdBusi() {
		return ordBusi;
	}

	public void setOrdBusi(OrdBusi ordBusi) {
		this.ordBusi = ordBusi;
	}

	public List<OrdUser> getOrdUsers() {
		return ordUsers;
	}

	public void setOrdUsers(List<OrdUser> ordUsers) {
		this.ordUsers = ordUsers;
	}
}
