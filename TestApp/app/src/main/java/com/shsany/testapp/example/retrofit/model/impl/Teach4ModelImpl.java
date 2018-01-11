package com.shsany.testapp.example.retrofit.model.impl;

import com.shsany.testapp.example.retrofit.api.APIService;
import com.shsany.testapp.example.retrofit.bean.Book;
import com.shsany.testapp.example.retrofit.model.Teach4Model;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by PC on 2018/1/8.
 */

public class Teach4ModelImpl implements Teach4Model{
    @Override
    public void queryIpInfo(final String ip, Subscriber<Book> subscriber) {
        String baseUrl = "https://api.douban.com/v2/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // RxCallAdapter
                .build();
        APIService apiService = retrofit.create(APIService.class);
        Observable<Book> myObservable = apiService.getIpInfo3("金瓶梅",null, 0, 1);
        myObservable.subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
                .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
                .subscribe(subscriber);
    }
}
