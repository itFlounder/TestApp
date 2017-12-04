package com.shsany.testapp.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;

/**
 * Created by PC on 2017/11/9.
 */

public class UIUtils {
    public static Context getContext(){
        return MyApplication.getmContext();
    }

    public static Handler getHandler(){
        return MyApplication.getmHandler();
    }

    public static Thread getMainThread(){
        return MyApplication.getmMainThread();
    }

    public static int getMainThreadId(){
        return MyApplication.getmMainThreaId();
    }

    /**
     *
     * @param layoutId 布局id
     * @return 参数指向的布局转换成的view对象
     */
    public static View inflate(int layoutId){
        return View.inflate(getContext(),layoutId,null);
    }

    public static Resources getResources(){
        return getContext().getResources();
    }

    public static Drawable getDrawable(int drawableId){
        return getResources().getDrawable(drawableId);
    }

    public static String getString(int stringId){
        return getResources().getString(stringId);
    }

    /**
     *
     * @param stringArrayId 传递在xml中定义的字符串数组的id
     * @return 通过id获取到的字符串数组
     */
    public static String[] getStringArray(int stringArrayId){
        return getResources().getStringArray(stringArrayId);
    }

    /**
     *将任务放置到主线程中运行
     * @param runnable
     */
    public static void runInMainThread(Runnable runnable){
        if (getMainThreadId() == android.os.Process.myTid()){//在主线程，直接运行
            runnable.run();
        }else {
            //确保传递进来的任务再主线程运行
            getHandler().post(runnable);//将任务传递到主线程的消息队列中，让其运行
        }
    }
}
