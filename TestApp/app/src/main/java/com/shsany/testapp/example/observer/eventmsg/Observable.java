package com.shsany.testapp.example.observer.eventmsg;

/**
 * Created by PC on 2017/12/4.
 */

public interface Observable {

    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver(Object obj);

}
