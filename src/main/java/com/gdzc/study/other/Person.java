package com.gdzc.study.other;

/**
 * Created by Liu_Zhichao on 14-5-19.
 */
public class Person {
    private String name;
    private Integer age;
    private String sex;

    public Person(){
        name = "paul";
        age = 16;
        sex = "men";
    }

    public Person(String name,Integer age,String sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Person(String name,Integer age){
        this.name = name;
        this.age = age;
        this.sex = "women";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }
}
