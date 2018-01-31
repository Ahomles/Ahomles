package com.cn.javaFrame.common.util.regex.test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassParseRegexUtil {
	public static final String CENTERTXT="IResActionCSV";
	public static final StringBuffer str = FileUtil.readFile(FileUtil.path()
			+ "IClientActionSV.java");
	public static final boolean flag=false;
	
	public static void main(String[] args) throws Exception{
		List<String> list=new ArrayList<String>();
//		list.add("getResNumBatSuccByOriginPhoneCounts");
//		list.add("selResNumBatSuccByOriginPhone");
		list.add("selFromPhoneUsedSegmentCounts");
				
		
		//ClientActionSVImpl根据接口对实现类代码合成的一个工具类
		for(int i=0;i<list.size();i++){
			System.out.println("	@Override");
			printContent(list.get(i));
			System.out.println();
		}
		
		
		String str1=getMethodRtnType(str.toString(),"selFromPhoneUsedSegmentCounts");
		System.out.println(str1);
		
//		printMethods();//获接口类的所有方法名字，并打印控制台

	}
	
	//获接口类的所有方法名字，并打印控制台
	public static void printMethods() throws Exception{
		List listr=findMethods(str.toString());
		for(int k=0;k<listr.size();k++){
			System.out.println(listr.get(k));
		}
	}
	
	//打印字符串数组内容
	public static void printStr(String str[]){
		for(int i=0;i<str.length;i++){
			System.out.print(str[i]+" ");
		}
		System.out.println();
	}
	
	public static void getParams1(String methodParamStr){
		List list=new ArrayList();
		String[] str1 = methodParamStr.split(",");
		for(int i=0;i<str1.length;i++){
			String[] str2=(str1[i].trim()).split("\\s+");
			printStr(str2);
		}
	}
	
	
	public static String printContentError(String method) throws Exception{
		String methodParamStr = findMethodParamsStr(str.toString(), method);
		return methodParamStr;
	}
	
	
	
	public static void printContent(String method) throws Exception{
		String rtnType=getMethodRtnType(str.toString(),method);//获取该方法的返回类型
		String methodParamStr = findMethodParamsStr(str.toString(), method);
		if("".equals(methodParamStr)||methodParamStr.length()==0||null==methodParamStr){
			throw new Exception(method+"方法未找到！");

		}
		String methodParamStr1 = findMethod(str.toString(), method);//添加方法头
		StringBuffer sb=new StringBuffer();
		sb.append("	").append(methodParamStr1).append("{").append("\n");//添加方法头
		sb.append("		Utils u = new Utils(\"res_"+CENTERTXT+"_").append(method).append("\");").append("\n");
		sb.append("		Map<String, Object> busiParam = new HashMap<String, Object>();").append("\n");
		if(flag){
			System.out.println(methodParamStr);//测试
		}
		String[] str1 = methodParamStr.split(",");
		for(int i=0;i<str1.length;i++){
			String[] str2=(str1[i].trim()).split("\\s+");
			String paramName=str2[1];
			if(judgeType(str2[0])){
				sb.append("		busiParam.put(\"").append(paramName.toUpperCase()).append("\", ").append(paramName).append(");\n");
			}else{
				sb.append("		busiParam.put(\"").append(paramName.toUpperCase()).append("\", Utils.obj2JSon(").append(paramName).append("));\n");
			}
		}
		sb.append("		return u.serviceByServFrame(busiParam, "+rtnType+".class);");
		sb.append("\n	}");//添加方法尾部
		System.out.println(sb.toString());
	}
	
	
	//不是这三种基本类型的都要转化成json字符串
	public static boolean judgeType(String type){
		if("int".equals(type)||"Integer".equals(type)){
			return true;
		}
		if("long".equals(type)||"Long".equals(type)){
			return true;
		}
		if("String".equals(type)){
			return true;
		}
		return false;
	}
	
	
	
	//得到每个参数的变量名
	//methodParamStr
	public static List getParams(String methodParamStr){
		List list=new ArrayList();
		String[] str1 = methodParamStr.split(",");
		for(int i=0;i<str1.length;i++){
			String[] str2=(str1[i].trim()).split("\\s+");
			list.add(str2[1]);
		}
		return list;
	}

	//解析方法内容
	// "(?<=findMethodParamsStr\()[\w\s,]{0,1000}"
	//String strContent,String methodName
	public static String findMethodParamsStr(String strContent,
			String methodName) throws Exception {
		String rtnStr = "";
		String regx = "(?<=" + methodName + "\\()[\\w\\s,\\[\\]]{0,1000}";
		Pattern p = Pattern.compile(regx);
		Matcher m = p.matcher(strContent);
		if (m.groupCount() > 1) {
			throw new Exception(methodName+"匹配到多个！");
		}
		int count=0;
		while (m.find()) {
			rtnStr = m.group();
			count++;
		}
		if (count > 1) {
			throw new Exception(methodName+"匹配到多个！");
		}
		return rtnStr;
	}
	//解析方法头
	//p[\w\[\]\s]+updateApply[\w\s,\[\]()]+(?=;)
	//public String findMethod(String strContent,String methodName) throws Exception
	public static String findMethod(String strContent,
			String methodName) throws Exception{
		String rtnStr = "";
		String regx = "p[\\w\\[\\]\\s]+" + methodName + "\\([\\w\\s,\\[\\]\\(\\),.]+(?=;)";

		Pattern p = Pattern.compile(regx);
		Matcher m = p.matcher(strContent);
		if (m.groupCount() > 1) {
			throw new Exception(methodName+"匹配到多个！");
		}
		int count=0;
		while (m.find()) {
			rtnStr = m.group();
			count++;
		}
		if (count > 1) {
			throw new Exception(methodName+"匹配到多个！");
		}
		return rtnStr;
	}
	
	//解析类中的每一个方法名：findMethods
	//(?<=public\s)[\s\w]{1,50}(?=\()
	//findMethods
	public static List findMethods(String strContent) throws Exception{
		List<String> methods=new ArrayList<String>();
		int count=0;
		
		String rtnStr = "";
		String regx = "(?<=public\\s)[\\s\\w\\[\\]]{1,50}(?=\\()";
		Pattern p = Pattern.compile(regx);
		Matcher m = p.matcher(strContent);
		while (m.find()) {
			rtnStr = m.group();
			count++;
			String[] str2=rtnStr.trim().split("\\s+");
			methods.add(str2[1]);
		}
		System.out.println("匹配的方法总数："+count);
		return methods;
	}
	
	//(?<=public\s)[\w\[\]]+(?=\sgetMethodRtnType)
	//String
	public static String getMethodRtnType(String strContent,String methodName) throws Exception{
		String rtnStr = "";
		String regx = "(?<=public\\s)[\\w\\[\\]]+(?=\\s"+methodName+"\\()";
		Pattern p = Pattern.compile(regx);
		Matcher m = p.matcher(strContent);
		int count=0;
		while (m.find()) {
			rtnStr = m.group();
			count++;
		}
		if (count > 1) {
			throw new Exception(methodName+"匹配到多个！");
		}
		return rtnStr;
	}
}
