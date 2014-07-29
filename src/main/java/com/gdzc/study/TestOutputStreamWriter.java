package com.gdzc.study;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by Liu_Zhichao on 14-7-29.
 */
public class TestOutputStreamWriter {
    public static void main(String[] args){
        try {
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("D:\\b.txt"));//加上字符处理流
            osw.write("Writer by 刘志超");
            System.out.println(osw.getEncoding());
            osw = new OutputStreamWriter(new FileOutputStream("D:\\b.txt",true),"GB2312");//加上true表示在原内容后添加
            osw.write("----Writer by 幻想低调");
            System.out.println(osw.getEncoding());
            osw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
