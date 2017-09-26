package com.cn.javaFrame.common.util.dataConvert;

import java.util.Arrays;
import java.util.List;

import com.cn.javaFrame.common.util1.json.Person;

public class ListUtil {
	public static void main(String[] args) {
		Person[] p = new Person[1];
		p[0] = new Person();
		p[0].setAge("2");
		p[0].setName("znb");

		List<Person> list = Arrays.asList(p);

		System.out.println(Arrays.toString(p));

		System.out.println(list.size() + "," + list);

	}
}
