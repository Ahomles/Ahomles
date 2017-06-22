package com.cn.javaFrame.common.util.dataConvert.beanutil.bean;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by xuxx3 on 2016/5/13.
 */
@XStreamAlias("OFFERINFO")
public class OfferInfo implements Serializable {

	/**
	 * 策划信息Pojo
	 */
	private static final long serialVersionUID = 1L;

	// 策划实例编号
	@XStreamAlias("OFFERINSTID")
	@JSONField(name="OFFERINSTID")
	public String offerInstId;
	// 业务操作编号
	@XStreamAlias("BUSINESSID")
	@JSONField(name="BUSINESSID")
	public String businessId;
	// 操作类型
	@XStreamAlias("OPERTYPE")
	@JSONField(name="OPERTYPE")
	public String operType;
	// 是否主角色
	@XStreamAlias("ISMANAGERROLE")
	@JSONField(name="ISMANAGERROLE")
	public String isManagerRole;
	// 修改状态
	@XStreamAlias("STATE")
	@JSONField(name="STATE")
	public String state;
	
	public String getOfferInstId() {
		return offerInstId;
	}
	public void setOfferInstId(String offerInstId) {
		this.offerInstId = offerInstId;
	}
	public String getBusinessId() {
		return businessId;
	}
	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}
	public String getOperType() {
		return operType;
	}
	public void setOperType(String operType) {
		this.operType = operType;
	}
	public String getIsManagerRole() {
		return isManagerRole;
	}
	public void setIsManagerRole(String isManagerRole) {
		this.isManagerRole = isManagerRole;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
