package com.gdzc.study.heima.basetest;

/**
 * 第二题：定义一个二维int数组，编写代码获取最小元素。
 *
 * @author Liu_Zhichao
 */
public class Test2 {

    /**
     * 程序的入口
     * @param args
     */
    public static void main(String[] args){
        //随机定义一组二维数组
        int[][] arr = {{5,42,6},{13,0,45,4},{1,24,22},{8,9},{1,66,32}};
        //调用getMin()方法获取二维数组的最小值，并打印在控制台上
        System.out.println(getMin(arr));
    }

    /**
     * 获取一个二维数组的最小值
     * @param arr
     * @return
     */
    public static int getMin(int[][] arr){
        //定义一个变量最小值，默认为二维数组的第一个值
        int min = arr[0][0];
        //双层for循环遍历二维数组，获取二维数组的每一个值
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                //将获取的二维数组值和定义的min作比较，如果值比min小，就将这个值赋给min
                if (min > arr[i][j]) {
                    min = arr[i][j];
                }
            }
        }
        return min;
    }
}
