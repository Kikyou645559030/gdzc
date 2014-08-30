package com.gdzc.study.heima.other;

import java.io.File;

/**
 * Created by Liu_Zhichao on 14-8-30.
 * 修改文件后缀名
 */
public class ReviseFileName {
        public static void main(String[] args) {
            File f1 = new File("d:\\");
            moveFile(f1);
        }

        public static void moveFile(File dir) {
            File[] files = dir.listFiles();
            for (File file : files) {
                if (file.isDirectory())
                    moveFile(file);
                else {
                    if (file.getName().endsWith(".java"))
                        file.renameTo(new File("c:\\jad\\"
                                + file.getName().substring(0,
                                file.getName().lastIndexOf('.')) + ".jad"));
                }
            }
        }
}
