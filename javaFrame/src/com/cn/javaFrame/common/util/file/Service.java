package com.cn.javaFrame.common.util.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * 探测文件的编码格式
 * @author zhunb3
 *
 */
public class Service {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		readDirFile("D:/project/res/resCenter/src/main/resources/com/asiainfo/boss/rescenter/rescfg/web");
	}
	
	public static boolean readDirFile(String dirpath) throws FileNotFoundException, IOException {
		Boolean bool = false;
		File file = new File(dirpath);
		File[] tempList = file.listFiles();
		for (int i = 0; i < tempList.length; i++) {
			if (tempList[i].isFile()) {
				String filePath = tempList[i].getPath();
				File file3 = new File(filePath);
				String strEncode=new EncodeFileCheck().guessFileEncoding(file3);
				if(strEncode.contains("UTF-8")){
					System.out.println(filePath.replace("\\", "/"));
					System.out.println("----encode--"+strEncode);
				}
			}else if(tempList[i].isDirectory()){
				readDirFile(tempList[i].getPath());
			}
		}
		return bool;
	}
}
