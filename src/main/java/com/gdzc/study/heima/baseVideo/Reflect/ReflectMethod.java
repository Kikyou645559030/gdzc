package com.gdzc.study.heima.baseVideo.Reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * -反射-通过反射拿到方法，再调用方法
 * Created by Liu_Zhichao on 14-10-6.
 */
public class ReflectMethod {
    public static void main(String[] args) {
        String str = "zbc";
        try {
            //反射获取一个类的方法，需要提供方法名和方法的参数类型
            Method method1 = String.class.getMethod("charAt",int.class);
            //调用方法
            Character value = (Character) method1.invoke(str,1);
            System.out.println(value);

            Method method2 = Math.class.getMethod("max", int.class, int.class);
            //调用一个静态方法时，第一个参数为null，因为不需要对象
            Object max = method2.invoke(null,3,2);
            System.out.println(max);

            Method method3 = StaticTest.class.getMethod("get");
            //调用无参静态方法时，只需要一个null参数。注意：不能通过反射调用生成随机数的方法。
            Object num = method3.invoke(null);
            System.out.println(num);

            Method method4 = StaticTest.class.getMethod("main", String[].class);
            //注意：main方法接受的是数组参数，1.5后的版本会自动拆箱，可以通过强转成Object对象来禁止自动拆箱，
            method4.invoke(null,(Object)new String[]{"ab","cd","ef"});
//            method4.invoke(null,new Object[]{new String[]{"ab","cd","ef"}});//将数组再封装下，外面加一层数组对象
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

class StaticTest{
    public static void main(String[] args) {
        System.out.println("反射调用main方法");
        for (String str : args){
            System.out.println(str + "  ");
        }
    }
    public static int get(){
        return 1;
    }
}
