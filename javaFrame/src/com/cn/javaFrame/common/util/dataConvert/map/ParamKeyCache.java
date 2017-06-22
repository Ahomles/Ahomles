package com.cn.javaFrame.common.util.dataConvert.map;

import java.util.HashMap;
import java.util.Map;

import com.cn.javaFrame.common.util.dataConvert.util.StringUtils;

public class ParamKeyCache
{

    public ParamKeyCache()
    {
    }

    private static void init()
    {
        if(IS_INIT.equals(Boolean.FALSE))
            synchronized(IS_INIT)
            {
                if(IS_INIT.equals(Boolean.FALSE))
                {
                    int num = 158;
                    for(int i = 0; i < 64; i++)
//                        BUCK.put(new Integer(i), new LRUMap(num));

                    IS_INIT = Boolean.TRUE;
                }
            }
    }

    public static ParamKey get(String key)
    {
        init();
        ParamKey result = null;
        if(StringUtils.isNotBlank(key))
        {
            int buckNum = Math.abs(key.hashCode() % 64);
            Map map = (Map)BUCK.get(new Integer(buckNum));
            synchronized(map)
            {
                result = (ParamKey)map.get(key);
                if(result == null)
                    if(!map.containsKey(key))
                    {
                        result = (ParamKey)map.get(key);
                        if(result == null)
                        {
                            result = new ParamKey(key);
                            map.put(key, result);
                        }
                    } else
                    {
                        result = (ParamKey)map.get(key);
                    }
            }
        }
        return result;
    }

    private static Boolean IS_INIT;
    private static final int BUCK_SIZE = 64;
    private static final int MAX_CACHE_NUMBER = 10048;
    private static Map BUCK = new HashMap(64);

    static 
    {
        IS_INIT = Boolean.FALSE;
    }
}