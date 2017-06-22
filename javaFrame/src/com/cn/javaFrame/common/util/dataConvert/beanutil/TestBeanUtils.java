package com.cn.javaFrame.common.util.dataConvert.beanutil;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import com.cn.javaFrame.common.util.dataConvert.test.bean.Person;
import com.cn.javaFrame.common.util.dataConvert.test.bean.Personal;

public class TestBeanUtils {
	public static void main(String[] args) {
		/**
		 * 对象转化未对象，Map转化为对象
		 * commons-beanutils-1.0.jar 
		 * commons-collections-3.0.jar 
		 * 三种使用方式：
		 * 用法1： 对象属性的拷贝
		 * BeanUtils.copyProperty(admin, "userName", "jack");
		 * BeanUtils.setProperty(admin, "age", 18);
		 * Test1();
		 * 用法2：对象的拷贝
		 * BeanUtils.copyProperties(newAdmin, admin);
		 * Test2();
		 * 用法3： map数据拷贝到javabean中 
		 * 注意：map中的key要与javabean的属性名称一致
		 * BeanUtils.populate(adminMap, map);
		 * Test3();
		 */
			try {
//				Test1();
				test3();
			} catch (Exception e) {
				e.printStackTrace();
			}
//			Timestamp time=new Timestamp(123123515l);
//			System.out.println(time);
	}


	/**
	 * commons-beanutils-1.0.jar 
	 * commons-collections-3.0.jar 对待日期的特殊处理
	 */
	/**
	 * 给对象添加属性
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static void Test1() throws IllegalAccessException,
			InvocationTargetException {
		//给对象添加属性
		Person person = new Person();
		BeanUtils.setProperty(person, "name", "jack");
		BeanUtils.copyProperty(person, "id", 123);
		BeanUtils.copyProperty(person, "age", "124");
//		registDate();
//		BeanUtils.copyProperty(person, "createDate", "2017-05-01 12:00:00");
		registTimesql();
		BeanUtils.copyProperty(person, "modifyDate", "2017-05-02 12:00:00");
		System.out.println(person);
	}
	/**
	 * 对象属性的相互拷贝
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static void Test2() throws IllegalAccessException,
	InvocationTargetException {
		Person person = new Person();
		Personal p=new Personal();
		BeanUtils.setProperty(p, "name", "jack");
		BeanUtils.copyProperty(p, "id", 123);
		BeanUtils.copyProperty(p, "age", "124");
//		registTimesql();
//		BeanUtils.copyProperty(p, "createDate", "2017-05-02 12:00:00");
		Timestamp cutTime=new Timestamp(System.currentTimeMillis());
		Date cutTime2=new Date(System.currentTimeMillis());
		p.setCreateDate(cutTime);
		
		registTimesql();
		BeanUtils.copyProperties(person, p);
		System.out.println(person);
		
	}
	public static void test3() throws Exception{
		Person p = new Person();
		Map properties=new HashMap();
		properties.put("id", "123");
		properties.put("name", "123");
		properties.put("age", "123");
//		BeanUtils.setProperty(p, "name", "jack");
//		BeanUtils.copyProperty(p, "id", 123);
//		BeanUtils.copyProperty(p, "age", "124");
		properties.put("modifyDate", "2017-05-02 12:00:00");
		registTimesql();//这个只能转化为TimeStamp不能转化未Date
//		registDate(); 
//		BeanUtils.copyProperty(p, "createDate", "2017-05-02 12:00:00");
		BeanUtils.populate(p,properties);
		System.out.println(p);
	}
	public static void registDate() {
		ConvertUtils.register(new Converter() {
			// 转换的内部实现方法，需要重写
			@Override
			public Object convert(Class type, Object value) {

				// 判断TimeStame是Date的子类
				if (type != Date.class) {
					return null;
				}
				if (value == null || "".equals(value.toString().trim())) {
					return null;
				}

				try {
					// 字符串转换为日期
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					return sdf.parse(value.toString());
				} catch (ParseException e) {
					throw new RuntimeException(e);
				}
			}
		}, Date.class);
	}
	public static void registTimesql() {
		ConvertUtils.register(new Converter() {
			// 转换的内部实现方法，需要重写
			@Override
			public Object convert(Class type, Object value) {
				
				// 判断
				if (type != Timestamp.class) {
					return null;
				}
				if (value == null || "".equals(value.toString().trim())) {
					return null;
				}
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//					if(value instanceof Date){
//						return new Timestamp(((Date)value).getTime());
//					}else{
						System.out.println("====");
						return new Timestamp(sdf.parse(value.toString()).getTime());
//					}
					// 字符串转换为日期
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}, Timestamp.class);
	}

	public static void registDefaultDate() {
		// 注册日期类型转换器：2， 使用组件提供的转换器工具类
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
	}
}
