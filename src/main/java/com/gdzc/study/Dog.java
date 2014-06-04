package com.gdzc.study;

/**
 * Created by Liu_Zhichao on 14-5-19.
 */
public class Dog extends Animal{
    private int color;
    private int height,weight;

    public String eat(){
        return "1";
    }

    public boolean equals(Object obj){
        if(obj == null) return false;
        else{
            if(obj instanceof Dog){//判断参数obj的类型是否为Cat,instanceof关键字判断一个对象是否是指定的类型或者其子类
                Dog dog = (Dog)obj;
                if(dog.color == this.color && dog.height == this.height && dog.weight == this.weight){
                    return true;
                }
            }
        }
        return false;
    }
}
