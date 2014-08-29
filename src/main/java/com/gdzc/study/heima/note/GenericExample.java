package com.gdzc.study.heima.note;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

/**
 * Created by Liu_Zhichao on 14-8-29.
 * 泛型类型
 * 泛型--练习题
 */
public class GenericExample<E> {
    public static void main(String[] args){
        Object obj = "abc";
        String s = toWilfullyType(obj);
        System.out.println(s);

        String[] strings = new String[3];
        fill(strings,"a");

        /*
        通过反射拿到方法的参数泛型，异常泛型，返回值泛型
         */
        try {
            Method method = GenericExample.class.getDeclaredMethod("getString", List.class);
            Type[] typeArr = method.getGenericParameterTypes();//拿到带有泛型的参数类型
            Type type = method.getGenericReturnType();//拿到带有泛型的返回值类型
            Type[] types = method.getGenericExceptionTypes();//拿到带有泛型的异常类型
            ParameterizedType pType = (ParameterizedType)typeArr[0];//表示参数化类型
            System.out.println(pType.getRawType());//获取参数元类型
            System.out.println(pType.getActualTypeArguments()[0]);//获取实际参数类型，也就是泛型
            System.out.println(pType.getOwnerType());//未知
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private static String getString(List<String> list){
        return null;
    }

    /*
    自动将Object类型的对象转换成任意对象
     */
    //可以通过调用方法时定义的接受返回值类型来确定泛型方法定义的类型
    private static <E> E toWilfullyType(Object obj){
        return (E)obj;
    }

    /*
    将任意类的数组填满该类型的一个对象
     */
    private static <T> void fill(T[] ts,T t){
        for (int i = 0; i < ts.length; i++){
            ts[i] = t;
            System.out.println(ts[i]);
        }
    }

    private static <T> T[] copyColl(Collection<T> collection,T[] ts){
        collection.toArray(ts);
        return ts;
    }

    /*
    将任意类型的一个数组中的数据安全的复制到另一个数组中
    可以传递两个不同类型的数组，因为有类型推断
    当传递的两个参数类型不同时(有返回值)，会根据返回值的类型优先推断
    当传递的两个参数类型不同时(void-无返回值)，会根据参数类型来推断
     */
    private static <T> T[] copyArr(T[] t1, T[] t2){
        int len = Math.max(t1.length,t2.length);
        for (int i = 0; i < len; i++){
            t2[i] = t1[i];
        }
        return t2;
    }
}
