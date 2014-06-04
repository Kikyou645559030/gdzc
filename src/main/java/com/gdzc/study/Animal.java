package com.gdzc.study;

/**
 * Created by Liu_Zhichao on 14-5-19.
 */
public class Animal {
    private Integer age;
    private  String color;

    public Integer getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void eat(Integer age){
    }

    public String toString(){
        return "呵呵";
    }

    public boolean equals(Object obj){
        return true;
    }
}
