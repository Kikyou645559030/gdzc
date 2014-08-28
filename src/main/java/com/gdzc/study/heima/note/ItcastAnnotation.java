package com.gdzc.study.heima.note;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Liu_Zhichao on 14-8-28.
 * 自定义注解--返回值的类型只能是基本数据类型、String、Enum、Class、Annotation或者是前面所有类型的数组
 */
//表示这个注解的生命周期，一直到运行时都存在(类加载器加载后的二进制的字节码)
@Retention(RetentionPolicy.RUNTIME)
//表示这个注解的使用范围，TYPE是指包括类、接口、注解以及枚举
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface ItcastAnnotation {

    //特殊的方法，在使用注解时，如果只需要填这一项的值，则不需要写"value ="
    String value();

    //所有的方法都默认是public abstract修饰的，在使用注解的时候，当做一个属性来赋值
    // 可以设置缺省值，在使用注解的时候就不是必须为color赋值
    String color() default "yellow";

    //当使用注解时，只需要赋一个值，可以不用写大括号
    int[] arrayAttr() default {1,2,3};

    //枚举类型的
    EnumTest1.TrafficLamp lamp() default EnumTest1.TrafficLamp.RED;

    //注解类型的
    Retention annotationAttr() default @Retention(RetentionPolicy.CLASS);

    //Class类型的
    Class clazzAttr() default String.class;
}
