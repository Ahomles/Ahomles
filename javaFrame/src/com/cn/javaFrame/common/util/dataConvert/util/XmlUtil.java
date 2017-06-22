package com.cn.javaFrame.common.util.dataConvert.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.ai.common.esb.Constant;
import com.ai.common.esb.util.ParamKeyCache;

public class XmlUtil {

	/**
	 * 增强般的xml解析
	 * @param root
	 * @param parentKey
	 * @param cfgMap
	 * @param serParam
	 * @return
	 */
	private static Map getBusiParamMap(Element root, String parentKey, Map cfgMap, Map serParam)
    {
        for(Iterator iterEle = root.elementIterator(); iterEle.hasNext();)
        {
            Element node = (Element)iterEle.next();
            if(node.isTextOnly())
            {
                if(StringUtils.isBlank(parentKey))
                {
                    if(cfgMap.containsKey(Constant.transferConstant(node.getName())))
                    {
                        int index = ((Integer)cfgMap.get(Constant.transferConstant(node.getName()))).intValue();
                        serParam.put(ParamKeyCache.get(getKeyExpr(parentKey, node.getName(), index)), node.getText().trim());
                        cfgMap.put(Constant.transferConstant(node.getName()), Integer.valueOf(++index));
                    } else
                    {
                        serParam.put(ParamKeyCache.get(getKeyExpr(parentKey, node.getName(), -1)), node.getText().trim());
                    }
                } else
                {
                    String cfgKey = parentKey + "." + node.getName();
                    cfgKey = Constant.transferConstant(cfgKey);
                    if(cfgMap.containsKey(cfgKey.replaceAll("\\[\\d+\\]", "")))
                    {
                        int index = cfgMap.get(cfgKey) != null ? ((Integer)cfgMap.get(cfgKey)).intValue() : 0;
                        serParam.put(ParamKeyCache.get(getKeyExpr(parentKey, node.getName(), index)), node.getText().trim());
                        cfgMap.put(cfgKey, Integer.valueOf(++index));
                    } else
                    {
                        serParam.put(ParamKeyCache.get(getKeyExpr(parentKey, node.getName(), -1)), node.getText().trim());
                    }
                }
            } else
            {
                String cfgKey = "";
                StringBuffer sb = new StringBuffer();
                if(StringUtils.isNotBlank(parentKey))
                    sb.append(parentKey).append(".");
                cfgKey = sb.append(node.getName()).toString();
                cfgKey = Constant.transferConstant(cfgKey);
                int index = cfgMap.get(cfgKey) != null ? ((Integer)cfgMap.get(cfgKey)).intValue() : 0;
                if(StringUtils.isBlank(parentKey))
                {
                    if(cfgMap.containsKey(Constant.transferConstant(node.getName())))
                    {
                        serParam = getBusiParamMap(node, getKeyExpr(null, node.getName(), index), cfgMap, serParam);
                        cfgMap.put(cfgKey, Integer.valueOf(++index));
                    } else
                    {
                        serParam = getBusiParamMap(node, node.getName(), cfgMap, serParam);
                    }
                } else
                if(cfgMap.containsKey(cfgKey.replaceAll("\\[\\d+\\]", "")))
                {
                    serParam = getBusiParamMap(node, getKeyExpr(parentKey, node.getName(), index), cfgMap, serParam);
                    cfgMap.put(cfgKey, Integer.valueOf(++index));
                } else
                {
                    serParam = getBusiParamMap(node, getKeyExpr(parentKey, node.getName(), -1), cfgMap, serParam);
                }
            }
        }

        return serParam;
    }
	
	private static String getKeyExpr(String paranet, String NodeName, int index)
    {
        StringBuffer sb = new StringBuffer();
        if(StringUtils.isNotBlank(paranet))
            sb.append(paranet).append(".");
        sb.append(NodeName);
        if(index > -1)
            sb.append("[").append(index).append("]");
        return sb.toString();
    }

	
	
	/**
	 * xml转化为Map,无法解析list的形式
	 * @param xmlStr
	 * @return
	 * @throws Exception
	 */
	public static Map fromXml2Map(String xmlStr) throws Exception{
		if(null==xmlStr||"".equals(xmlStr)){
			return null;
		}
		Document document=DocumentHelper.parseText(xmlStr);
		Element rootElement=document.getRootElement();
		if(null==rootElement){
			throw new Exception("根元素为null！");
		}
		Map retMap=new HashMap();
		retMap.put(rootElement.getName(),handleElement(rootElement));
		return retMap;
	}
	
	
	public static Map handleElement(Element element){
		Map retMap=new HashMap();
		for(Iterator iterator = element.elementIterator();iterator.hasNext();){
			element=(Element)iterator.next();
			if(element.isTextOnly()){
				retMap.put(element.getName(), element.getText());
			}else{
				retMap.put(element.getName(), handleElement(element));
			}
		}
		return retMap;
	}
}
