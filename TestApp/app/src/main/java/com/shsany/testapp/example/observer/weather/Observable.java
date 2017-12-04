package com.shsany.testapp.example.observer.weather;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 2017/11/30.
 * 被观察者（主题Subject）一般包括注册，取消注册，发送消息3个方法，
 * 注意：观察者（订阅者Subscriber）这可以是被观察者
 * 想要这个被观察者能够通用，将其定义成泛型
 * 内部应该暴露register和unregister方法供观察者订阅和取消订阅
 * 至于观察者的保存，直接用ArrayList即可
 * 当有主题内容发送改变时，会即时通知观察者做出反应，因此应该暴露一个notifyObservers方法
 */

public class Observable<T> {
    List<Observer<T>> mObservers = new ArrayList<>();

    public void register(Observer<T> observer){
        if (observer == null){
            throw new NullPointerException("observer == null");
        }
        synchronized (this){
            if (!mObservers.contains(observer)){
                mObservers.add(observer);
            }
        }
    }

    public synchronized void unRegister(Observer<T> observer){
        mObservers.remove(observer);
    }

    public void notifyObservers(T data){
        for (Observer<T> observer : mObservers){
            observer.onUpdata(this,data);
        }
    }

}
