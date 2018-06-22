package com.applerao.medicine.utils;

import android.app.Application;

/**
 * Created by junxue.rao on 2016/2/15.
 * 创建全局应用实例方便使用
 */
public class AppContext extends Application{

    /**
     * 全局单例的application对象
     */
    private static AppContext instance;

    public static Application getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
