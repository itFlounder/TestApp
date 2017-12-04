package com.shsany.testapp.base;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * Created by PC on 2017/11/9.
 */

public class MyApplication extends Application {
    private static Handler mHandler;
    private static Context mContext;
    private static Thread mMainThread;
    private static int mMainThreaId;

    public static boolean isDebug = true;
    public static String APP_NAME;

    public static Handler getmHandler() {
        return mHandler;
    }

    public static Context getmContext() {
        return mContext;
    }

    public static Thread getmMainThread() {
        return mMainThread;
    }

    public static int getmMainThreaId() {
        return mMainThreaId;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //获取handler,context,主线程，主线程id
        mHandler = new Handler();
        mContext = getApplicationContext();
        mMainThread = Thread.currentThread();

        mMainThreaId = android.os.Process.myTid();
    }
}
