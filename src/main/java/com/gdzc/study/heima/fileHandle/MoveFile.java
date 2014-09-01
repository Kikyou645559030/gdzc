package com.gdzc.study.heima.fileHandle;

import java.io.File;

/**
 * Created by Liu_Zhichao on 14-8-31.
 * 移动文件夹，但不覆盖原有文件夹
 */
public class MoveFile {
    // 移动某个指定的文件，但移动成功后不会覆盖已存在的目标文件
    public static boolean moveA_File(String sourceFileName,
                                     String targetFileName) {
        return MoveFile.moveA_File(sourceFileName, targetFileName, false);
    }

    // 移动某个指定的文件，但移动成功后可以根据isOverlay的值来决定是否覆盖已存在的目标文件
    public static boolean moveA_File(String sourceFileName,
                                     String targetFileName, boolean isOverlay) {
        // 判断原文件是否存在
        File sourceFile = new File(sourceFileName);
        if (!sourceFile.exists()) {
            System.out.println("移动文件失败：原文件" + sourceFileName + "不存在！");
            return false;
        } else if (!sourceFile.isFile()) {
            System.out.println("移动文件失败：" + sourceFileName + "不是一个文件！");
            return false;
        }
        File targetFile = new File(targetFileName);
        if (targetFile.exists()) {// 判断目标文件是否存在
            if (isOverlay) {// 如果目标文件存在，是否允许覆盖目标文件
                // 删除已存在的目标文件，无论目标文件是目录还是单个文件
                System.out.println("该文件已存在，准备删除它！");
//                if (!Demo5.deleteAnyone(targetFileName)) {
//                    System.out.println("文件移动失败，删除文件" + targetFileName + "失败！");
//                    return false;
//                }
            } else {
                System.out.println("文件移动失败，文件" + targetFileName + "已存在！");
                return false;
            }
        } else {
            if (!targetFile.getParentFile().exists()) {
                // 如果目标文件所在的目录不存在，则创建目录
                System.out.println("该文件所在目录不存在，正在创建！");
                if (!targetFile.getParentFile().mkdirs()) {
                    System.out.println("移动文件失败，创建文件所在的目录失败！");
                    return false;
                }
            }
        }
        // 移动原文件至目标文件
        if (sourceFile.renameTo(targetFile)) {
            System.out.println("移动文件" + sourceFileName + "到" + targetFileName
                    + "成功！");
            return true;
        } else {
            System.out.println("移动文件" + sourceFileName + "到" + targetFileName
                    + "失败！");
            return true;
        }
    }

    public static boolean moveDir(String sourceDirName, String targetDirName) {
        // 默认为不覆盖目标文件
        return MoveFile.moveDir(sourceDirName, targetDirName, false);
    }

    // 移动某个指定的目录，但移动成功后可以根据isOverlay的值来决定是否覆盖当前已存在的目标目录
    public static boolean moveDir(String sourceDirName, String targetDirName,
                                  boolean isOverlay) {
        // 判断原目录是否存在
        File sourceDir = new File(sourceDirName);
        if (!sourceDir.exists()) {
            System.out.println("移动目录失败，原始目录" + sourceDirName + "不存在！");
            return false;
        } else if (!sourceDir.isDirectory()) {
            System.out.println("移动目录失败，" + sourceDirName + "不是一个目录！");
            return false;
        }
        // 如果目标文件夹名不以文件分隔符结尾，自动添加文件分隔符
        if (!targetDirName.endsWith(File.separator)) {
            targetDirName = targetDirName + File.separator;
        }
        File targetDir = new File(targetDirName);
        // 如果目标文件夹存在，
        if (targetDir.exists()) {
            if (isOverlay) {
                // 允许覆盖则删除已存在的目标目录
                System.out.println("该目录已存在，准备删除它！");
//                if (!Demo5.deleteAnyone(targetDirName)) {
//                    System.out.println("移动目录失败：删除目录" + targetDirName + "失败！");
//                }
            } else {
                System.out.println("移动目录失败：该目录" + targetDirName + "已存在！");
                return false;
            }
        } else {
            // 创建目标目录
            System.out.println("该目录不存在，正在创建！");
            if (!targetDir.mkdirs()) {
                System.out.println("移动目录失败：创建该目录失败！");
                return false;
            }
        }
        boolean flag = true;
        // 移动原目录下的文件和子目录到目标目录下
        File[] files = sourceDir.listFiles();
        for (int i = 0; i < files.length; i++) {
            // 移动子文件
            if (files[i].isFile()) {
                flag = MoveFile.moveA_File(files[i].getAbsolutePath(),
                        targetDirName + files[i].getName(), isOverlay);
                if (!flag) {
                    break;
                }
            }
            // 移动子目录
            else if (files[i].isDirectory()) {
                flag = MoveFile.moveDir(files[i].getAbsolutePath(), targetDirName
                        + files[i].getName(), isOverlay);
                if (!flag) {
                    break;
                }
            }
        }
        if (!flag) {
            System.out.println("目录" + sourceDirName + "移动到" + targetDirName
                    + "失败！");
            return false;
        }
        // 删除原目录
//        if (Demo5.deleteDir(sourceDirName)) {
//            System.out.println("目录" + sourceDirName + "移动到" + targetDirName
//                    + "成功！");
//            return true;
//        } else {
//            System.out.println("目录" + sourceDirName + "移动到" + targetDirName
//                    + "失败！");
            return false;
//        }
    }

    public static void main(String[] args) {
        // 移动文件，如果目标文件存在，则替换
        System.out.println("调用moveA_File方法的结果如下：");
        String sourceFileName = "D:\\temp\\keytoolcmd.txt";
        String targetFileName = "D:\\test\\temp\\keytoolcmd.txt.";
        MoveFile.moveA_File(sourceFileName, targetFileName, true);
        // 移动目录，如果目标目录存在，则不覆盖
        System.out.println("\n调用moveDir方法的结果如下：");
        String sourceDirName = "D:\\temp\\aa";
        String targetDirName = "F:\\abc";
        MoveFile.moveDir(sourceDirName, targetDirName);
    }
}
