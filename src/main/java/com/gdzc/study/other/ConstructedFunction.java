package com.gdzc.study.other;

/**
 * Created by Liu_Zhichao on 14-5-16.
 */
public class ConstructedFunction {
    private Integer age;
    private String name;
    private String sex;
    private Integer num;

    ConstructedFunction(Integer age,String name,Integer num,String sex){
        super();
        this.age = age;
        this.name = name;
        this.num = num;
        this.sex = sex;
    }

    public static void main(String[] args){
        ConstructedFunction cf = new ConstructedFunction(1,"嗯哼",3,"呵呵");
        System.out.println(cf.age+"--"+cf.name+"--"+cf.num+"--"+cf.sex);
    }
}
