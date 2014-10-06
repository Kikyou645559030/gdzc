package com.gdzc.study.heima.baseVideo.Reflect;

import java.lang.reflect.Field;

/**
 * -反射-通过反射获取成员变量，并修改值
 * Created by Liu_Zhichao on 14-10-6.
 */
public class ReflectPoint {
    public static void main(String[] args) {
        Point point = new Point(3,5);
        try {
            //获取一个类的成员变量对象，这个对象是属于类的，而不是属于具体的某个对象的。
            Field field1 = Point.class.getField("y");//注意：这个方法只能获取public修饰的成员变量
            //设置具体某个对象的，这一成员变量的值
            field1.set(point,8);
            System.out.println(point.y);

            //当获取的成员变量修饰符不是public的时候，就只能用下面的方法来获取
            Field field2 = point.getClass().getDeclaredField("x");//这个方法能够获取所有的成员变量
            field2.setAccessible(true);//设置允许访问
            field2.set(point,8);
            System.out.println(point.getX());
            
            Field[] fields = Point.class.getFields();
            for (Field f : fields) {
                if (f.getType() == String.class){
                    String oldStr = (String) f.get(point);
                    String newStr = oldStr.replace('y','h');
                    f.set(point,newStr);
                }
            }
            System.out.println(point);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

class Point{
    private int x;
    public int y;
    public String s1 = "Kikyou";
    public String s2 = "HelloKitty";
    public String s3 = "LongLongTimeAgo";

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    @Override
    public String toString() {
        return "Point{" +
                "s1='" + s1 + '\'' +
                ", s2='" + s2 + '\'' +
                ", s3='" + s3 + '\'' +
                '}';
    }
}
