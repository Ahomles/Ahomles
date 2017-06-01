package com.cn.javaFrame.common.util.dataConvert.test.bean;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author zhunb3
 *
 */
public class Person {
	private int id;
	private String name;
	private long age;
	private Date createDate;
	private Timestamp modifyDate;
	private Date ExpirDate;
	private int flag;
	
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public Date getExpirDate() {
		return ExpirDate;
	}
	public void setExpirDate(Date expirDate) {
		ExpirDate = expirDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getAge() {
		return age;
	}
	public void setAge(long age) {
		this.age = age;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Timestamp getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age
				+ ", createDate=" + createDate + ", modifyDate=" + modifyDate
				+ ", ExpirDate=" + ExpirDate +", flag=" + flag + "]";
	}
	
}
