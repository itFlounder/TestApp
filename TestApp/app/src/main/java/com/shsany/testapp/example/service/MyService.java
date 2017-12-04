package com.shsany.testapp.example.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by PC on 2017/11/14.
 * service的基础，2种启动方式以及对应关闭，
 * 前台service（例：系统状态栏一直显示当前天气的信息）
 * 远程Service以及对应优缺点（AIDL）
 *
 */

public class MyService extends Service {
    public static final String TAG ="MyService";

    private MyBinder myBinder = new MyBinder();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"onCreate executed");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"onStartCommand executed");
        /*//前台service
        // 在API11之后构建Notification的方式

        //获取一个Notification构造器
        Notification.Builder builder = new Notification.Builder(this.getApplicationContext());
        Intent nfIntent = new Intent(this, MainActivity.class);
        builder.setContentIntent(PendingIntent.getActivity(this, 0, nfIntent, 0)) // 设置PendingIntent
                .setLargeIcon(BitmapFactory.decodeResource(this.getResources(),R.drawable.icon2))// 设置下拉列表中的图标(大图标)
                .setContentTitle("下拉列表中的Title")// 设置下拉列表里的标题
                .setSmallIcon(R.mipmap.ic_launcher)// 设置状态栏内的小图标
                .setContentText("要显示的内容")// 设置上下文内容
                .setWhen(System.currentTimeMillis());// 设置该通知发生的时间

        Notification notification = builder.build(); // 获取构建好的Notification     build()最低要求在API16及以上版本上使用，低版本上可以使用.getNotification()
        notification.defaults = Notification.DEFAULT_SOUND; //设置为默认的声音
        // 参数一：唯一的通知标识；参数二：通知消息。
        startForeground(110, notification);// 开始前台服务*/
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        /*stopForeground(true);// 停止前台服务--参数：表示是否移除之前的通知*/
        Log.d(TAG,"onDestroy executed");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    class MyBinder extends Binder{
        public void startDownload(){
            Log.d(TAG,"startDounload executed");
        }
    }


}
