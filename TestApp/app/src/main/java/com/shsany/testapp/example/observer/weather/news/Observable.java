package com.shsany.testapp.example.observer.weather.news;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 2017/11/30.
 */

public class Observable<T> {
    List<Observer<T>> observers = new ArrayList<>();
    public void regsiter(Observer<T> observer){
        if (observer == null){
            throw new NullPointerException("observer is null");
        }
        synchronized (this){
            if (!observers.contains(observer)){
                observers.add(observer);
            }
        }
    }

    public synchronized void unregsiter(Observer<T> observer){
        observers.remove(observer);
    }

    public void notifyObserver(T data){
        for (Observer<T> observer : observers){
            observer.upData(this,data);
        }
    }
}
