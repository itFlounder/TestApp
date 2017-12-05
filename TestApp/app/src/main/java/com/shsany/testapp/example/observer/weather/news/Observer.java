package com.shsany.testapp.example.observer.weather.news;

/**
 * Created by PC on 2017/11/30.
 */

public interface Observer<T> {

    void upData(Observable<T> observable, T data);

    /*void upData(News news,T data);

    void upData(TestObserver observer, T data);*/

}
