package com.cn.javaFrame.common.util.dataConvert.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.common.esb.Constant;

/**
 * 增强版的Map
 * @author zhunb3
 *
 */
public class ServiceParam extends HashMap{
    public ServiceParam()
    {
    }

    public ServiceParam(String returnCode, String returnMsg)
    {
        put(ParamKey.RETURN_CODE, returnCode);
        put(ParamKey.RETURN_MESSAGE, returnMsg);
    }

    public String getTransactionId()
    {
        return get(ParamKey.TRANSACTION_ID) != null ? get(ParamKey.TRANSACTION_ID).toString() : "";
    }

    public void setTransactionId(String transactionId)
    {
        put(ParamKey.TRANSACTION_ID, transactionId);
    }

    public String getTransactionTime()
    {
        return get(ParamKey.TRANSACTION_TIME) != null ? get(ParamKey.TRANSACTION_TIME).toString() : "";
    }

    public void setTransactionTime(String transactionTime)
    {
        put(ParamKey.TRANSACTION_TIME, transactionTime);
    }

    public String getInterfaceId()
    {
        return get(ParamKey.INTERFACE_ID) != null ? get(ParamKey.INTERFACE_ID).toString() : "";
    }

    public void setInterfaceId(String interfaceId)
    {
        put(ParamKey.INTERFACE_ID, interfaceId);
    }

    public String getInterfaceType()
    {
        return get(ParamKey.INTERFACE_TYPE) != null ? get(ParamKey.INTERFACE_TYPE).toString() : "";
    }

    public void setInterfaceType(String interfaceType)
    {
        put(ParamKey.INTERFACE_TYPE, interfaceType);
    }

    public String getOperId()
    {
        return get(ParamKey.OPER_ID) != null ? get(ParamKey.OPER_ID).toString() : "";
    }

    public void setOperId(String operId)
    {
        put(ParamKey.OPER_ID, operId);
    }

    public String getOrgId()
    {
        return get(ParamKey.ORG_ID) != null ? get(ParamKey.ORG_ID).toString() : "";
    }

    public void setOrgId(String orgId)
    {
        put(ParamKey.ORG_ID, orgId);
    }

    public String getRegionCode()
    {
        return get(ParamKey.REGION_CODE) != null ? get(ParamKey.REGION_CODE).toString() : "";
    }

    public void setRegionCode(String regionCode)
    {
        put(ParamKey.REGION_CODE, regionCode);
    }

    public String getCountyCode()
    {
        return get(ParamKey.COUNTY_CODE) != null ? get(ParamKey.COUNTY_CODE).toString() : "";
    }

    public void setCountyCode(String countyCode)
    {
        put(ParamKey.COUNTY_CODE, countyCode);
    }

    public String getReturnCode()
    {
        return get(ParamKey.RETURN_CODE) != null ? get(ParamKey.RETURN_CODE).toString() : "";
    }

    public void setReturnCode(String returnCode)
    {
        put(ParamKey.RETURN_CODE, returnCode);
    }

    public String getErrorStackTrace()
    {
        return get(ParamKey.RETURN_ERR_STACK_TRACE) != null ? get(ParamKey.RETURN_ERR_STACK_TRACE).toString() : "";
    }

    public void setErrorStackTrace(String stackTrace)
    {
        put(ParamKey.RETURN_ERR_STACK_TRACE, stackTrace);
    }

    public String getReturnMessage()
    {
        return get(ParamKey.RETURN_MESSAGE) != null ? get(ParamKey.RETURN_MESSAGE).toString() : "";
    }

    public String getBusiSerialNo()
    {
        return get(ParamKey.BUSI_SERIAL_NO) != null ? get(ParamKey.BUSI_SERIAL_NO).toString() : "";
    }

    public void setReturnMessage(String returnMessage)
    {
        put(ParamKey.RETURN_MESSAGE, returnMessage);
    }

    public Object get(Object key)
    {
        Object retObj = null;
        if(key != null && (key instanceof ParamKey))
        {
            StringBuilder sb = null;
            ParamKey paramKey = (ParamKey)key;
            String realKey = paramKey.getKey();
            int listId = paramKey.getPosition();
            Object trueValue = get(realKey);
            if(trueValue != null)
                if(paramKey.isList())
                {
                    if(trueValue instanceof List)
                    {
                        List list = (List)trueValue;
                        if(listId >= 0 && list.size() > listId)
                        {
                            if(paramKey.hasNext())
                            {
                                Object object = list.get(listId);
                                if(object instanceof ServiceParam)
                                {
                                    retObj = ((ServiceParam)object).get(paramKey.next());
                                } else
                                {
                                    sb = new StringBuilder();
                                    sb.append("\u952E").append(realKey).append("[").append(listId).append("]\u5BF9\u5E94\u7684\u503C[").append(object).append("]\u4E0D\u662FServiceParam\uFF0C\u4E0D\u652F\u6301\u6B64\u64CD\u4F5C\uFF01");
                                }
                            } else
                            {
                                retObj = list.get(listId);
                            }
                        } else
                        {
                            sb = new StringBuilder();
                            sb.append("\u952E[").append(realKey).append("]\u7684\u7D22\u5F15[").append(listId).append("]\u9519\u8BEF\uFF01");
                        }
                    } else
                    {
                        sb = new StringBuilder();
                        sb.append("\u952E[").append(realKey).append("]\u5BF9\u5E94\u7684\u503C[").append(trueValue).append("]\u4E0D\u662FList\uFF0C\u4E0D\u652F\u6301\u6B64\u64CD\u4F5C\uFF01");
                    }
                } else
                if(paramKey.hasNext())
                {
                    if(trueValue instanceof ServiceParam)
                    {
                        ServiceParam param = (ServiceParam)trueValue;
                        retObj = param.get(paramKey.next());
                    } else
                    {
                        sb = new StringBuilder();
                        sb.append("\u952E[").append(realKey).append("]\u5BF9\u5E94\u7684\u503C[").append(trueValue).append("]\u4E0D\u662FServiceParam\uFF0C\u4E0D\u652F\u6301\u6B64\u64CD\u4F5C\uFF01");
                    }
                } else
                {
                    retObj = trueValue;
                }
            if(sb != null && log.isInfoEnabled())
                log.info(sb);
        } else
        if(key != null)
            if(key instanceof String)
            {
                if(((String)key).indexOf(".") >= 0 || ((String)key).indexOf("[") > 0)
                    retObj = get(ParamKeyCache.get((String)key));
                else
                    retObj = super.get(Constant.transferConstant((String)key));
            } else
            {
                retObj = super.get(key);
            }
        return retObj;
    }

    public Object put(Object key, Object value)
    {
        Object retObj = null;
        if(key != null && (key instanceof ParamKey))
        {
            StringBuilder sb = null;
            ServiceParam param = null;
            ParamKey paramKey = (ParamKey)key;
            String realKey = paramKey.getKey();
            int listId = paramKey.getPosition();
            Object trueValue = get(realKey);
            if(paramKey.isList())
            {
                List list = null;
                if(trueValue == null)
                {
                    list = new ArrayList();
                    put(realKey, list);
                } else
                if(trueValue instanceof List)
                {
                    list = (List)trueValue;
                    if(listId - list.size() > 50)
                    {
                        if(log.isInfoEnabled())
                        {
                            sb = new StringBuilder();
                            sb.append("\u952E[").append(realKey).append("]\u7684\u7D22\u5F15[").append(listId).append("]\u8D85\u8FC7\u6700\u5927\u7684\u53EF\u8D8A\u754C\u7D22\u5F15\u503C\uFF0C\u4E0D\u652F\u6301\u6B64\u64CD\u4F5C\uFF01");
                            log.info(sb);
                        }
                        return null;
                    }
                } else
                {
                    if(log.isInfoEnabled())
                    {
                        sb = new StringBuilder();
                        sb.append("\u952E[").append(realKey).append("]\u5BF9\u5E94\u7684\u503C[").append(trueValue).append("]\u4E0D\u662FList\uFF0C\u4E0D\u652F\u6301\u6B64\u64CD\u4F5C\uFF01");
                        log.info(sb);
                    }
                    return null;
                }
                for(; list.size() <= listId; list.add(null));
                Object object = list.get(listId);
                if(paramKey.hasNext())
                {
                    if(object instanceof ServiceParam)
                    {
                        param = (ServiceParam)object;
                    } else
                    {
                        param = new ServiceParam();
                        list.set(listId, param);
                    }
                    retObj = param.put(paramKey.next(), value);
                } else
                {
                    list.set(listId, value);
                    retObj = object;
                }
            } else
            if(paramKey.hasNext())
            {
                if(trueValue != null && (trueValue instanceof ServiceParam))
                {
                    param = (ServiceParam)trueValue;
                    retObj = param.put(paramKey.next(), value);
                } else
                {
                    param = new ServiceParam();
                    param.put(paramKey.next(), value);
                    retObj = put(realKey, param);
                }
            } else
            {
                retObj = put(realKey, value);
            }
        } else
        if(key != null)
            if(key instanceof String)
            {
                if(((String)key).indexOf(".") >= 0 || ((String)key).indexOf("[") > 0)
                    put(ParamKeyCache.get((String)key), value);
                else
                    super.put(Constant.transferConstant((String)key), value);
            } else
            {
                super.put(key, value);
            }
        return retObj;
    }

    public static void main(String args[])
    {
        ServiceParam param = new ServiceParam();
        ParamKey param1 = ParamKeyCache.get("A[0].B[3]");
        ParamKey param2 = ParamKeyCache.get("A[1].C");
        ParamKey param3 = ParamKeyCache.get("A[0].B[0].C.D");
        ParamKey param4 = ParamKeyCache.get("A[2].B[1].E");
        ParamKey param5 = ParamKeyCache.get("A[1].B[1].D");
        ParamKey param6 = ParamKeyCache.get("C");
        List list = new ArrayList();
        list.add("mmmm");
        list.add("nnnn");
        param.put("C", list);
        System.out.println(param);
        System.out.println(param.get("C[0]"));
    }

    private static transient Log log = LogFactory.getLog(com.cn.javaFrame.common.util.dataConvert.map.ServiceParam.class);
    private static final long serialVersionUID = 1L;
    public static final Map systemErrInfo = new ServiceParam("29900001", "\u7CFB\u7EDF\u5185\u90E8\u5F02\u5E38");

	

}
