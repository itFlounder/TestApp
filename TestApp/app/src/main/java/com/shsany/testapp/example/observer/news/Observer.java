package com.shsany.testapp.example.observer.news;

/**
 * Created by PC on 2017/11/30.
 */

public interface Observer<T> {
    void upData(Observable<T> observable, T data);
}
