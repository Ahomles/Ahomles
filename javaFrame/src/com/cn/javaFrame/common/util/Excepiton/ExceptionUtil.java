package com.cn.javaFrame.common.util.Excepiton;

public final class ExceptionUtil {
	private ExceptionUtil()
    {
    }

    public static void throwBusinessException(String key, Object args[])
        throws BusinessException
    {
        throw new BusinessException(key, args);
    }

    public static void throwBusinessException(String key)
        throws BusinessException
    {
        throw new BusinessException(key);
    }

    public static void throwBusinessException(String key, String val1)
        throws BusinessException
    {
        throw new BusinessException(key, new String[] {
            val1
        });
    }

    public static void throwBusinessException(String key, String val1, String val2)
        throws BusinessException
    {
        throw new BusinessException(key, new String[] {
            val1, val2
        });
    }

    public static void throwBusinessException(String key, String val1, String val2, String val3)
        throws BusinessException
    {
        throw new BusinessException(key, new String[] {
            val1, val2, val3
        });
    }
}
