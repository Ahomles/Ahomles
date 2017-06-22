package com.cn.javaFrame.common.util.dataConvert.beanutil.bean1;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamImplicitCollection;

@XStreamAlias("Cust")
public class Cust {
	@XStreamAlias("NAME")
	private String name;
	
	@XStreamAlias("Students")
	@XStreamImplicit(itemFieldName="stu") //去掉Student
	private List<String> students;
	private String test;
	
	@XStreamAlias("City")
	private City city;
	
	@XStreamAlias("Citys")
	private List<City> citys;
	
	
	public List<City> getCitys() {
		return citys;
	}
	public void setCitys(List<City> citys) {
		this.citys = citys;
	}
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	
	public List<String> getStudents() {
		return students;
	}
	public void setStudents(List<String> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "Cust [name=" + name + ", city=" + city + "]";
	}
	
	
}
