package com.gdzc.study;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Liu_Zhichao on 14-7-18.
 */
public class TestFileReader {
    public static void main(String[] args){
        FileReader fr = null;
        int a = 0;
        try {
            fr = new FileReader("D:\\config.xml");
            int ln = 0;
            while ((a = fr.read()) != -1){
//                char ch = (char) fr.read();
                System.out.print((char) a);
                /*if (++ln >= 100){
                    System.out.println();
                    ln = 0
                }*/
            }
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("找不到指定文件!");
            e.printStackTrace();
        } catch (IOException e){
            System.out.println("文件读取错误!");
            e.printStackTrace();
        }
    }
}
