package com.gdzc.study.heima.note;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Created by Liu_Zhichao on 14-8-28.
 * 泛型
 * <?>通配符 <? extend Number>限定通配符必须是Number及其子类 <? super Integer>限定通配符必须是Integer的超类(父类及爷爷类)
 */
public class GenericTest {
    public static void main(String[] args){
        try {
            Constructor<String> constructor = String.class.getConstructor(StringBuffer.class);//得到某一个构造方法
            String s = constructor.newInstance(new StringBuffer("abc"));//创建实例对象
            System.out.println("Constructor:" + s.charAt(2));

            //通过反射可以跳过泛型限制，向集合中加入其它类型的值
            List<Integer> list = new ArrayList<Integer>();
            list.getClass().getMethod("add",Object.class).invoke(list,"abc");
            System.out.println(list.get(0));

            //遍历Map取Entry集合，再通过遍历Entry集合来拿到key和value
            HashMap<String,Integer> map = new HashMap<String, Integer>();
            map.put("Kikyou", 50);
            map.put("Lzc", 22);
            Set<Map.Entry<String,Integer>> set = map.entrySet();
            for (Map.Entry<String,Integer> entry : set){
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }

            //自定义泛型方法，当类型不同时取交集，这就是类型推断(方法参数类型有修改，暂时注释下面代码)
//            Integer num1 = add(3,5);//可以，交集是Integer
//            Float num = add(3.5,4);//不可以，不管是Integer还是Float都会报错
//            Number num2 = add(3.5,4);//可以，交集是Number
//            Object obj = add(3,"abc");//可以，类型推断出来的是Object

            swap(new String[]{"a","b","c"},1,2);
//            swap(new int[]{1,2,3},1,2);//会报错，自定义类型只能是对象类型，不能是基础数据类型
            swap(new Integer[]{1,2,3},1,2);//使用基本数据类型的包装类就可以了
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    /*
    使用通配符占位的集合，只能进行不需要类型的操作，比如获取大小
     */
    public static void printCollection(Collection<?> collection){
        System.out.println(collection.size());
        for (Object obj : collection){
            System.out.println(obj);
        }
        collection = new HashSet<Date>();//可以的
    }

    /*
    自定义泛型方法，必须是引用类型(对象类型),可以使用extends限定通配符来限制类型,还可以用&表示多个类型(一般是接口类型),还可以用在throws异常中(不能用在catch中)
    在方法的返回值之前，用<>表示的是定义一种类型
     */
    private static <T extends List & Set, E extends Exception> T add(T x,T y) throws E{
        try {
        }catch (Exception e){
            throw (E)e;
        }
        return null;
    }

    /*
    自定义泛型方法，交换任意类型数组的第i个位置和第j个位置的值
     */
    public static <T> void swap(T[] t, int i, int j){
        T temp = t[i];
        t[i] = t[j];
        t[j] = temp;
    }
}
