package com.gdzc.study;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Liu_Zhichao on 14-7-18.
 */
public class TestFileInputStream {
    public static void main(String[] args){
        int a = 0;
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream("D:\\config.xml");
            fos = new FileOutputStream("D:\\a.xml");//如果文件不存在会自动创建一个空文件，但是不会自动创建不存在的目录
            while ((a=fis.read()) != -1){
                fos.write(a);
            }
            fis.close();
            fos.close();
        } catch(FileNotFoundException e){
            System.out.println("找不到指定的文件!");
            System.exit(-1);
        } catch(IOException ioe){
            System.out.println("文件复制错误!");
            System.exit(-1);
        }
        System.out.println("文件复制成功!");
    }
}
