package com.cn.javaFrame.common.util.builder.bean;

import java.util.ArrayList;
import java.util.List;

public class OrdCustData {
	private OrdCust ordCust;
	private List<OrdBusiData> ordBusiDatas=new ArrayList<OrdBusiData>();
	public OrdCust getOrdCust() {
		return ordCust;
	}
	public void setOrdCust(OrdCust ordCust) {
		this.ordCust = ordCust;
	}
	public List<OrdBusiData> getOrdBusiDatas() {
		return ordBusiDatas;
	}
	public void setOrdBusiDatas(List<OrdBusiData> ordBusiDatas) {
		this.ordBusiDatas = ordBusiDatas;
	}
}
