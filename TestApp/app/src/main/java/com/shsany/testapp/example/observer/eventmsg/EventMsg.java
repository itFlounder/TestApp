package com.shsany.testapp.example.observer.eventmsg;

/**
 * Created by PC on 2017/12/4.
 */

public class EventMsg {
    private String msg;//事件发出的消息
    private String from;//哪里发出的事件

    public EventMsg(String msg , String from){
        this.msg = msg;
        this.from = from;
    }
    public String getMsg(){
        return msg;
    }

    public String getFrom(){
        return msg;
    }
}
