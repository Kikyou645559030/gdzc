package com.gdzc.study.heima.note;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by Liu_Zhichao on 14-8-25.
 * 反射
 */
public class Reflect {
    public static void main(String[] args){
        /*
          反射的基本信息
          */
        try {
            //作用:返回这个类的字节码的三种方式c1/c2/c3，下面这种方式有两种区别
            // 1.如果这个类已经加载到内存就直接获得
            // 2.如果这个类还没有加载到内存，就要先调用类加载器加载到内存中，保存字节码
            Class c1 = Class.forName("java.lang.String");

            Class c2 = Reflect.class;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Class c3 = (new Reflect()).getClass();
        System.out.println("Class:" + c3.isPrimitive());//false判断字节码是不是基础数据类型的
        System.out.println("Class:" + int.class.isPrimitive());//true
        System.out.println("Class:" + (int.class == Integer.class));//false
        System.out.println("Class:" + (int.class == Integer.TYPE));//true代表Integer所包装的基础数据类型的字节码
        System.out.println("Class:" + int[].class.isPrimitive());//false
        System.out.println("Class:" + int[].class.isArray());//true

        System.out.println("Class:" + c3.toString());
        System.out.println("Class:" + c3.asSubclass(c3));
        System.out.println("Class:" + c3.getCanonicalName());
        System.out.println("Class:" + c3.getClassLoader());
        System.out.println("Class:" + c3.getComponentType());
        System.out.println("Class:" + c3.getConstructors());
        System.out.println("Class:" + c3.getDeclaredFields());
        System.out.println("Class:" + c3.getDeclaredMethods());
        System.out.println("Class:" + c3.getModifiers());
        System.out.println("Class:" + c3.getPackage());
        System.out.println("Class:" + c3.getSimpleName());
        System.out.println("Class:" + c3.getSuperclass());
        System.out.println("Class:" + c3.getTypeParameters());

        //该方法内部先得到默认的构造方法，再用这个构造方法来创建实例对象
        try {
            String obj = (String)Class.forName("java.lang.String").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //九种预定义的Class实例对象,八种基础类型加void
        Class clazz = void.class;

        /*
         反射--构造方法
         */
        //new String(new StringBuffer("abc"));通过构造方法来实现
        //获取只有一个参数，参数类型为StringBuffer的构造方法对象
        try {
            Constructor constructor = String.class.getConstructor(StringBuffer.class);//得到某一个构造方法
            String s = (String)constructor.newInstance(new StringBuffer("abc"));//创建实例对象
            System.out.println("Constructor:" + s.charAt(2));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        /*
         反射--成员变量
         */
        //通过反射拿到一个对象的成员变量
        ReflectPoint rp1 = new ReflectPoint(3,5);
        try {
            //只能拿到公有的成员变量
            Field f1 = rp1.getClass().getField("y");
            System.out.println("Field:" + f1.get(rp1));
            //拿非公有的成员变量要使用下面方法
            Field f2 = rp1.getClass().getDeclaredField("x");
            //暴力反射，拿到所有的成员变量
            f2.setAccessible(true);
            System.out.println("Field:" + f2.get(rp1));
            //通过反射修改一个类里面String类型成员变量的值
            //拿到所有成员变量
            Field[] fields = rp1.getClass().getDeclaredFields();
            for (Field field : fields){
                field.setAccessible(true);
                //判断成员变量的类型，这里比较的是字节码必须用==
                if (field.getType() == String.class){
                    //下面用的不是String.valueOf()也不是.toString()方法,因为已经知道类型是String
                    String value = (String)field.get(rp1);//拿到这个变量对象在rp1这个对象中的值
                    String newValue = value.replace('b','a');
                    field.set(rp1,newValue);
                    System.out.println("Field:----" + newValue);
                    System.out.println("Field:++" + value);
                    System.out.println(rp1.str1);
                    System.out.println(rp1.str2);
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        /*
         反射--成员方法
         */
        String cache = "Kikyou";
        try {
            Method m1 = String.class.getMethod("charAt", int.class);
            //invoke()方法，调用前面的方法对象，并给定参数
            System.out.println("Method:" + m1.invoke(cache, 3));
            //当作用对象(第一个参数)为null时，表示不需要指定的对象，即静态方法
            Method m2 = String.class.getMethod("valueOf", boolean.class);
            System.out.println("Mehtod:" + m2.invoke(null,true));
            ReflectPoint.main(args);
            Method main = ReflectPoint.class.getMethod("main", String[].class);
            //参数为args或者new出来的String数组对象都不行,java虚拟机会自动拆箱(同可变参数一样)
            // 编译器会当做是1.4的语法，然后拆分数组成多个参数
            // 当数组只有一个元素时也不行，还是会拆分数组成一个参数，但是类型就是成String而不是String[]
//            main.invoke(null,args);错误方法！！！
            main.invoke(null,(Object)args);//第一种正确方法，强转类型
            main.invoke(null,new Object[]{args});//第二种正确方法，加一层包装
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        /*
        反射--数组，Object
        */
        int[] arr1 = new int[]{1,2,3};
        int[] arr2 = new int[4];
        int[][] arr3 = new int[2][3];
        String[] arr4 = new String[]{"a","b","c"};
        System.out.println("Array:" + (arr1.getClass() == arr2.getClass()));
//        System.out.println(arr1.getClass() == arr3.getClass());
//        System.out.println(arr1.getClass() == arr4.getClass());
        System.out.println(arr1.getClass().getName());
        System.out.println(arr1.getClass().getSuperclass().getName());
        System.out.println(arr4.getClass().getSuperclass().getName());
        Object obj1 = arr1;//由于int是基本数据类型，所以不能用Object[]来表示，arr1只能是一个对象
        Object[] obj2 = arr3;//obj2的每一个元素都是一个一维数组
        Object[] obj3 = arr4;//obj3的每一个元素就是一个String对象，非基本数据类型既可以当做Object来用也可以当做Object[]来用
        System.out.println(arr1);//打印的是一个对象地址
        //1.4中asList()接受的参数是Object[]，1.5接受的是可变参数
        System.out.println(Arrays.asList(arr1));//会当做1.5的语法处理，所以当做一个数组对象
        System.out.println(Arrays.asList(arr4));//会当做1.4的语法处理
    }
}
