package com.gdzc.study.heima.note;

import java.io.*;

/**
 * Created by Liu_Zhichao on 14-8-29.
 * 自定义类加载器、对class加密和解密
 */
public class MyClassLoader extends ClassLoader{
    public static void main(String[] args){
        try {
            FileInputStream fis = new FileInputStream("E:\\workspace for IDEA\\gdzc\\target\\classes\\com\\gdzc\\study\\heima\\note\\ClassLoaderAttachment.class");
            FileOutputStream fos = new FileOutputStream("src/main/resources/ClassLoaderAttachment.class");
            cypher(fis,fos);
            fis.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    对读取出来的文件进行加密
     */
    private static void cypher(InputStream is,OutputStream os){
        int b = -1;
        try {
            while ((b = is.read()) != -1){
                os.write(b ^ 0xff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) {
        String classFileName = "src/main/resources/" + name + ".class";
        try {
            FileInputStream fis = new FileInputStream(classFileName);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            cypher(fis,bos);
            fis.close();
            System.out.println();
            byte[] bytes = bos.toByteArray();
            return defineClass(bytes,0,bytes.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
            return null;
    }
}
