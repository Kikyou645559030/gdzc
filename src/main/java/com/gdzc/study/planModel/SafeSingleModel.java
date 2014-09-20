package com.gdzc.study.planModel;

/**
 * Created by Liu_Zhichao on 14-9-20.
 */
public class SafeSingleModel {
    private SafeSingleModel(){}

    /**
     * 饿汉式单例模式，常用
     */
    private static SafeSingleModel safeSingleModel = new SafeSingleModel();
    public SafeSingleModel getSafeSingleModel(){
        return safeSingleModel;
    }

    /**
     * 懒汉式单例模式，延迟加载，不常用
     * 这样写才安全，且达到效率的最优化
     */
    /*private static SafeSingleModel safeSingleModel = null;
    public static SafeSingleModel getSafeSingleModel(){
        if (safeSingleModel == null){
            synchronized (SafeSingleModel.class){
                if (safeSingleModel == null){
                    safeSingleModel = new SafeSingleModel();
                }
            }
        }
        return safeSingleModel;
    }*/
}
