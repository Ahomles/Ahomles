package com.cn.javaFrame.common.util.dataConvert.beanutil.bean;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("PUBINFO")
public class PubInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JSONField(name="ACTCHNLTYPE")
	public String actchnlType;
	
	@JSONField(name="CHNLTYPE")
	public String chnlType;
	
	@XStreamAlias("SYSOPID")
	@JSONField(name="SYSOPID")
	public String sysOpid;
	
	@JSONField(name="SYSPWD")
	public String sysPwd;
	
	@JSONField(name="OPID")
	public String opId;
	
	@JSONField(name="ORGID")
	public String orgId;
	
	@JSONField(name="OPCODE")
	public String opCode;

	@XStreamAlias("REGIONCODE")
	@JSONField(name="REGIONCODE")
	public String regionCode;
	
	@JSONField(name="COUNTYCODE")
	public String countyCode;
	
	@JSONField(name="PROVINCECODE")
	public String provinceCode;
	
	public String getActchnlType() {
		return actchnlType;
	}
	public void setActchnlType(String actchnlType) {
		this.actchnlType = actchnlType;
	}
	public String getChnlType() {
		return chnlType;
	}
	public void setChnlType(String chnlType) {
		this.chnlType = chnlType;
	}
	public String getSysOpid() {
		return sysOpid;
	}
	public void setSysOpid(String sysOpid) {
		this.sysOpid = sysOpid;
	}
	public String getSysPwd() {
		return sysPwd;
	}
	public void setSysPwd(String sysPwd) {
		this.sysPwd = sysPwd;
	}
	public String getOpId() {
		return opId;
	}
	public void setOpId(String opId) {
		this.opId = opId;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getOpCode() {
		return opCode;
	}
	public void setOpCode(String opCode) {
		this.opCode = opCode;
	}
	public String getRegionCode() {
		return regionCode;
	}
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	public String getCountyCode() {
		return countyCode;
	}
	public void setCountyCode(String countyCode) {
		this.countyCode = countyCode;
	}
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	
}
