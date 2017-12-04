package com.shsany.testapp.app;


import android.app.Application;

import java.util.concurrent.Executor;

/**
 * Created by PC on 2017/11/14.
 */

public class MyApplication extends Application {
    private ActivityManager activityManager = null ;//activity管理类
    private Executor executor = null; //线程池执行器
    public static String APPCONFIG = ""; //程序中用来缓存应用程序配置字段

    @Override
    public void onCreate() {
        super.onCreate();
        activityManager = ActivityManager.getInstance();
    }
}
