package com.cn.javaFrame.common.demo;

import info.monitorenter.cpdetector.io.ASCIIDetector;
import info.monitorenter.cpdetector.io.CodepageDetectorProxy;
import info.monitorenter.cpdetector.io.JChardetFacade;
import info.monitorenter.cpdetector.io.ParsingDetector;
import info.monitorenter.cpdetector.io.UnicodeDetector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class Test {

	public static String projectPah() {
		String path = System.getProperty("user.dir") + File.separator + "src";
				
		return path;
	}
	public static void main(String[] args) throws IOException {
//		test01();
		String  fileName=projectPah()+File.separator+"encode.txt";
		String name=getFileEncode(fileName);
		System.out.println(name);
		readfile(fileName,"utf-8");
	}
	public static void readfile(String fileName ,String name) throws IOException{
		StringBuffer sb=new StringBuffer();
		InputStream inputStream = new FileInputStream(fileName);  
		BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, name));  
		String str;
		while ((str = in.readLine()) != null) {
			sb.append(str).append("\n");
		}
		in.close();
		System.out.println("你好"+sb.toString());
		System.out.println("碎大发生的");
//		String str1=sb.toString();
//		String strUtf8=new String(str1.getBytes("UTF-8"),"GBK");
//		System.out.println(strUtf8);
		
	}
	
	
	
	public static void test01() throws IOException{
		//测试提交	
		
		String  fileName=projectPah()+File.separator+"encode.txt";
//		BufferedInputStream bin=new BufferedInputStream(new FileInputStream(fileName));
//	    int p = (bin.read() << 8) + bin.read();
//		System.out.println(Integer.toHexString(p));
//		int b=0xefbb;
//		System.out.println(Integer.toHexString(b));
		
		File file = new File(fileName);  
		InputStream in= new java.io.FileInputStream(file);  
		byte[] b = new byte[3];  
		in.read(b);  
		in.close();  
		if (b[0] == -17 && b[1] == -69 && b[2] == -65)  
		    System.out.println(file.getName() + "：编码为UTF-8");  
		else  
		    System.out.println(file.getName() + "：可能是GBK，也可能是其他编码");  
	}
	
	
	public static void test02(){
		
	}
	
	/** 
	 * 利用第三方开源包cpdetector获取文件编码格式 
	 *  
	 * @param path 
	 *            要判断文件编码格式的源文件的路径 
	 * @author huanglei 
	 * @version 2012-7-12 14:05 
	 */  
	public static String getFileEncode(String path) {  
	    /* 
	     * detector是探测器，它把探测任务交给具体的探测实现类的实例完成。 
	     * cpDetector内置了一些常用的探测实现类，这些探测实现类的实例可以通过add方法 加进来，如ParsingDetector、 
	     * JChardetFacade、ASCIIDetector、UnicodeDetector。 
	     * detector按照“谁最先返回非空的探测结果，就以该结果为准”的原则返回探测到的 
	     * 字符集编码。使用需要用到三个第三方JAR包：antlr.jar、chardet.jar和cpdetector.jar 
	     * cpDetector是基于统计学原理的，不保证完全正确。 
	     */  
	    CodepageDetectorProxy detector = CodepageDetectorProxy.getInstance();  
	    /* 
	     * ParsingDetector可用于检查HTML、XML等文件或字符流的编码,构造方法中的参数用于 
	     * 指示是否显示探测过程的详细信息，为false不显示。 
	     */  
	    detector.add(new ParsingDetector(false));  
	    /* 
	     * JChardetFacade封装了由Mozilla组织提供的JChardet，它可以完成大多数文件的编码 
	     * 测定。所以，一般有了这个探测器就可满足大多数项目的要求，如果你还不放心，可以 
	     * 再多加几个探测器，比如下面的ASCIIDetector、UnicodeDetector等。 
	     */  
	    detector.add(JChardetFacade.getInstance());// 用到antlr.jar、chardet.jar  
	    // ASCIIDetector用于ASCII编码测定  
	    detector.add(ASCIIDetector.getInstance());  
	    // UnicodeDetector用于Unicode家族编码的测定  
	    detector.add(UnicodeDetector.getInstance());  
	    java.nio.charset.Charset charset = null;  
	    File f = new File(path);  
	    try {  
	        charset = detector.detectCodepage(f.toURI().toURL());  
	    } catch (Exception ex) {  
	        ex.printStackTrace();  
	    }  
	    if (charset != null)  
	        return charset.name();  
	    else  
	        return null;  
	}  
}
