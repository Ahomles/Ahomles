package com.cn.javaFrame.common.util.regex.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
	private String lineSeparator = System.getProperty("line.separator");

	public static String path() {
		String path = System.getProperty("user.dir") + File.separator + "src"
//				+ File.separator + "test" + File.separator + "java"
				+ File.separator + "com" + File.separator + "cn"
				+ File.separator + "javaFrame" + File.separator
				+ File.separator + "common" + File.separator
				+ File.separator + "util" + File.separator
				+ File.separator + "regex" + File.separator
				+ File.separator + "test" + File.separator;
		return path;
	}

	public static List getFiles(String dirpath) {
		List<String> filelist = new ArrayList<String>();
		File root = new File(dirpath);
		File[] files = root.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				List<String> filelistSon=getFiles(file.getAbsolutePath());//递归
				if(null!=filelistSon&&filelistSon.size()>0)
					filelist.addAll(filelistSon);
			} else {
				filelist.add(file.getAbsolutePath());
			}
		}
		return filelist;
	}
	public static List getDirs(String dirpath) {
		List<String> dirlist = new ArrayList<String>();
		File root = new File(dirpath);
		File[] files = root.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				List<String> dirlistSon=getFiles(file.getAbsolutePath());//递归
				if(null!=dirlistSon&&dirlistSon.size()>0)
					dirlist.addAll(dirlistSon);
				dirlist.add(file.getAbsolutePath());
			}
		}
		return dirlist;
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
	 * 删除目录下的所有文件,遍历文件删除
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
		// 目录此时为空，可以删除
		return dir.delete();
	}

	/**
	 * 向文件中写如内容
	 * 
	 * @param filepath
	 *            文件路径
	 * @param newstr
	 *            内容字符串
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
			File file = new File(filepath);// 文件路径(包括文件名称)
			// 将文件读入输入流
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			StringBuffer buffer = new StringBuffer();

			// 文件原有内容
			for (int i = 0; (temp = br.readLine()) != null; i++) {
				buffer.append(temp);
				// 行与行之间的分隔符 相当于“\n”
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
	 * 读取某个目录下的所有文件
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

	/**
	 * 拷贝文件的同时修改第一行数据 flag = false：修改，true：添加
	 * 
	 * @param srcPath
	 * @param destPath
	 * @param firstLine
	 * @param flag
	 * @return
	 * @throws IOException
	 */
	public static boolean moveCopyFile(String srcPath, String destPath,
			String firstLine, boolean flag) {
		Boolean bool = false;
		File oldfile = new File(srcPath);
		if (oldfile.exists()) {
			File newfile = createFile(destPath);// 创建目标文件
			BufferedReader in = null;
			BufferedWriter out = null;
			try {
				in = new BufferedReader(new FileReader(oldfile));
				out = new BufferedWriter(new FileWriter(newfile));
				String str;
				str = in.readLine();
				if (str != null) {
					out.write(firstLine);
					out.newLine();// 换行
					if (flag) {
						out.write(str);
						out.newLine();// 换行
					}
				}
				if (srcPath.contains("Bean")) {
					while ((str = in.readLine()) != null) {
						if (str.contains(getBoName(srcPath, firstLine))) {
							out.write(getBoPath(srcPath, firstLine));
							out.newLine();// 换行
						} else {
							out.write(str);
							out.newLine();// 换行
						}
					}
				} else {
					while ((str = in.readLine()) != null) {
						out.write(str);
						out.newLine();// 换行
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					out.close();
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return bool;
	}

	private static String getBoPath(String srcPath, String firstLine) {
		String boTemp = srcPath.substring(0, srcPath.lastIndexOf("."));
		boTemp = boTemp.substring(srcPath.lastIndexOf("\\"));
		boTemp = boTemp.substring(1, boTemp.indexOf("Bean"));
		String boPath = firstLine.substring(8, firstLine.length() - 1) + "."
				+ boTemp;
		boPath = "\t" + "private static String  m_boName = \"" + boPath + "\""
				+ ";";
		System.out.println(boPath);
		return boPath;
	}

	private static String getBoName(String srcPath, String firstLine) {
		String boTemp = srcPath.substring(0, srcPath.lastIndexOf("."));
		boTemp = boTemp.substring(srcPath.lastIndexOf("\\"));
		boTemp = "bo." + boTemp.substring(1, boTemp.indexOf("Bean"));
		return boTemp;
	}

}
