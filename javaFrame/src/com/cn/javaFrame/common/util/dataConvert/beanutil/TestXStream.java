package com.cn.javaFrame.common.util.dataConvert.beanutil;

import java.util.ArrayList;
import java.util.List;

import com.cn.javaFrame.common.util.dataConvert.beanutil.bean1.City;
import com.cn.javaFrame.common.util.dataConvert.beanutil.bean1.Cust;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class TestXStream {
	public static void main(String[] args) {
		test01();
	}
	//http://blog.csdn.net/robert_mm/article/details/8459879
	/**
	 * 注解的分析，和转换器
	 */
	private static void test01() {
		/**
		 * 对象转化为XML
		 */
		XStream xstream = new XStream(new Dom4JDriver());//xml解析器
		xstream.autodetectAnnotations(true);//自动检测注解
		Cust cust=new Cust();
		cust.setName("南京");
		
		City city=new City();
		cust.setCity(city);
		city.setAddAddress("雨花区");
		city.setAddress("江宁");
		City city1=new City();
		city1.setAddAddress("雨花区");
		city1.setAddress("江宁");
		City city2=new City();
		city2.setAddAddress("雨花区");
		city2.setAddress("江宁");
		
		List<City> citys=new ArrayList<City>();
		cust.setCitys(citys);
		citys.add(city1);
		citys.add(city2);
		
		List<String> students=new ArrayList<String>();
		students.add("stu1");
		students.add("stu2");
		cust.setStudents(students);
		
		String xml=xstream.toXML(cust);
		System.out.println(xml);
		
		Cust cust2=new Cust();
		cust2=(Cust) xstream.fromXML(xml);
		System.out.println(cust2);
		
	}
	
}
