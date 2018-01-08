package com.shsany.testapp.example.observer.eventmsg;

/**
 * Created by PC on 2017/12/4.
 */

public interface Observer {
    void updata(Object object); //同notify()的意义，当观察者接收到消息时执行的更新方法
}
