
package com.cn.javaFrame.common.util.dataConvert.map;

import com.ai.common.esb.Constant;
import com.cn.javaFrame.common.util.dataConvert.util.StringUtils;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ParamKey
    implements Iterator, Serializable
{

    ParamKey(String originalKey)
    {
        this.originalKey = null;
        key = null;
        list = false;
        position = -1;
        end = true;
        nextKey = null;
        if(StringUtils.isNotBlank(originalKey))
        {
            originalKey = Constant.transferConstant(originalKey);
            String firstKey = null;
            String remainKey = null;
            int firstPointIndex = originalKey.indexOf(".");
            if(firstPointIndex < 0)
                firstKey = originalKey;
            else
            if(firstPointIndex == 0)
            {
                int secPointIndex = originalKey.indexOf(".", firstPointIndex + 1);
                if(secPointIndex < 0)
                {
                    firstKey = originalKey.substring(1);
                } else
                {
                    firstKey = originalKey.substring(1, secPointIndex);
                    remainKey = originalKey.substring(secPointIndex + 1);
                }
            } else
            {
                firstKey = originalKey.substring(0, firstPointIndex);
                remainKey = originalKey.substring(firstPointIndex + 1);
            }
            Matcher matcher = pattern.matcher(firstKey);
            if(matcher.find())
            {
                key = matcher.group(1);
                list = true;
                position = Integer.parseInt(matcher.group(2));
            } else
            {
                key = firstKey;
            }
            if(StringUtils.isNotBlank(remainKey))
            {
                end = false;
                nextKey = new ParamKey(remainKey);
            }
            this.originalKey = originalKey;
        }
    }

    public String getOriginalKey()
    {
        return originalKey;
    }

    public String getKey()
    {
        return key;
    }

    public boolean isList()
    {
        return list;
    }

    public int getPosition()
    {
        return position;
    }

    public boolean hasNext()
    {
        return !end;
    }

    public Object next()
    {
        return nextKey;
    }

    public void remove()
    {
        if(log.isErrorEnabled())
            log.error("\u8BE5\u5BF9\u8C61\u4E0D\u652F\u6301remove\u64CD\u4F5C!");
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
        result.append("\u952E\uFF1A").append(getKey()).append("\t\u662F\u5426\u5217\u8868\uFF1A").append(isList()).append("\t\u5217\u8868\u4F4D\u7F6E\uFF1A").append(getPosition()).append("\t\u662F\u5426\u6700\u540E\uFF1A").append(end).append("\n");
        if(next() != null)
            result.append(next());
        return result.toString();
    }

    public static void main(String args[])
        throws Exception
    {
        ParamKey paramKey = new ParamKey("a.B[0].C[10].D");
        System.out.println(TRANSACTION_ID.getOriginalKey());
        System.out.println(paramKey.getKey());
        for(; paramKey.hasNext(); System.out.println(paramKey.getKey()))
            paramKey = (ParamKey)paramKey.next();

    }

    private static final long serialVersionUID = 7109092935202700191L;
    private static transient Log log = LogFactory.getLog(com.cn.javaFrame.common.util.dataConvert.map.ParamKey.class);
    private static Pattern pattern = Pattern.compile("(.+)\\[(\\d*)\\]");
    public static final ParamKey TRANSACTION_ID;
    public static final ParamKey TRANSACTION_TIME;
    public static final ParamKey INTERFACE_ID;
    public static final ParamKey INTERFACE_TYPE;
    public static final ParamKey OPER_ID;
    public static final ParamKey ORG_ID;
    public static final ParamKey REGION_CODE;
    public static final ParamKey REGION_ID;
    public static final ParamKey MENU_ID;
    public static final ParamKey COUNTY_CODE;
    public static final ParamKey CLIENT_IP;
    public static final ParamKey SYS_OP_ID;
    public static final ParamKey CHNL_TYPE;
    public static final ParamKey ACT_CHNL_TYPE;
    public static final ParamKey OSB_SERIALNO;
    public static final ParamKey BUSI_CODE;
    public static final ParamKey BUSI_PARAMS;
    public static final ParamKey VERIFY_SERIAL;
    public static final ParamKey RETURN_CODE;
    public static final ParamKey RETURN_MESSAGE;
    public static final ParamKey RETURN_ERR_STACK_TRACE;
    public static final ParamKey RETURN_INFO;
    public static final ParamKey BUSI_SERIAL_NO;
    private String originalKey;
    private String key;
    private boolean list;
    private int position;
    private boolean end;
    private ParamKey nextKey;

    static 
    {
        TRANSACTION_ID = new ParamKey((new StringBuilder()).append(com.ai.common.esb.Constant.PublicInfo.PUBINFO).append(".").append(com.ai.common.esb.Constant.PublicInfo.TRANSACTIONID).toString());
        TRANSACTION_TIME = new ParamKey((new StringBuilder()).append(com.ai.common.esb.Constant.PublicInfo.PUBINFO).append(".").append(com.ai.common.esb.Constant.PublicInfo.TRANSACTIONTIME).toString());
        INTERFACE_ID = new ParamKey((new StringBuilder()).append(com.ai.common.esb.Constant.PublicInfo.PUBINFO).append(".").append(com.ai.common.esb.Constant.PublicInfo.INTERFACEID).toString());
        INTERFACE_TYPE = new ParamKey((new StringBuilder()).append(com.ai.common.esb.Constant.PublicInfo.PUBINFO).append(".").append(com.ai.common.esb.Constant.PublicInfo.INTERFACETYPE).toString());
        OPER_ID = new ParamKey((new StringBuilder()).append(com.ai.common.esb.Constant.PublicInfo.PUBINFO).append(".").append(com.ai.common.esb.Constant.PublicInfo.OPID).toString());
        ORG_ID = new ParamKey((new StringBuilder()).append(com.ai.common.esb.Constant.PublicInfo.PUBINFO).append(".").append(com.ai.common.esb.Constant.PublicInfo.ORGID).toString());
        REGION_CODE = new ParamKey((new StringBuilder()).append(com.ai.common.esb.Constant.PublicInfo.PUBINFO).append(".").append(com.ai.common.esb.Constant.PublicInfo.REGIONCODE).toString());
        REGION_ID = new ParamKey((new StringBuilder()).append(com.ai.common.esb.Constant.PublicInfo.PUBINFO).append(".").append(com.ai.common.esb.Constant.PublicInfo.REGIONID).toString());
        MENU_ID = new ParamKey((new StringBuilder()).append(com.ai.common.esb.Constant.PublicInfo.PUBINFO).append(".").append(com.ai.common.esb.Constant.PublicInfo.MENUID).toString());
        COUNTY_CODE = new ParamKey((new StringBuilder()).append(com.ai.common.esb.Constant.PublicInfo.PUBINFO).append(".").append(com.ai.common.esb.Constant.PublicInfo.COUNTYCODE).toString());
        CLIENT_IP = new ParamKey((new StringBuilder()).append(com.ai.common.esb.Constant.PublicInfo.PUBINFO).append(".").append(com.ai.common.esb.Constant.PublicInfo.CLIENTIP).toString());
        SYS_OP_ID = new ParamKey((new StringBuilder()).append(com.ai.common.esb.Constant.PublicInfo.PUBINFO).append(".").append(com.ai.common.esb.Constant.PublicInfo.SYS_OP_ID).toString());
        CHNL_TYPE = new ParamKey((new StringBuilder()).append(com.ai.common.esb.Constant.PublicInfo.PUBINFO).append(".").append(com.ai.common.esb.Constant.PublicInfo.CHNLTYPE).toString());
        ACT_CHNL_TYPE = new ParamKey((new StringBuilder()).append(com.ai.common.esb.Constant.PublicInfo.PUBINFO).append(".").append(com.ai.common.esb.Constant.PublicInfo.ACTCHNLTYPE).toString());
        OSB_SERIALNO = new ParamKey((new StringBuilder()).append(com.ai.common.esb.Constant.PublicInfo.PUBINFO).append(".").append(com.ai.common.esb.Constant.PublicInfo.OSBSERIALNO).toString());
        BUSI_CODE = new ParamKey((new StringBuilder()).append(com.ai.common.esb.Constant.PublicInfo.REQUEST).append(".").append(com.ai.common.esb.Constant.PublicInfo.BUSICODE).toString());
        BUSI_PARAMS = new ParamKey((new StringBuilder()).append(com.ai.common.esb.Constant.PublicInfo.REQUEST).append(".").append(com.ai.common.esb.Constant.PublicInfo.BUSIPARAMS).toString());
        VERIFY_SERIAL = new ParamKey((new StringBuilder()).append(com.ai.common.esb.Constant.PublicInfo.REQUEST).append(".").append(com.ai.common.esb.Constant.PublicInfo.BUSIPARAMS).append(".").append(com.ai.common.esb.Constant.PublicInfo.VERIFY_SERIAL).toString());
        RETURN_CODE = new ParamKey((new StringBuilder()).append(com.ai.common.esb.Constant.PublicInfo.RESPONSE).append(".").append(com.ai.common.esb.Constant.PublicInfo.ERRORINFO).append(".").append(com.ai.common.esb.Constant.PublicInfo.CODE).toString());
        RETURN_MESSAGE = new ParamKey((new StringBuilder()).append(com.ai.common.esb.Constant.PublicInfo.RESPONSE).append(".").append(com.ai.common.esb.Constant.PublicInfo.ERRORINFO).append(".").append(com.ai.common.esb.Constant.PublicInfo.MESSAGE).toString());
        RETURN_ERR_STACK_TRACE = new ParamKey((new StringBuilder()).append(com.ai.common.esb.Constant.PublicInfo.RESPONSE).append(".").append(com.ai.common.esb.Constant.PublicInfo.ERRORINFO).append(".").append(com.ai.common.esb.Constant.PublicInfo.ERRSTATCTRACE).toString());
        RETURN_INFO = new ParamKey((new StringBuilder()).append(com.ai.common.esb.Constant.PublicInfo.RESPONSE).append(".").append(com.ai.common.esb.Constant.PublicInfo.RETINFO).toString());
        BUSI_SERIAL_NO = new ParamKey((new StringBuilder()).append(com.ai.common.esb.Constant.PublicInfo.RESPONSE).append(".").append(com.ai.common.esb.Constant.PublicInfo.BUSI_SERIAL_NO).toString());
    }
}


/*
	DECOMPILATION REPORT

	Decompiled from: D:\develop\repository\com\asiainfo\common\aicommon-csf\1.0-SNAPSHOT\aicommon-csf-1.0-SNAPSHOT.jar
	Total time: 197 ms
	Jad reported messages/errors:
	Exit status: 0
	Caught exceptions:
*/