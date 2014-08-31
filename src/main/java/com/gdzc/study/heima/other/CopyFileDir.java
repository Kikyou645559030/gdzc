package com.gdzc.study.heima.other;

import java.io.*;

/**
 * Created by Liu_Zhichao on 14-8-31.
 * 复制文件件及文件
 */
public class CopyFileDir {
    public static void main(String[] args){
        copyFile("F:\\Temp","D:\\Temp");
    }

    public static void copyFile(String filePath,String targetPath){
        File srcFile = new File(filePath);
        File tarFile = new File(targetPath);
        if (!srcFile.exists()){
            System.out.println("目录不存在");
            return;
        }
        if (!tarFile.exists()){
            tarFile.mkdirs();
            File[] files = srcFile.listFiles();
            for (File file : files){
                if (file.isDirectory()){
                    copyFile(file.getPath(),targetPath + File.separator +file.getName());
                }else if (file.isFile()){
                    try {
                        FileInputStream fis = new FileInputStream(file);
                        BufferedInputStream bis = new BufferedInputStream(fis);

                        FileOutputStream fos = new FileOutputStream(targetPath + File.separator + file.getName());
                        BufferedOutputStream bos = new BufferedOutputStream(fos);
//                        while (bis.read() != -1){
//                            bos.write(bis.read());
//                        }

                        byte[] bytes = new byte[1024];
                        int len;
                        while ((len = bis.read(bytes)) != -1){
                            bos.write(bytes,0,len);
                        }
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
        }
    }
}
