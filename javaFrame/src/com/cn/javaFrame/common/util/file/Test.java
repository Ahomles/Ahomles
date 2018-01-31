package com.cn.javaFrame.common.util.file;

public class Test {
	public static void main(String[] args) {
		System.out.println(FileUtil.projectPah()+"1.txt");
//		FileUtil.createFile(FileUtil.projectPah()+"1.txt");
//		FileUtil.deleteFile(FileUtil.projectPah()+"1.txt");
		FileUtil.readDirFile("C:\\workspace\\rescenter_trunk\\lib");
		
	}
}
