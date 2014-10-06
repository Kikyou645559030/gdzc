package com.gdzc.study.heima.baseVideo.Reflect;

/**
 * -反射-反射的方式
 * -反射就是把一个java类中的成分映射成相应的java类
 * Created by Liu_Zhichao on 14-10-6.
 */
public class ReflectWay {
    /**
     * -通过反射加载类的三中方式
     * @param args
     */
    public static void main(String[] args) {
        Class clazz = String.class;//通过类名来获得
        Class clazz1 = "dou".getClass();//通过具体对象来获得
        try {
            Class clazz2 = Class.forName("java.lang.String");//通过完整包名类名的字符串来获得
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        /**
         * 9个预定义的Class对象,8种基础类型，一个void。
         */
        Class byteClazz = byte.class;
        Class sClazz = short.class;
        Class iClazz = int.class;//等同于Integer.TYPE
        Class lClazz = long.class;
        Class dClazz = double.class;
        Class fClazz = float.class;
        Class cClazz = char.class;
        Class bClazz = boolean.class;
        Class vClazz = void.class;

        /**
         * -数组对象的Class
         */
        Class aiClazz = int[].class;
        Class acClazz = char[].class;

        /**
         * -其他类型
         */
        Class strClazz = String.class;
        Class intClazz = Integer.class;//注意：Integer.TYPE表示的是其包装的基本数据类型的Class对象
    }
}
