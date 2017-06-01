package com.cn.javaFrame.common.util.dataConvert.proxy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Copyright: Copyright (c) 2014 Asiainfo *
 * 
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: yangqx3
 * @date: 2014/06/16 19:40
 *        <p/>
 *        Modification History: Date Author Version Description
 *        ------------------------------------------------------------
 *        2014/06/16 yangqx3 v1.0.0 修改原因
 */
public class LogInvocationHandler implements InvocationHandler {
	private static final Log log = LogFactory
			.getLog(LogInvocationHandler.class);
	private Object targetObject;
	static Set primitiveMap = new HashSet();

	static {
		primitiveMap.add(Byte.class);
		primitiveMap.add(Short.class);
		primitiveMap.add(Integer.class);
		primitiveMap.add(Long.class);
		primitiveMap.add(Float.class);
		primitiveMap.add(Double.class);
		primitiveMap.add(Character.class);
		primitiveMap.add(Boolean.class);
	}

	public LogInvocationHandler(Object targetObject) {
		this.targetObject = targetObject;
	}

	public Object createProxyObject() {
		Object proxyObject = Proxy.newProxyInstance(this.targetObject
				.getClass().getClassLoader(), this.targetObject.getClass()
				.getInterfaces(), this);
		return proxyObject;
	}

	/*
	 * proxyObject:代理对象 method: 被拦截到的目标对象的method args: 被拦截到的目标对象的method的参数
	 */
	public Object invoke(Object proxyObject, Method method, Object[] args)
			throws Throwable {
		Object result = null;
		Timestamp opStartDate = new Timestamp(System.currentTimeMillis());
		try {
//			if (RuleTraceManager.isTrace())
//				RuleTraceManager.getTrace().startMethod(method.getName(), args);
			long startTime = System.currentTimeMillis();
			result = method.invoke(this.targetObject, args);
//			RuleTraceManager
//					.getTrace()
//					.log("@@结束反射RuleSVImpl[" + method.getName() + "],总耗时:["
//							+ (System.currentTimeMillis() - startTime) + "] ms");
//			if (RuleTraceManager.isTrace())
//				RuleTraceManager.getTrace()
//						.finishMethod(method.getName(), true);
			recordLog(args, method, result, opStartDate, null);
//			RuleCtxManager.clearGlobeCtxParam();
//			RuleTraceManager.cleanTrace();
		} catch (Exception e) {
//			if (log.isErrorEnabled()) {
//				if (RuleTraceManager.isTrace()) {
//					log.error(RuleTraceManager.getTrace().getTrace());
//				}
//			}
			recordLog(args, method, result, opStartDate, e);
//			RuleTraceManager.cleanTrace();
			throw e;
		}
		return result;
	}

	private void recordLog(Object[] args, Method method, Object result,
			Timestamp opStartDate, Exception e) {
		long startTime = System.currentTimeMillis();
		String inLogXml = "";
		String outLogXml = "";
		String outLogXmlForDb = "";
		String serviceKey = getServiceFlag(method, args, "KEY");
		String serviceType = getServiceFlag(method, args, "TYPE");
		String returnResult = "";
		String returnDesc = "";
		String errorMsg = "";
		try {
			if (args.length > 0 && args[0] instanceof Map) {
				Map busiParamsMap = (Map) args[0];
				Map newBusiParamsMap = getCompleteInMap(busiParamsMap,
						serviceKey);
				// 使用return_desc字段记录手机号码
//				returnDesc = (String) busiParamsMap.get(RuleConst.Node.BILL_ID);
//				inLogXml = RuleUtils.getXmlFromMap(newBusiParamsMap, 0);
			} else {
				inLogXml = object2Xml(args);
			}
			if (result != null) {
				if (result instanceof Map) {
					// 校验成功的记录抛弃
					Map resultMap = (Map) result;
//					outLogXmlForDb = RuleUtils.getXmlFromMap(resultMap, 1,
//							new Object[] { RuleConst.Node.SUCCESSLIST,
//									RuleConst.Node.SUCCESSINFO });
//					outLogXml = RuleUtils.getXmlFromMap(resultMap, 1);
//					returnResult = String.valueOf(resultMap
//							.get(RuleConst.Node.RESULT_CODE));
//					// 记录中文描述
//					errorMsg = String.valueOf(resultMap
//							.get(RuleConst.Node.RESULT_DESC));
				} else {
					outLogXml = object2Xml(result);
				}
			}

			StringBuffer sout = new StringBuffer();
			if (e != null) {
				sout.setLength(0);
//				returnResult = RuleConst.RULE_RTN_CODE.SYS_EROR;
				if (e instanceof InvocationTargetException) {
					errorMsg = getExceptionMsg(((InvocationTargetException) e)
							.getTargetException());
				} else {
					errorMsg = getExceptionMsg(e);
				}
				String lineSpt = System.getProperty("line.separator");
				errorMsg = errorMsg.replaceAll(lineSpt + "\\t", "~")
						.replaceAll(lineSpt, "~").replaceAll("\\r", "~");
				sout.append(errorMsg);
				errorMsg = "系统异常！";
//				ServiceLogDealCenter.serviceOpLog(serviceKey, serviceType,
//						returnResult, returnDesc, errorMsg, opStartDate,
//						inLogXml, sout.toString());
				return;
			}
			if (!"0".equals(returnResult)) {
				// 只记录失败时日志
				sout.append(outLogXmlForDb);
			}
			// 记录性能日志
//			sout.append("性能日志:").append(RuleTraceManager.getTrace().getTrace());
//			ServiceLogDealCenter.serviceOpLog(serviceKey, serviceType,
//					returnResult, returnDesc, errorMsg, opStartDate, inLogXml,
//					sout.toString());
		} catch (Exception e1) {
			log.error(LogInvocationHandler.class, e1);
		} finally {
//			new LogThread(inLogXml, outLogXml, RuleTraceManager.getTrace()
//					.getTrace()).start();
			// if (log.isErrorEnabled())
			// log.error(RuleUtils.getStringNoBlank("输入报文:" +inLogXml +"@@输出报文:"
			// +outLogXml
			// +"@@性能日志:" +RuleTraceManager.getTrace().getTrace()));
			log.info("结束记录日志总耗时:[" + (System.currentTimeMillis() - startTime)
					+ "] ms");
		}
	}

	private Map getCompleteInMap(Map busiParamsMap, String serviceKey) {
		Map rtnMap = new HashMap();
		Map pubInfoMap = new HashMap();
		Map requestMap = new HashMap();
		rtnMap.put("PUBINFO", pubInfoMap);
		rtnMap.put("REQUEST", requestMap);
//		UserInfoInterface user = SessionManager.getUser();
//
//		pubInfoMap.put("OSBSERIALNO", user.get("OSBSERIALNO"));
//		pubInfoMap.put("TRANSACTIONTIME", user.get("TRANSACTIONTIME"));
//		pubInfoMap.put("INTERFACEID", user.get("INTERFACEID"));
//		pubInfoMap.put("INTERFACETYPE", user.get("INTERFACETYPE"));
//		pubInfoMap.put("ACTCHNLTYPE", user.get("ACTCHNLTYPE"));
//		pubInfoMap.put("CHNLTYPE", user.get("CHANNEL_TYPE"));
//		pubInfoMap.put("CLIENTIP", user.get("CLIENTIP"));
//		pubInfoMap.put("SYSOPID", user.get("SYSOPID"));
//		pubInfoMap.put("SYSPWD", user.get("SYSPWD"));
//		pubInfoMap.put("OPID", user.getID());
//		pubInfoMap.put("ORGID", user.get("OP_ORG_ID"));
//		pubInfoMap.put("OPCODE", user.getCode());
//		pubInfoMap.put("REGIONCODE", user.get("REGIONCODE"));
//		pubInfoMap.put("COUNTYCODE", user.get("COUNTY_ID"));

		requestMap.put("BUSICODE", serviceKey);
		requestMap.put("BUSIPARAMS", busiParamsMap);
		return rtnMap;
	}

	public static class LogThread extends Thread {
		String inParam, outParam, otherInfo;

		LogThread(String inParam, String outParam, String otherInfo) {
			this.inParam = inParam;
			this.outParam = outParam;
			this.otherInfo = otherInfo;
			if (null != otherInfo) {
				String[] msg = otherInfo.split("@@");
				if (msg.length > 1) {
					this.otherInfo = msg[1];
				}
			}
		}

		public void run() {
//			if (log.isErrorEnabled()) {
//				log.error(RuleUtils.getStringNoBlank("输入报文:" + inParam
//						+ "@@输出报文:" + outParam + "@@性能日志:" + otherInfo));
//			}
		}
	}

	public static String getExceptionMsg(Throwable e) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);
		String msg = baos.toString();
		return msg;
	}

	private String getServiceFlag(Method method, Object[] args, String type) {
		String methodName = method.getName();
		if ("executeRuleCheck".equals(methodName)) {
			if ("KEY".equals(type)) {
				return "ESB_BASE_RULE_BUSIRULE_CHK_001";
			} else {
				return "1";
			}
		} else if ("preCheckBusiOper".equals(methodName)) {
			if ("KEY".equals(type)) {
				return "ESB_BASE_RULE_BUSIRULE_CHK_002";
			} else {
				return "2";
			}
		} else if ("submitRuleCheck".equals(methodName)) {
			if ("KEY".equals(type)) {
				return "ESB_BASE_RULE_BUSISUBMIT_ISCANDO_001";
			} else {
				return "3";
			}
		} else if ("queryRuleList4Esb".equals(methodName)) {
			if ("KEY".equals(type)) {
				return "ESB_BASE_RULE_BUSIRULE_QRY_001";
			} else {
				return "4";
			}
		} else {
			if ("KEY".equals(type)) {
				return "ESB_BASE_RULE_001";
			} else {
				return "0";
			}
		}
	}

	private String getServiceType(Object inObj) {
		String serviceType = "";
		if (inObj instanceof Map) {
			Map mapObj = (Map) inObj;
		} else {
			serviceType = inObj.toString();
		}
		return serviceType;
	}

	public static String object2Xml(Object o) {
		StringBuffer sb = new StringBuffer();
		return sb.append("<AICRMSERVICE>").append(valueOf(o))
				.append("</AICRMSERVICE>").toString();
	}

	public static String valueOf(Object o) {
		if (o == null) {
			return "null";
		}
		if (o.getClass().isArray()) {
			StringBuffer sb = new StringBuffer("");
			Object[] t = (Object[]) o;
			for (int i = 0; i < t.length; i++) {
				sb.append("<arrayvalue>");
				sb.append(valueOf(t[i]));
				sb.append("</arrayvalue>");
			}
			return sb.toString();
		}
		if (o instanceof List) {
			StringBuffer sb = new StringBuffer("");
			Iterator itr = ((List) o).iterator();

			while (itr.hasNext()) {
				Object map = (Object) itr.next();
				sb.append("<arrayvalue>");
				sb.append(valueOf(map));
				sb.append("</arrayvalue>");
			}

			return sb.toString();
		}
		if (o instanceof Map) {
//			return RuleUtils.getXmlFromMap((Map) o, 0);
		}
		if (o instanceof String) {
			return o.toString();
		}
		if (o.getClass().isPrimitive() || primitiveMap.contains(o.getClass())) {
			return o.toString();
		} else {
			Field[] fields = o.getClass().getDeclaredFields();
			StringBuffer sb = new StringBuffer();
			for (Field f : fields) {
				f.setAccessible(true);
				Object t = null;
				sb.append("<object>");
				try {
					t = f.get(o);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				sb.append("<").append(f.getName()).append(">")
						.append(valueOf(t)).append("</").append(f.getName())
						.append(">");
			}
			sb.append("</object>");
			return sb.toString();
		}
	}

}
