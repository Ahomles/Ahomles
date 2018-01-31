package com.cn.javaFrame.common.utilsIO.cn.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import com.cn.javaFrame.common.utilsIO.cn.pojo.Request;
import com.cn.javaFrame.common.utilsIO.cn.pojo.Response;

public class Receive {
	public static final String WEB_ROOT =
		    System.getProperty("user.dir") + File.separator  + "webroot";
	private boolean shutdown=true;
	
	public void await() throws InterruptedException{
	
		ServerSocket serverSocket = null;
		
		int port=8080;
		try {
			serverSocket =  new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
			System.out.println("启动成功！");//启动成功！
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		while(shutdown){
			Socket socket=null;
			InputStream in=null;
			OutputStream out=null;
			try{
				socket=serverSocket.accept();
				in = socket.getInputStream();
				out = socket.getOutputStream();
				
				Request request=new Request(in);
				request.parse();
				
				Response response=new Response(out);
				response.setRequest(request);
				response.sendStaticResource();
				
				socket.close();
			}catch (Exception e) {
				e.printStackTrace();
				Thread.sleep(300l);
				continue;
			}
		}	
	}
}
