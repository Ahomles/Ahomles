package com.cn.javaFrame.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ExceptionTest {
	private final static transient Log log = LogFactory.getLog(ExceptionTest.class);
	public static void main(String[] args) {
		try{
			throw new Exception("znb");
		}catch (Exception e) {
			if(log.isErrorEnabled())
				log.error(e);
//			e.printStackTrace();
			
		}finally{
			System.out.println("finally");
		}
		System.out.println("test");
	}
}
