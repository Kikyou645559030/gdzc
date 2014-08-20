package com.gdzc.study.heima.basetest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 题目五：使用带缓冲功能的字节流复制文件。
 *
 * @author Liu_Zhichao
 */
public class Test5 {
    /**
     * 程序的入口
     * @param args
     */
    public static void main(String[] args){
        copyFile("D:\\config.xml","D:\\a.xml");
    }

    /**
     * 将指定文件复制到目标文件
     * @param filePath
     * @param targetPath
     */
    public static void copyFile(String filePath,String targetPath){
        try {
            //创建文件输入流，字节输入缓冲流
            FileInputStream fis = new FileInputStream(filePath);
            BufferedInputStream bis = new BufferedInputStream(fis);
            //创建文件输出流，字节输出缓冲流
            FileOutputStream fos = new FileOutputStream(targetPath);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            //开始读取文件
            while(bis.read() != -1){
                bos.write(bis.read());//写入读取出来的字节
            }
            //将缓冲区的字节输出到文件
            bos.flush();
            //关闭输入输出流
            bis.close();
            bos.close();
        } catch (FileNotFoundException e) {
            System.out.println("找不到指定的文件!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("文件复制错误!");
            e.printStackTrace();
        }
        System.out.println("文件复制成功!");
    }
}
