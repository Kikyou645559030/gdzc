package com.gdzc.study.io;

import java.io.*;

/**
 * Created by Liu_Zhichao on 14-7-28.
 * 字符输入输出缓冲流
 */
public class TestBufferedStream {
    public static void main(String[] args){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\a.txt"));//缓冲流
            BufferedReader br = new BufferedReader(new FileReader("D:\\a.txt"));
            String s = null;
            for (int i = 0;i < 100;i++){
                s = String.valueOf(Math.random());
                bw.write(s);
                bw.newLine();//换行
            }
            bw.flush();
            while ((s = br.readLine()) != null){
                System.out.println(s);
            }
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis = new FileInputStream("D:\\config.xml");
            BufferedInputStream bis = new BufferedInputStream(fis);
            int c = 0;
            System.out.println(bis.read());
            System.out.println(bis.read());
            bis.mark(100);
            for (int i = 0;i < 10 && (bis.read() != -1);i++){
                System.out.print((char)c+" ");
            }
            System.out.println();
            bis.reset();
            for (int i = 0;i < 10 && (bis.read() != -1);i++){
                System.out.print((char)c+" ");
            }
            bis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
