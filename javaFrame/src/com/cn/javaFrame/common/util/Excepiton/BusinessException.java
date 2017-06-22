package com.cn.javaFrame.common.util.Excepiton;

public class BusinessException extends Exception {
	  public BusinessException(String key)
	    {
	        super(wrapperMessage(key, null));
	        this.key = null;
	        args = null;
	        this.key = key;
	    }

	    public BusinessException(String key, Object args[])
	    {
	        super(wrapperMessage(key, args));
	        this.key = null;
	        this.args = null;
	        this.key = key;
	        this.args = args;
	    }

	    public BusinessException(String key, Object args[], String message)
	    {
	        super(message);
	        this.key = null;
	        this.args = null;
	        this.key = key;
	        this.args = args;
	    }

	    public BusinessException(String key, Object args[], Throwable cause)
	    {
	        super(wrapperMessage(key, args), cause);
	        this.key = null;
	        this.args = null;
	        this.key = key;
	        this.args = args;
	    }

	    public BusinessException(String key, Throwable cause)
	    {
	        super(wrapperMessage(key, null), cause);
	        this.key = null;
	        args = null;
	        this.key = key;
	    }

	    public String getKey()
	    {
	        return key;
	    }

	    public Object[] getArgs()
	    {
	        return args;
	    }

	    private static String wrapperMessage(String key, Object args[])
	    {
	        try
	        {
	        	return "";
//	            return args != null ? CrmLocaleFactory.getResource(key, args) : CrmLocaleFactory.getResource(key);
	        }
	        catch(Throwable var5)
	        {
	            StringBuilder sb = new StringBuilder();
	            sb.append("{");
	            if(args != null)
	            {
	                for(int i = 0; i < args.length; i++)
	                {
	                    sb.append(args[i]);
	                    if(i != args.length - 1)
	                        sb.append(",");
	                }

	            }
	            sb.append("}");
	            return (new StringBuilder()).append("key=").append(key).append(",args=").append(sb.toString()).toString();
	        }
	    }

	    private static final long serialVersionUID = -2802602541546871947L;
	    private String key;
	    private Object args[];
}
