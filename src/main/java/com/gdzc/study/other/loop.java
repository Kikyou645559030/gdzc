package com.gdzc.study.other;

/**
 * Created by Liu_Zhichao on 14-5-11.
 */
public class loop {
    public static void main(String[] args){
        count(50);
    }

    /*规律数1 1 2 3 5 8 13...第三个数等于前两个之和*/
    private static void count(int x){
        int a = 1;
        int b = 1;
        int c = 0;
        for (int i = 2;i < x;i++){
            if (x == 1 || x == 2){
                System.out.println(a);
            } else {
                c = a + b;
                a = b;
                b = c;
            }
        }
        System.out.println("--------------->"+c);
    }
}
