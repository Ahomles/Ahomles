package com.cn.javaFrame.common.util.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MoveBo {
	public static final String[] boDir = { "bo", "dao",
			"dao" + File.separator + "interfaces",
			"dao" + File.separator + "impl", "ivalues", "service",
			"service" + File.separator + "interfaces",
			"service" + File.separator + "impl" };

	public static void main(String[] args) {
	
		String srcPath="D:\\develop\\aGit\\project\\project01\\javaFrame\\src\\com\\cn\\javaFrame\\common\\test\\dirPath";
		String destPath="D:\\project\\gzzxProject\\devProject\\rule_center\\src\\main\\java\\com\\asiainfo\\crm\\uip\\common";
		String value="IBOBsCmBusiTypeRuleDtlValue";
		/**
		 * srcPath==》
		   D:\develop\aGit\project\project01\javaFrame\src\com\cn\javaFrame\common\test\srcPath
		   descPath===>
		   D:\develop\aGit\project\project01\javaFrame\src\com\cn\javaFrame\common\test\dirPath
		   IBOQryMDBProxyLogValue
		 */
//		getBoPath(destPath,fistLine(destPath));
		moveBoDirFile(srcPath,destPath,value);
//		FileUtil.deleteDir(destPath);
	}
	public static String choosePath(String path,String fileName){
		String beanPath="";
		String enginePath="";
		
		String rtnPath="";
		if(fileName.contains("Bean.java")){
			rtnPath=beanPath+File.separator+fileName;
		}else if(fileName.contains("Engine.java")){
			rtnPath=enginePath+File.separator+fileName;
		}
		
		return "";
	}
	
	public static String projectPah() {
		String path = System.getProperty("user.dir") + File.separator + "src"
				+ File.separator + "com" + File.separator + "cn"
				+ File.separator + "javaFrame" + File.separator + "common"
				+ File.separator + "test" + File.separator + "srcPath";
		return path;
	}
	public static String projectDestPah() {
		String path = System.getProperty("user.dir") + File.separator + "src"
				+ File.separator + "com" + File.separator + "cn"
				+ File.separator + "javaFrame" + File.separator + "common"
				+ File.separator + "test" + File.separator + "dirPath";
		return path;
	}

	public static boolean moveBoDirFile(String srcDirPath, String destDirPath,
			String value) {
		createBoDir(destDirPath);//创建相关目录
		String srcPath = "";
		String destPath = "";
		for (int i = 0; i < boDir.length; i++) {
			List<String> temPath=parseValue(boDir[i],value);
			if(temPath.size()>0&&temPath!=null){
				for(int j=0;j<temPath.size();j++){
					srcPath = srcDirPath + File.separator + temPath.get(j);
					destPath = choosePath(destPath,temPath.get(j));
					
					System.out.println(srcPath+"\n"+"===>"+"\n"+destPath);
//					FileUtil.moveCopyFile(srcPath, destPath);
					String firstLine = fistLine(destPath);
					FileUtil.moveCopyFile(srcPath, destPath,firstLine,true);
				}
			}
		}
		return true;
	}
	public static String  fistLine(String destPath){
		String firstLine="package ";
		int first=destPath.indexOf("com");
		int end=destPath.lastIndexOf("\\");
		destPath=destPath.substring(first,end);
		destPath=destPath.replace("\\", ".");
		firstLine+=destPath+";";
		System.out.println(firstLine);
		return firstLine;
	}
	
	public static List<String> parseValue(String path, String value) {
		List<String> desPath = new ArrayList<String>();
		int end = value.indexOf("Value");
		String tempValue = value.substring(1, end);
		if (path.contains("bo")) {
			String tempValue1 = path + File.separator + tempValue + "Bean.java";
			String tempValue2 = path + File.separator + tempValue
					+ "Engine.java";
			desPath.add(tempValue1);
			desPath.add(tempValue2);
		} else if (path.contains("ivalues")) {
			String tempValue1 = path +File.separator + value+".java";
			desPath.add(tempValue1);
		}
		return desPath;
	}

	/**
	 * 创建Bo相关的目录文件
	 * 
	 * @param path
	 * @return
	 */
	public static boolean createBoDir(String path) {
		String dirPath = "";
		for (int i = 0; i < boDir.length; i++) {
			dirPath = path + File.separator + boDir[i];
			FileUtil.createDir(dirPath);
		}
		return true;
	}
}