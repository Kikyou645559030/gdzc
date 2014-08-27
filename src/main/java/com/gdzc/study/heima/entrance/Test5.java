package com.gdzc.study.heima.entrance;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * 题目五：编写一个类，增加一个实例方法用于打印一条字符串。并使用反射手段创建该类的对象， 并调用该对象中的方法。
 * 
 * @author Liu_Zhichao
 */
public class Test5 {
	/**
	 * 程序的入口
	 * @param args
	 */
	public static void main(String[] args){
		try {
			//拿到Temp类在内存中的字节码
			Class<Temp> clazz = Temp.class;
			//通过反射创建实例对象
			Temp temp = (Temp)clazz.newInstance();
			//调用该对象中的方法
			temp.print("通过反射创建对象实例调用方法");
			//通过反射拿到类中的方法，再调用
			Method method = clazz.getMethod("print", String.class);
			method.invoke(temp, "通过反射获得方法再调用");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}

/**
 * 临时类，有一个打印字符串的方法
 * @author Liu_Zhichao
 */
class Temp{
	public void print(String content){
		System.out.println(content);
	}
}
