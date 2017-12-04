package com.shsany.testapp.app;

import android.app.Activity;

import java.util.Stack;

/**
 * Created by PC on 2017/11/14.
 * activity管理类，防止activity跳转混乱
 */

public class ActivityManager {

    private static Stack<Activity> activityStack = null;//接收activity的stack
    private static ActivityManager activityManager = null;

    private ActivityManager(){}
    public static synchronized ActivityManager getInstance(){
        if (activityManager == null){
            synchronized (ActivityManager.class){
                if (activityManager == null){
                    activityManager = new ActivityManager();
                }
            }
        }
        return activityManager;
    }

    /**
     * 结束指定的activity
     * @param activity
     */
    public void endActivity(Activity activity){
        if (activity != null){
            activity.finish();
            activityStack.remove(activity);
            activity = null;
        }
    }

    /**
     * 结束所有的activity
     */
    public void endAllActivity(){
        while (!activityStack.empty()){
            Activity activity = currentActivity();
            endActivity(activity);
        }
    }

    /**
     * 结束出cls外的所有activity，执行结果情空atack
     * @param cls
     */
    public void endAllActivityExecptOne(Class<? extends Activity> cls){
        while (!activityStack.empty()){
            Activity activity = currentActivity();
            if (activity.getClass().equals(cls)){
                popActivity(activity);
            }else {
                endActivity(activity);
            }
        }
    }

    /**
     * 获取当前（最上层）activity
     * @return
     */
    public Activity currentActivity(){
        Activity activity = null;
        if (!activityStack.empty()){
            activity = activityStack.lastElement();
        }
        return activity;
    }

    /**
     * 将activity推入栈
     * @param activity
     */
    public void pushActivity(Activity activity){
        if (activityStack == null){
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);
    }

    /**
     * 将activity移出栈
     * @param activity
     */
    public void popActivity(Activity activity){
        if (activity != null){
            activityStack.remove(activity);
        }
    }

    /**
     * 移出栈中出cls外的所有activity
     * @param cls
     */
    public void popAllActivityExceptOne(Class<? extends Activity> cls){
        while (true){
            Activity activity = currentActivity();
            if (activity == null){
                break;
            }
            if (activity.getClass().equals(cls)){
                break;
            }
            popActivity(activity);
        }
    }
}
