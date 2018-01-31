package com.cn.javaFrame.common.utilsIO.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;


public class Server {
	public interface ObjectAction {
		Object doAction(Object rev);
	}

	public static final class DefaultObjectAction implements ObjectAction {

		@Override
		public Object doAction(Object rev) {
			System.out.println("处理并返回："+rev);
			return rev;
		}

	}
	private int port;
	private boolean running = false;
    private long receiveTimeDelay=3000;  
    private Thread connWatchDog;
    private ConcurrentHashMap<Class, ObjectAction> actionMapping = new ConcurrentHashMap<Class,ObjectAction>();  

	public Server(int port) {
		this.port=port;
	}
	
	public void start(){
		if(running) return;
		running = true;
        connWatchDog = new Thread(new ConnWatchDog());  
        connWatchDog.start();
	}
	
	
	class ConnWatchDog implements Runnable{
		@Override
		public void run() {
			try {
				ServerSocket server=new ServerSocket();
				while(running){
					Socket socket=server.accept();
					new Thread(new SocketAction(socket)).start();
					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		



	}

	 class SocketAction implements Runnable{
			Socket s;
		    boolean run=true;  
	        long lastReceiveTime = System.currentTimeMillis();  

	        public SocketAction(Socket s) {
	        	this.s=s;
			}
	        
			public void run() {
				while(running && run){
					if(System.currentTimeMillis()-lastReceiveTime>receiveTimeDelay){  
						overThis();  
					}else{
						try {
							InputStream in=s.getInputStream();
							if(in.available()>0){
								ObjectInputStream ois=new ObjectInputStream(in);
								Object obj=ois.readObject();
	                            lastReceiveTime = System.currentTimeMillis();  
	                            System.out.println("接收：\t"+obj);  
	                            ObjectAction oa = actionMapping.get(obj.getClass());  
	                            oa = oa==null?new DefaultObjectAction():oa;  
	                            Object out = oa.doAction(obj);  
	                            if(out!=null){  
	                                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());  
	                                oos.writeObject(out);  
	                                oos.flush();  
	                            }  
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				}
				
			};
			private void overThis() {  
	            if(run)run=false;  
	            if(s!=null){  
	                try {  
	                    s.close();  
	                } catch (IOException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	            System.out.println("关闭："+s.getRemoteSocketAddress());  
	        }
			
		}
	 
}
