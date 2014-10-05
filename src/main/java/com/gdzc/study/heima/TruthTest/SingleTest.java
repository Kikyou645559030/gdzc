package com.gdzc.study.heima.TruthTest;

/**
 * Created by Liu_Zhichao on 14-9-7.
 * 黑马入学真实性测试--单例的两种形式
 */
public class SingleTest {
    Dog dog = Dog.getDog();
    Cat cat = Cat.getCat();
}

/*
单例--饿汉式
 */
class Dog{
    private static final Dog dog = new Dog();
    private Dog(){
    }

    public static Dog getDog(){
        return dog;
    }
}

/*
单例--懒汉式
 */
class Cat{
    private static Cat cat = null;
    private Cat(){

    }

    public static synchronized Cat getCat(){
        if (cat == null){
            cat = new Cat();
        }
        return cat;
    }
}