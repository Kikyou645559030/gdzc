package com.gdzc.study.heima.fileHandle;

import java.io.File;
import java.io.IOException;

/**
 * Created by Liu_Zhichao on 14-8-31.
 * 创建文件
 */
public class CreatFile {
    public static boolean createFile(String destFileName) {
        File file = new File(destFileName); // 根据指定的文件名创建File对象
        if (file.exists()) { // 判断该文件是否存在
            System.out.println("创建单个文件" + destFileName + "失败，目标文件已存在！");
            return false; // 如果存在，则不需创建则返回fasle
        }
        if (destFileName.endsWith(File.separator)) {// 如果传入的文件名是以文件分隔符结尾的，则说明此File对象是个目录而不是文件
            System.out.println("创建单个文件" + destFileName + "失败，目标文件不能为目录！");
            return false;// 因为不是文件所以不可能创建成功，则返回false
        }
        if (!file.getParentFile().exists()) {
            // 如果目标文件所在的文件夹不存在，则创建父文件夹
            System.out.println("创建" + file.getName() + "所在目录不存在，正在创建！");
            if (!file.getParentFile().mkdirs()) {// 判断父文件夹是否存在，如果存在则表示创建成功否则不成功
                System.out.println("创建目标文件所在的目录失败！");
                return false;
            }
        }
        // 创建目标文件
        try {
            if (file.createNewFile()) {// 调用createNewFile方法，判断创建指定文件是否成功
                System.out.println("创建单个文件" + destFileName + "成功！");
                return true;
            } else {
                System.out.println("创建单个文件" + destFileName + "失败！");
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("创建文件" + destFileName + "失败！" + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        // 创建目录
        String dirName = "D:/temp/aa";
        // 创建文件
        String fileName = dirName + "/bb/ccFile.txt";
        CreatFile.createFile(fileName);
    }
}
