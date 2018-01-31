package com.cn.javaFrame.common.utilsIO.cn.pojo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.cn.javaFrame.common.utilsIO.cn.service.Receive;


public class Response {
	private final static int BUFFER_SIZE = 1024;
	
	private OutputStream out=null;
	private Request request=null;
	public Response() {

	}
	
	public Response(OutputStream out){
		this.out=out;
	}
	
	public void setRequest(Request request){
		this.request=request;
	}
	
	public void sendStaticResource() throws Exception{
		byte[] buffer = new byte[BUFFER_SIZE];
		FileInputStream fis=null;
		File file = new File(Receive.WEB_ROOT, request.getUri());
		try {
			if (file.exists()) {
				fis = new FileInputStream(file);
				int ch = fis.read(buffer, 0, BUFFER_SIZE);
				if (-1 != ch) {
					out.write(buffer, 0, ch);
					ch = fis.read(buffer, 0, BUFFER_SIZE);
				} else {
					// file not found
					String errorMessage = "HTTP/1.1 404 File Not Found\r\n"
							+ "Content-Type: text/html\r\n"
							+ "Content-Length: 23\r\n" + "\r\n"
							+ "<h1>File Not Found</h1>";
					out.write(errorMessage.getBytes());
				}
			}
		} catch (Exception e) {
			// thrown if cannot instantiate a File object
			System.out.println(e.toString());
		} finally {
			if (fis != null)
				fis.close();
		}
	}
	
	
	
}
