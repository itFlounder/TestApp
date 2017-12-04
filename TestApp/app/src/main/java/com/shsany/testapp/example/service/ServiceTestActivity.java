package com.shsany.testapp.example.service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by PC on 2017/11/15.
 */

public class ServiceTestActivity extends Activity {

    private ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.MyBinder myBinder = (MyService.MyBinder) service;
            myBinder.startDownload();
        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*//开启服务
        Intent startIntent = new Intent(this,MyService.class);
        startService(startIntent);*/


        /*//停止服务
        Intent stopIntent = new Intent(this,MyService.class);
        stopService(stopIntent);*/


        //绑定服务
        Intent bindIntent = new Intent(this,MyService.class);
        // 第一个参数就是刚刚构建出的Intent对象，第二个参数是前面创建出的ServiceConnection的实例，
        // 第三个参数是一个标志位，这里传入BIND_AUTO_CREATE表示在Activity和Service建立关联后自动创建Service，
        // 这会使得MyService中的onCreate()方法得到执行，但onStartCommand()方法不会执行
        bindService(bindIntent,connection,BIND_AUTO_CREATE);


        //解绑服务
        unbindService(connection);
    }
}
