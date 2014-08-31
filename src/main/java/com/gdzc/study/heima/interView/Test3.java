package com.gdzc.study.heima.interview;

import java.io.*;

/**
 * Created by Liu_Zhichao on 14-8-31.
 * 把C盘里边的一个mp3文件拷贝到D盘里边，先写思路，然后写代码，最后写注释
 *先创建输入流，输出流，然后复制文件
 */
public class Test3 {
    public static void main(String[] args){
        copyFile("C:\\a.mp3","D:\\a.mp3");
    }

    public static void copyFile(String filePath, String target){
        try {
            //创建输入输出流
            FileInputStream fis = new FileInputStream(filePath);
            FileOutputStream fos = new FileOutputStream(target);
            //创建缓冲流
            BufferedInputStream bis = new BufferedInputStream(fis);
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            //读取文件
            while (bis.read() != -1){
                bos.write(bis.read());
            }
            //刷新流，关闭流
            bos.flush();
            bis.close();
            bos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
