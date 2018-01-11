package com.shsany.testapp.example.retrofit.model;

import com.shsany.testapp.example.retrofit.bean.Book;

import rx.Subscriber;

/**
 * Created by PC on 2018/1/8.
 *
 * IP查询操作接口
 */

public interface Teach4Model {
    /**
     * 查询IP信息
     *
     * @param ip ip地址
     */
    public void queryIpInfo(String ip, Subscriber<Book> subscriber);
}
