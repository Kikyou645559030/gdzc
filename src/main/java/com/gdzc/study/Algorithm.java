package com.gdzc.study;

/**
 * Created by Liu_Zhichao on 14-6-9.
 */
public class Algorithm {
    //args是javac时候后面跟着的参数
    public static void main(String[] args){
        Integer[] arrayList = new Integer[args.length];
        if (args.length > 0){
            if (args.length > 1){
                //将输入的字符串数组转换为Integer数组
                for (int i = 0; i < args.length;i++){
                    arrayList[i] = Integer.parseInt(args[i]);
                }

                //选择排序，比较出小的立即换位，再比较后面
                Integer temp;
                for (int i = 0; i < arrayList.length; i++){
                    for (int j = i + 1; j < arrayList.length; j++){
                        if (arrayList[i] > arrayList[j]){
                            temp = arrayList[j];
                            arrayList[j] = arrayList[i];
                            arrayList[i] = temp;
                        }
                    }
                }

                //选择排序优化版，比较出最小的再换位
                int k;
                Integer t;
                for (int i = 0;i < arrayList.length; i++){
                    k = i;
                    for (int j = k + 1; j < arrayList.length; j++){
                        if (arrayList[k] > arrayList[j]){
                            k = j;
                        }
                    }
                    if (k != i){
                        t = arrayList[i];
                        arrayList[i] = arrayList[k];
                        arrayList[k] = t;
                    }
                }

                //冒泡排序
            }else {
                System.out.println(args[0]);
            }
        }else {
            System.out.println("请输入正确的数组!");
            System.exit(-1);
        }
    }

    //二分法,针对已经排好序的数组,查询一个数字在数组中的位置
    public static int binarySearch(int[] a, int num){
        if (a.length == 0) return -1;
        int startPos = 0;
        int endPos = a.length - 1;
        int m = (startPos + endPos) / 2;
        while (startPos <= endPos){
            if (num == a[m]) return m;
            if (num > a[m]){
                startPos = m + 1;
            }
            if (num < a[m]){
                endPos = m - 1;
            }
            m = (startPos + endPos) / 2;
        }
        return -1;
    }
}
