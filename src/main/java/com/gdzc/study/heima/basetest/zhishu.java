package com.gdzc.study.heima.basetest;

/**
 * Created by Liu_Zhichao on 14-8-21.
 * 求质数的方法
 */
public class zhishu {

    /*
     * 效率最高的一种办法求质数
     */
    public static void main(String[] args) {
        int shu;
        int xx;
        for (shu = 1; shu < 1000; shu++) {//遍历1到999所有的数
            for (xx = 2; xx <= shu / 2; xx++) {//遍历所有的除数。为了效率除数只取到被除数一半
                if (shu % xx == 0)//如果有能被整出的跳过打印这个数
                    break;
            }
            if (xx > shu / 2) {//如果被除数到遍历完了则说明这个数是质数，打印即可
                System.out.print(shu + ",");//为了方便阅读中间用，分割
            }
        }
    }

    /*
     * 另一种求质数的方法
     */
    /*public static void main(String[] args) {
        //循环被除数，
        for(int count=0,i=2;i<100;i++){
            //循环除数
            for(int k=2;k<=i;k++){
                //判断能被几个数整除
                if(i%k==0)
                    count++;}
            //当只能被一个数整除的时候就是素数，这个数就是他本身。
            if(count==1)
                System.out.println(i);
            count=0;
        }
    }*/
}
