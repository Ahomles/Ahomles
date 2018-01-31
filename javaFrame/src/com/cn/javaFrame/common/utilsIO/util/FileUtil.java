package com.cn.javaFrame.common.utilsIO.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FileUtil {
	private String lineSeparator = System.getProperty("line.separator");

	
	public static String projectPah() {
		String path = System.getProperty("user.dir") + File.separator + "src"
				+ File.separator + "test" + File.separator + "java"
				+ File.separator + "com" + File.separator + "asiainfo"
				+ File.separator + "crm" + File.separator;
		return path;
	}
	public static String logPah() throws IOException {
		String path = System.getProperty("user.dir");
//		int index=path.lastIndexOf(File.separator);
//		path=path.substring(0,index) + File.separator+"log.txt";
		path=path+File.separator+"log.txt";
//		FileUtil.writeFileContent(path, path);
		return path;
	}
	public static void main(String[] args) {
//		System.out.println(logPah());
	}

	public static File createFile(String path) {
		File file = new File(path);
		try {
			if (!file.exists()) {
				file.createNewFile();
				System.out.println("new file,this filePath is: " + path);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file;
	}

	public static boolean deleteFile(String path) {
		Boolean bool = false;
		File file = new File(path);
		try {
			if (file.exists()) {
				file.delete();
				bool = true;
				System.out.println("delete file,this filePath is: " + path);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bool;
	}

	public static boolean createDir(String path) {
		Boolean bool = false;
		File file = new File(path);
		try {
			if (!file.exists()) {
				file.mkdirs();
				bool = true;
				System.out.println("new dir,this dirPath is: " + path);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bool;
	}

	public static boolean deleteDir(String path) {
		Boolean bool = false;
		File file = new File(path);
		return deleteDirs(file);
	}

	/**
	 * 删除目录下的�?��文件,遍历文件删除
	 * 
	 * @param dir
	 * @return
	 */
	private static boolean deleteDirs(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDirs(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		}
		System.out.println(dir);
		// 目录此时为空，可以删�?
		return dir.delete();
	}

	/**
	 * 向文件中写如内容
	 * 
	 * @param filepath
	 *            文件路径
	 * @param newstr
	 *            内容字符�?
	 * @return
	 * @throws IOException
	 */
	public static boolean writeFileContent(String filepath, String newstr)
			throws IOException {
		Boolean bool = false;
		String filein = newstr + "\r\n";// 新写入的行，换行
		String temp = "";

		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		FileOutputStream fos = null;
		PrintWriter pw = null;
		try {
//			File file = new File(filepath);// 文件路径(包括文件名称)
			File file =createFile(filepath); 
			// 将文件读入输入流
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			StringBuffer buffer = new StringBuffer();

			// 文件原有内容
			for (int i = 0; (temp = br.readLine()) != null; i++) {
				buffer.append(temp);
				// 行与行之间的分隔�?相当于�?\n�?
				buffer = buffer.append(System.getProperty("line.separator"));
			}
			buffer.append(filein);

			fos = new FileOutputStream(file);
			pw = new PrintWriter(fos);
			pw.write(buffer.toString().toCharArray());
			pw.flush();
			bool = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// 不要忘记关闭
			if (pw != null) {
				pw.close();
			}
			if (fos != null) {
				fos.close();
			}
			if (br != null) {
				br.close();
			}
			if (isr != null) {
				isr.close();
			}
			if (fis != null) {
				fis.close();
			}
		}
		return bool;
	}

	/**
	 * 读取文件
	 * 
	 * @param path
	 * @return
	 */
	public static StringBuffer readFile(String path) {
		StringBuffer sb = new StringBuffer();
		File myFile = new File(path);
		if (!myFile.exists()) {
			System.err.println("Can't Find " + path);
		}
		try {
			BufferedReader in = new BufferedReader(new FileReader(myFile));
			String str;
			while ((str = in.readLine()) != null) {
				sb.append(str).append("\n");
			}
			in.close();
		} catch (IOException e) {
			e.getStackTrace();
		}
		return sb;
	}

	public static boolean moveCopyFile(String srcPath, String destPath) {
		Boolean bool = false;
		try {
			int bytesum = 0;
			int byteread = 0;
			File oldfile = new File(srcPath);
			if (oldfile.exists()) {
				InputStream inStream = new FileInputStream(srcPath);
				FileOutputStream fs = new FileOutputStream(destPath);
				byte[] buffer = new byte[1444];
				int length;
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread;
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
			}
		} catch (Exception e) {
			System.out.println("error  ");
			e.printStackTrace();
		}
		return bool;
	}

	/**
	 * 读取某个目录下的�?��文件
	 * 
	 * @param dirpath
	 * @return
	 */
	public static boolean readDirFile(String dirpath) {
		Boolean bool = false;
		File file = new File(dirpath);
		File[] tempList = file.listFiles();
		for (int i = 0; i < tempList.length; i++) {
			if (tempList[i].isFile()) {
				String filePath = tempList[i].getPath();
				int tem = filePath.indexOf("com");
				filePath = filePath.substring(tem);
				System.out.println(filePath.replace("\\", "/"));
			}
		}
		return bool;
	}
}