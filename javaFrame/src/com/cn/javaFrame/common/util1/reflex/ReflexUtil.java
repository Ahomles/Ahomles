package com.cn.javaFrame.common.util1.reflex;

import java.lang.annotation.Annotation;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;

import com.cn.javaFrame.common.util1.reflex.impl.ServiceSVImpl;
import com.cn.javaFrame.common.util1.reflex.interfaces.IServiceSV;

public class ReflexUtil {

	public static void main(String[] args) throws Exception {
		test01();
	}

	private static void test01() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
		//获取类路径
		String className="com.cn.javaFrame.common.util1.reflex.impl.ServiceSVImpl";
		String className_1=ServiceSVImpl.class.getName();
		System.out.println("className_1="+className_1);
		
		//获取类实例
		Class cls=Class.forName(className);
		//接口，（abstract）抽象类,数组类和（primitive）基本类型，或者void的类型，
		//或者没有无参构造器的类，调用getClass().newInstance()都会抛这个异常.java.lang.InstantiationException
		Object obj=cls.newInstance();
		IServiceSV obj_1=new ServiceSVImpl();
		
		//获取类方法
		Method[] methods=cls.getMethods();
		Method[] methods_1=IServiceSV.class.getMethods();
		
		Method method=cls.getMethod("getName", String.class);
		Method method_1=IServiceSV.class.getMethod("getName", String.class);
		
		Method methodinit=cls.getMethod("initName", null);
		Method methodinit_1=IServiceSV.class.getMethod("initName", null);
		
		//获取返回类型
		Class rtnCls=method.getReturnType();
		String rtnTypeSimpleName=rtnCls.getSimpleName();
		String rtnTypeName=rtnCls.getName();
		System.out.println("rtnTypeSimpleName="+rtnTypeSimpleName);//String
		System.out.println("rtnTypeName="+rtnTypeName);
		
		Class rtnClsInit=methodinit.getReturnType();
		String rtnTypeInit=rtnClsInit.getSimpleName();
		System.out.println("rtnTypeInit="+rtnTypeInit);//void
		
		
		//方法调用
		Object rtnObj=method.invoke(obj, "znb"); //getName
		if("String".equals(rtnTypeSimpleName)){
			String rtnString=(String)rtnObj;
			System.out.println("rtnString = "+rtnString);
		}
		methodinit.invoke(obj_1, null);
	}
	
	private static void test2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SecurityException, NoSuchMethodException {
		//获取类路径
		String className="com.cn.javaFrame.common.util1.reflex.impl.ServiceSVImpl";
		String className_1=ServiceSVImpl.class.getName();
		System.out.println("className_1="+className_1);
		
		//获取类实例
		Class cls=Class.forName(className);
		//接口，（abstract）抽象类,数组类和（primitive）基本类型，或者void的类型，
		//或者没有无参构造器的类，调用getClass().newInstance()都会抛这个异常.java.lang.InstantiationException
		Object obj=cls.newInstance();
		IServiceSV obj_1=new ServiceSVImpl();
		
		//获取类方法
		Method[]  methods=cls.getMethods();
		for(int i=0;i<methods.length;i++){
			Method method=methods[i];
			//获取方法的名字
			String name=method.getName();
			if(name.startsWith("set")){
				Class[] cc=method.getParameterTypes();
			}
		}
		
	}
	
	
	
	/**
	 *    
		@MyAnnotation  
	    private <T> boolean add(@MyAnnotation List<T> list, T... params) throws RuntimeException,  
	            Exception {  
	        if (null == list) {  
	            throw new RuntimeException("list=null");  
	        }  
	  
	        if (null == params) {  
	            return false;  
	        }  
	        // 将参数添加到List集合中  
	        if (null != params) {  
	            for (T t : params) {  
	                list.add(t);  
	            }  
	        }  
	        return true;  
	    }  
	 * @param method
	 */
	 //获取方法信息
	 private static void getMethodInfo(Method method) {  
	        // 1、获取方法上的注解  
	        boolean annotationPresent = method.isAnnotationPresent(Annotation.class);  
	        if (annotationPresent) {  
	        	Annotation[] annotation = method.getDeclaredAnnotations();  
	        }  
	        // 2、方法的修饰符  
	        int modifiers = method.getModifiers();  
	        String modify = Modifier.toString(modifiers);// private  
	        // 3、方法上定义的泛型参数  
	        TypeVariable<Method>[] typeParameters = method.getTypeParameters();// [T]  
	        // 4、方法的返回值  
	        Class<?> returnType = method.getReturnType();// boolean  
	        Type genericReturnType = method.getGenericReturnType();// boolean  
	        // 5、方法名称  
	        String name = method.getName();  
	        // 6、方法参数  
	        int parameterCount = method.getParameterTypes().length;// 参数个数 2  
	        // 方法参数——泛型  
	        Class<?>[] parameterTypes = method.getParameterTypes();  
	        // 打印 [interface java.util.List, class [Ljava.lang.Object;]  
	        Type[] genericParameterTypes = method.getGenericParameterTypes();  
	        // 打印 [java.util.List<T>, T[]]  
	        for (Type type : genericParameterTypes) {  
	            if (type instanceof ParameterizedType) { // 参数类型  
	                System.out.println("ParameterizedType类型：" + type);  
	                ParameterizedType parameterizedType = (ParameterizedType) type;  
	                Type[] actualTypeArguments = parameterizedType  
	                        .getActualTypeArguments();  
	                System.out.println("实际参数为："  
	                        + Arrays.toString(actualTypeArguments));  
	                for (Type actualType : actualTypeArguments) {  
	                    if (actualType instanceof WildcardType) {  
	                        WildcardType wildcardType = (WildcardType) actualTypeArguments[0];  
	                        System.out.println("实际参数为WildcardType类型："  
	                                + wildcardType.getUpperBounds());  
	                    } else if (actualType instanceof Class) {  
	                        System.out.println("实际参数为Class类型：" + actualType);  
	                    }  
	                }  
	  
	            } else if (type instanceof GenericArrayType) { // 泛型数组类型 T[]  
	                GenericArrayType genericArrayType = (GenericArrayType) type;  
	                System.out.println("GenericArrayType类型："  
	                        + genericArrayType.getGenericComponentType());//T  
	            } else if (type instanceof TypeVariable) { // 泛型变量  
	                System.out.println("TypeVariable类型：" + type);  
	            } else if (type instanceof Class) { //  
	                System.out.println("Class类型：" + type);  
	            }  
	        }  
	        /* 
	         * 方法有2个参数，第一个参数list为ParameterizedType，实际参数为T， 
	         * 第二个参数为GenericArrayType泛型数组类型T[],数组元素类型为T 
	         */  
	          
	        //方法参数——注解   第一个参数使用了注解  
	        Annotation[][] parameterAnnotations = method.getParameterAnnotations();  
	        Annotation myAnnotation=parameterAnnotations[0][0];  
	        //打印 @reflect.MyAnnotation(intValue=0)  
	          
	  
	        // 7、方法抛出的异常  
	        Class<?>[] exceptionTypes = method.getExceptionTypes();  
	        // 打印 [class java.lang.RuntimeException, class java.lang.Exception]  
	        Type[] genericExceptionTypes = method.getGenericExceptionTypes();  
	        // 打印 [class java.lang.RuntimeException, class java.lang.Exception]  
	        
	        // 如果此方法是 bridge 方法，则返回 true；  
	        boolean bridge = method.isBridge();  
	        //如果该方法是public非抽象非静态，且定义在接口中，则返回true  
//	        boolean default1 = method.isDefault(); //false  
	        //如果此方法为复合方法，则返回 true；  
	        boolean synthetic = method.isSynthetic();//false  
	        // 如果将此方法的参数带有可变参数，则返回 true  
	        boolean varArgs = method.isVarArgs(); //true 
	  
	    }  
	
}
