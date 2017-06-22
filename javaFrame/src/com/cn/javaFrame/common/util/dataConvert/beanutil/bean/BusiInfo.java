package com.cn.javaFrame.common.util.dataConvert.beanutil.bean;
import com.alibaba.fastjson.annotation.JSONField;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;
import java.util.List;

/**
 * Created by xuxx3 on 2016/5/16.
 */
@XStreamAlias("BUSIINFO")
public class BusiInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 工单编号
	@XStreamAlias("TASKID")
	@JSONField(name = "TASKID")
	public String taskId;
	// 客户订单编号
	@XStreamAlias("CUSTORDID")
	@JSONField(name = "CUSTORDID")
	public String custOrdId;
	// 客户信息
	@XStreamAlias("CUSTINFO")
	@JSONField(name = "CUSTINFO")
	public CustInfo custInfo;
	// 账户信息
	@XStreamAlias("ACCTINFO")
	@JSONField(name = "ACCTINFO")
	public AcctInfo acctInfo;
	// 策划列表
	@XStreamAlias("OFFERINFOLIST")
	@JSONField(name = "OFFERINFOLIST")
	public List<OfferInfo> offerInfoList;
	// 备注
	@XStreamAlias("REMARKS")
	@JSONField(name = "REMARKS")
	public String remarks;

	public String getTaskId() {
		return taskId;
	}
	
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getCustOrdId() {
		return custOrdId;
	}

	public void setCustOrdId(String custOrdId) {
		this.custOrdId = custOrdId;
	}

	public CustInfo getCustInfo() {
		return custInfo;
	}

	public void setCustInfo(CustInfo custInfo) {
		this.custInfo = custInfo;
	}

	public AcctInfo getAcctInfo() {
		return acctInfo;
	}

	public void setAcctInfo(AcctInfo acctInfo) {
		this.acctInfo = acctInfo;
	}

	public List<OfferInfo> getOfferInfoList() {
		return offerInfoList;
	}

	public void setOfferInfoList(List<OfferInfo> offerInfoList) {
		this.offerInfoList = offerInfoList;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
