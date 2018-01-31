package com.cn.javaFrame.demo.demo01.xml.document;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;


public class Test {
	public static void main(String[] args) {
		String str="";
		StringReader stringReader  =  new StringReader(str);
		InputSource  inputSource  =  new  InputSource(stringReader);
		
//		Document  document =  documentBuilder.parse(inputSource ) ;
	}
}
