package com.gdzc.study.heima.basetest;

/**
 * 第三题：求斐波那契数列第n项，n<30，斐波那契数列前10项为 1,1,2,3,5,8,13,21,34,55
 *
 * @author Liu_Zhichao
 */
public class Test3 {

    /**
     * 程序的入口
     * @param args
     */
    public static void main(String[] args){
        //调用getFibonacciSequence()方法在控制台打印小于第n项的全部斐波那契数列值
        getFibonacciSequence(30);
    }

    /**
     * 获取斐波那契数列小于第n项的值
     * @param n
     * @return
     */
    public static void getFibonacciSequence(int n){
        int result = 1;//定义结果变量，默认为1
        int first = 1;//定义第一项的值，或者前两项的值，默认为1
        int second = 1;//定义第二项的值，或者前一项的值，默认为1
        //判断，只有当n大于0时才开始计算
        if(n > 0){
            //判断，当n大于2的时候，计算出小于第n项的全部斐波那契数列值，当n为1或者2的时候直接打印当前项的值
            if(n > 2){
                System.out.println("第1项项斐波那契数列值是：1");
                System.out.println("第2项项斐波那契数列值是：1");
                for (int i = 2; i < (n-1); i++) {
                    result = first + second;
                    first = second;
                    second = result;
                    System.out.println("第"+(i+1)+"项斐波那契数列值是："+result);
                }
            }else{
                System.out.println("第"+n+"项斐波那契数列值是：1");
            }
        }
    }
}
