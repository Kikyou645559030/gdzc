package com.gdzc.study.heima.baseVideo;

/**
 * Created by Liu_Zhichao on 14-9-20.
 * 继承中的抽象类
 */
public class ExtendsAbstractClass{
    public static void main(String[] args) {
        Worker worker = new Worker("Paul","G424292",7400.00);
        Manager manager = new Manager("Lisa","L084328",8800.00,13000.00);
    }
}

abstract class Employee {
    private String name;
    private String id;
    private Double salary;

    Employee(String name,String id,Double salary){
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public abstract void work();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}

class Worker extends Employee{
    Worker(String name,String id,Double salary){
        super(name,id,salary);
    }

    @Override
    public void work() {
        System.out.println("工人工作");
    }
}

class Manager extends Employee{
    private Double bonus;

    Manager(String name,String id,Double salary,Double bonus){
        super(name,id,salary);
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("经理工作");
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }
}