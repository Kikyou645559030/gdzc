package com.gdzc.study.heima.baseVideo.Reflect;

import java.lang.reflect.Array;

/**
 * -反射-反射数组
 * Created by Liu_Zhichao on 14-10-6.
 */
public class ReflectArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        Class clazz = arr.getClass();
        if (clazz.isArray()){//判断字节码是不是数组
            int len = Array.getLength(arr);//反射获得数组的长度
            for (int i = 0; i < len; i++) {
                Object num = Array.get(arr,i);//返回值是Object，可以强转
                System.out.println(num);
                Array.setInt(arr,i,10+i);//反射设置数组指定下标的值
                int con = Array.getInt(arr,i);//直接返回指定类型
                System.out.println(con);
            }
        }
    }
}
