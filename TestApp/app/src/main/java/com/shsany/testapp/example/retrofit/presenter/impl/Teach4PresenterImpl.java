package com.shsany.testapp.example.retrofit.presenter.impl;

import com.shsany.testapp.example.retrofit.bean.Book;
import com.shsany.testapp.example.retrofit.model.Teach4Model;
import com.shsany.testapp.example.retrofit.model.impl.Teach4ModelImpl;
import com.shsany.testapp.example.retrofit.presenter.Teach4Presenter;
import com.shsany.testapp.example.retrofit.view.ITeach4View;

import rx.Subscriber;

/**
 * Created by PC on 2018/1/8.
 */

public class Teach4PresenterImpl implements Teach4Presenter {
    private ITeach4View teach4View;
    private Teach4Model teach4Model;

    public Teach4PresenterImpl(ITeach4View teach4View) {
        this.teach4View = teach4View;
        teach4Model = new Teach4ModelImpl();
    }

    @Override
    public void queryIpInfo(String ip) {
        Subscriber<Book> mySubscriber = new Subscriber<Book>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                teach4View.showError(e);
            }

            @Override
            public void onNext(Book book) {
                teach4View.showIpInfo(book.getTotal());
            }
        };
        teach4Model.queryIpInfo(ip, mySubscriber);
    }
}
