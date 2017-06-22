package com.cn.javaFrame.common.util.dataConvert.beanutil;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.cn.javaFrame.common.util.dataConvert.beanutil.digester.Area;
import com.cn.javaFrame.common.util.dataConvert.beanutil.digester.ViewCache;

public class TestDigester {
	public static void main(String[] args) throws Exception {
		ViewCache cache=test01();
		System.out.println(cache);
	}
	
	

	private static ViewCache  test01() throws Exception {
        Digester digester = new Digester();  
        digester.setValidating(false);  
        digester.addObjectCreate("viewcache/areas", ViewCache.class);  
        // 指明匹配模式和要创建的类   
        digester.addObjectCreate("viewcache/areas/area", Area.class);  
     // 设置对象属性,与xml文件对应,不设置则是默认  
//        digester.addBeanPropertySetter("viewcache/areas/area/id", "id");  
//        digester.addBeanPropertySetter("viewcache/areas/area/parentId", "parentId");  
//        digester.addBeanPropertySetter("viewcache/areas/area/name", "name");  
//        digester.addBeanPropertySetter("viewcache/areas/area/areaType", "areaType");  
//        digester.addBeanPropertySetter("viewcache/areas/area/ordering", "ordering");  
//        digester.addBeanPropertySetter("viewcache/areas/area/zip", "zip");  
//        digester.addBeanPropertySetter("viewcache/areas/area/phoneArea", "phoneArea");  
        // 当移动到下一个标签中时的动作  
        digester.addSetNext("viewcache/areas/area", "addArea");  
          
        ViewCache vc = null;  
        try {  
            vc = (ViewCache) digester.parse("src/com/cn/javaFrame/common/util/dataConvert/beanutil/digester/test.xml");  
//            vc = (ViewCache) digester.parse("src/test.xml");  
        } catch (IOException e) {  
            throw new Exception(e);  
        } catch (SAXException e) {  
            throw new Exception(e);  
        }  
        return vc;  
	}
}
