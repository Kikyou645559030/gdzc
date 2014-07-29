package com.gdzc.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Liu_Zhichao on 14-7-29.
 * 标准输入流
 */
public class TestIO {
    public static void main(String[] args){
        System.out.println("输入ESC退出!");
        InputStreamReader isr = new InputStreamReader(System.in);//阻塞--等待输入
        BufferedReader br = new BufferedReader(isr);//三层管道,从里往外依次是(标准输入流,字符处理流,字符缓冲流)
        String s = null;
        try {
            s = br.readLine();
            while (s != null){
                if ("esc".equalsIgnoreCase(s)) break;
                    System.out.println(s);
                    s = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
