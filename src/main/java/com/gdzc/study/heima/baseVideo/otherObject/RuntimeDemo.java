package com.gdzc.study.heima.baseVideo.otherObject;

import java.io.IOException;

/**
 * -Runtime类
 * Created by Liu_Zhichao on 14-10-5.
 */
public class RuntimeDemo {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("G:\\YY.exe");//执行所有的exe程序的方法
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
