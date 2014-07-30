package com.gdzc.study;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Created by Liu_Zhichao on 14-7-30.
 * 打印输出流
 */
public class TestPrintStream {
    public static void main(String[] args){
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream("D:\\c.log");
            ps = new PrintStream(fos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (ps != null){
            System.setOut(ps);//设置out的输出流
        }
        int ln = 0;
        for (char c = 0;c <= 60000;c++){
            System.out.print(c+"");
            if (ln == 100){
                System.out.println();
                ln = 0;
            }
        }
    }
}
