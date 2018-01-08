package com.shsany.testapp.example.observer.eventmsg;

import java.util.ArrayList;

/**
 * Created by PC on 2017/12/4.
 */

public class ConcreteObservableA implements Observable {
    private ArrayList<Observer> observers;
    @Override
    public void addObserver(Observer observer) {
        if (observers == null){
            observers = new ArrayList<>();
        }
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if (observers == null || observers.size() <= 0){
            return;
        }
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(Object obj) {
        if (observers == null || observers.size() <= 0){
            return;
        }
        for (Observer observer : observers){
            observer.updata(obj);
        }

    }
}
