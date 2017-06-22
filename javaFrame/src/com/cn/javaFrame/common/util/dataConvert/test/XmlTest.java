package com.cn.javaFrame.common.util.dataConvert.test;

import java.io.File;
import java.util.Map;

import com.cn.javaFrame.common.util.dataConvert.util.XmlUtil;
import com.cn.javaFrame.common.util.file.FileUtil;

public class XmlTest {
	private static final String path = System.getProperty("user.dir") + File.separator + "src"
			+ File.separator + "com" + File.separator + "cn"
			+ File.separator + "javaFrame" + File.separator + "common"
			+ File.separator + "util" + File.separator+"dataConvert"
			+ File.separator+"test"+File.separator;
	public static void main(String[] args) {
		test01();
	}
	public static void test01(){
		String path2 =path+"root.xml";
		String xmlStr=FileUtil.readFile(path2).toString();
		System.out.println(xmlStr);
		try {
			Map map=XmlUtil.fromXml2Map(xmlStr);
			System.out.println(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
