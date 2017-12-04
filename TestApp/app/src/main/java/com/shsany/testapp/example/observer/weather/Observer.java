package com.shsany.testapp.example.observer.weather;

/**
 * Created by PC on 2017/11/30.
 */

public interface Observer<T> {
    void onUpdata(Observable<T> observable,T data);
}
