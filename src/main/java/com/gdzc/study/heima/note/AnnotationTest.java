package com.gdzc.study.heima.note;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Liu_Zhichao on 14-8-28.
 * 注解--最基础的Annotation(可以加在包，类，字段，方法，方法参数，局部变量上面)
 */
//自定义的注解
@ItcastAnnotation(value = "default",color = "red",annotationAttr = @Retention(RetentionPolicy.SOURCE))
public class AnnotationTest {
    private String name;

    public static void main(String[] args){
        if (AnnotationTest.class.isAnnotationPresent(ItcastAnnotation.class)){
            ItcastAnnotation ia = AnnotationTest.class.getAnnotation(ItcastAnnotation.class);
            System.out.println("color:" + ia.color() + "----lamp:" + ia.lamp().nextLamp());
        }
    }

    //去除指定的警告加上@SuppressWarnings()注解
    @ItcastAnnotation("default")
    @SuppressWarnings("deprecation")
    public void putMap(){
        findName("hehe");
    }

    //对方法已经过时加上@Deprecated注解
    @Deprecated
    public void findName(String name){}

    //重写方式时加上@Override注解
    @Override
    public String toString() {
        return "AnnotationTest{" +
                "name='" + name + '\'' +
                '}';
    }
}
