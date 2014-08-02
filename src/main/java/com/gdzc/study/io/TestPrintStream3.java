package com.gdzc.study.io;


import java.io.*;
import java.util.Date;

/**
 * Created by Liu_Zhichao on 14-7-30.
 * 将输入的内容写入日志,并转换成大写显示在命令行
 */
public class TestPrintStream3 {
    public static void main(String[] args){
        System.out.println("----输入ESC退出!");
        String s = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            FileWriter fw = new FileWriter("D:\\d.log");
            PrintWriter log = new PrintWriter(fw);
            while ((s = br.readLine()) != null){
                if ("esc".equalsIgnoreCase(s)) break;
                System.out.println(s.toUpperCase());
                log.println("==================================");
                log.println(s);
                log.flush();
            }
            log.println("--------------"+new Date()+"--------------");
            log.flush();
            log.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
