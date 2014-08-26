package com.gdzc.study.heima.note;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.*;
import java.util.*;

/**
 * Created by Liu_Zhichao on 14-8-25.
 * 反射--作用:实现框架功能
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
        System.out.println("Class:" + c3.isPrimitive());//false 判断字节码是不是基础数据类型的
        System.out.println("Class:" + int.class.isPrimitive());//true
        System.out.println("Class:" + (int.class == Integer.class));//false
        System.out.println("Class:" + (int.class == Integer.TYPE));//true 代表Integer所包装的基础数据类型的字节码
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
        System.out.println("Array:" + arr1.getClass().getName());
        System.out.println("Array:" + arr1.getClass().getSuperclass().getName());
        System.out.println("Array:" + arr4.getClass().getSuperclass().getName());
        Object obj1 = arr1;//由于int是基本数据类型，所以不能用Object[]来表示，arr1只能是一个对象
        Object[] obj2 = arr3;//obj2的每一个元素都是一个一维数组
        Object[] obj3 = arr4;//obj3的每一个元素就是一个String对象，非基本数据类型既可以当做Object来用也可以当做Object[]来用
        System.out.println("Array:" + arr1);//打印的是一个对象地址
        //1.4中asList()接受的参数是Object[]，1.5接受的是可变参数
        System.out.println("Array:" + Arrays.asList(arr1));//会当做1.5的语法处理，所以当做一个数组对象
        System.out.println("Array:" + Arrays.asList(arr4));//会当做1.4的语法处理
        printObject(arr1);

        /*
        HashCode的作用
        */
        //当集合是Hash类型的时候，才会用到HashCode，作用是提高效率
        Collection<ReflectPoint> list = new ArrayList<ReflectPoint>();
        Collection<ReflectPoint> set = new HashSet<ReflectPoint>();
        ReflectPoint rp2 = new ReflectPoint(3,3);
        ReflectPoint rp3 = new ReflectPoint(5,5);
        ReflectPoint rp4 = new ReflectPoint(3,3);
        list.add(rp2);
        list.add(rp3);
        list.add(rp4);
        //Hash集合，先计算HashCode值，相同就不放到set中
        set.add(rp2);
        set.add(rp3);
        set.add(rp4);
        //当add完成之后，再来修改类中参与HashCode计算的变量
        // 那么对象的HashCode值也会改变，由于equals()方法是先用==比较的
        // 所以原先相等的两个对象现在不相等了，下面调用remove()方法无效了
        // 有可能会出现内存泄漏(有一块内存没有使用，但是也没有被释放就会出现)
        rp2.y = 7;
        set.remove(rp2);//删不了的原因是HashCode值变了
        System.out.println(list.size());
        System.out.println(set.size());
        rp2.y = 3;
        set.remove(rp2);
        System.out.println(set.size());

        /*
        框架的概念，用反射开发框架的原理
        */
        try {
            //通过类加载器来读取配置文件,配置文件必须要放在classpath下
            InputStream is = Reflect.class.getClassLoader().getResourceAsStream("config.properties");
            //通过流来读取配置文件
            InputStream fis = new FileInputStream("src/main/resources/config.properties");
            Properties properties = new Properties();
            properties.load(fis);
            fis.close();
            //获取文件中的配置信息
            String className = properties.getProperty("className");
            //根据配置信息创建实例对象
            Collection cc = (Collection)Class.forName(className).newInstance();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    //通过数组的反射来获取数组的长度或者某一个元素
    private static void printObject(Object obj) {
        Class c = obj.getClass();
        if (c.isArray()){//判断obj是否为数组
            int len = Array.getLength(obj);//通过Array来获取数组长度
            for (int i = 0; i < len; i++){
                System.out.println("Array:" + Array.get(obj, i));//通过Array来拿到数组的某一个元素
                System.out.println("Array:" + Array.get(obj,i).getClass().getName());//拿到某个元素的类型
            }
        }else {
            System.out.println("Array:" + obj);
        }
    }
}
