package com.gdzc.study.heima.other;

import java.io.File;

/**
 * Created by Liu_Zhichao on 14-8-31.
 * 只复制文件件
 */
public class CopyDir {
    public static void main(String[] args)
    {
        String str1="E:\\remove";
        String str2="D:\\remove";
        copyFileDir(str1,str2);
    }
    public static void copyFileDir(String src,String des)
    {
        File srcFile=new File(src);
        File desFile=new File(des);

        if(!srcFile.exists())
            return;
        if(!desFile.exists())
            desFile.mkdirs();
        File[] files=srcFile.listFiles();
        for(File file:files)
        {
            if(file.isDirectory())
                copyFileDir(file.getPath(),des+ File.separator+file.getName());
        }
    }
}
