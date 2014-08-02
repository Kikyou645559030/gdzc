package com.gdzc.study.io;

import java.io.*;

/**
 * Created by Liu_Zhichao on 14-7-29.
 * 数据输入流测试
 */
public class TestDataStream {
    public static void main(String[] args){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        try {
            dos.writeDouble(Math.random());
            dos.writeBoolean(true);
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            System.out.println(bais.available());//有效的,能读取出来的字节数
            DataInputStream dis = new DataInputStream(bais);
            System.out.println(dis.readDouble());
            System.out.println(dis.readBoolean());
            dos.close();
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
