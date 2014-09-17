package com.gdzc.study.heimaClass.days05.projectForWork.entity;

/**
 * Created by Liu_Zhichao on 14-9-17.
 * 学生实体类
 */
public class Student {
    private String id;//学号
    private String name;//姓名
    private Double math;//数学成绩

    public Student() {
    }

    public Student(String id, String name, Double math) {
        this.id = id;
        this.name = name;
        this.math = math;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMath() {
        return math;
    }

    public void setMath(Double math) {
        this.math = math;
    }
}
