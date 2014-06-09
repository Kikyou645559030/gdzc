package com.gdzc.study;

/**
 * Created by Liu_Zhichao on 14-6-9.
 */
public class Algorithm {
    public static void main(String[] args){
        if (args.length > 0){
            if (args.length == 1){
                for (int i = 0; i < args.length - 1; i++){
                    Integer a = Integer.parseInt(args[i]);
                    Integer b = Integer.parseInt(args[i+1]);
                    Integer c = 0;
                    if (a > b){
                        c = b;
                        b = a;
                        a = c;
                        args[i] = a.toString();
                        args[i+1] = b.toString();
                    }
                    a = a < b ? a : b;
                }
            }else {
                System.out.println(args[0]);
            }
        }else {
            System.out.println("请输入正确的数组!");
            System.exit(-1);
        }
    }
}
