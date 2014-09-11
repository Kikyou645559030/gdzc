package com.gdzc.study.heima.baseVideo;

import java.util.Date;

/**
 * Created by Liu_Zhichao on 14-9-11.
 * switch语句,break语句可以不用写,接收的参数类型有int(byte,short,char),String,enum
 */
public class Condition {
    public static void main(String[] args){
        //switch的应用
        int x = 0;
        switch (x){
            case 0:
            case 1: System.out.println(x);//多个case对应一个操作
                break;
            case 2: System.out.println(x);
                break;
            default:System.out.println(x);
                break;
        }

        //do...while语句
        int y = 0;
        do {
            System.out.println(y);
            y++;
        }while (y < 10);

        //while语句
        while (true){
            System.out.println(new Date());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
