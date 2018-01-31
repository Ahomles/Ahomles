package com.cn.javaFrame.demo.demo02.afactory;

import java.util.HashMap;

public final class ServiceFactory {
//    private static transient Log log;
    private static HashMap SERVICES_DEFINE;
    private static HashMap DAOS_DEFINE;
    static{
    	SERVICES_DEFINE=new HashMap();
    	DAOS_DEFINE=new HashMap();
    	//初始化配置文件，获取配置文件的服务
    	
    }
	
	private ServiceFactory()
	{
	}
	
	public Object getService(String classname){
		
		return null;
	}
	
	public void getDaoObject(Class interfaceClass, Class implClass){
		//为每个dao层加上数据源
//		  ProxyInvocationHandler handler = new ProxyInvocationHandler(rtn, new Class[] {
//            com/ai/appframe2/complex/service/proxy/impl/DAODataSourceInterceptorImpl
//        });
//        rtn = ProxyUtil.getProxyObject(interfaceClass.getClassLoader(), new Class[] {
//            interfaceClass
//        }, handler);
	}
	
	
	public void getSVObject(Class interfaceClass, Class implClass){
		//为每个SV层添加事务和监控和数据源
//		 Class clazz[] = null;
//         if(!isCross)
//             clazz = (new Class[] {
//                 com/ai/appframe2/complex/service/proxy/impl/MethodMonitorInterceptorImpl, com/ai/appframe2/complex/service/proxy/impl/TransactionInterceptorImpl, com/ai/appframe2/complex/service/proxy/impl/TransactionDataSourceInterceptorImpl
//             });
//         else
//             clazz = (new Class[] {
//                 com/ai/appframe2/complex/service/proxy/impl/MethodMonitorInterceptorImpl, com/ai/appframe2/complex/service/proxy/impl/TransactionInterceptorImpl, com/ai/appframe2/complex/service/proxy/impl/TransactionDataSourceInterceptorImpl
//             });
//         ProxyInvocationHandler handler = new ProxyInvocationHandler(rtn, clazz);
//         rtn = ProxyUtil.getProxyObject(implClass.getClassLoader(), new Class[] {
//             interfaceClass
//         }, handler);
	}
}
