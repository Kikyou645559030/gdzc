package com.gdzc.study.heima.note;

/**
 * Created by Liu_Zhichao on 14-8-25.
 * variable可变parameter参数
 * 可变参数的特点:
 * 1.只能出现在参数列表的最后
 * 2.表示符号(...)位于变量类型和变量名之间，前后有无空格都行
 * 3.调用可变参数的方法时，编译器为该可变参数隐式的创建了一个数组，在方法体中以数组的形式访问可变参数
 */
public class VariableParameter {
    public static void main(String[] args){
        System.out.println(add(2,3));
        System.out.println(add(2,3,5));
        System.out.println(add(2,3,5,7));
    }

    public static int add(int x,int...y){
        int sum = x,count = x;
        for (int i = 0;i < y.length;i++){
            sum += y[i];
        }

        for (int arg : y){
            count += arg;
        }

        return sum;
    }
}
