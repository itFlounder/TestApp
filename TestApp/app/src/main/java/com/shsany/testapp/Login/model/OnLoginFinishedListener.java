package com.shsany.testapp.Login.model;

/**
 * Created by PC on 2017/11/2.
 * Class Note:登陆事件监听
 */

public interface OnLoginFinishedListener {

    void onUserNameError();

    void onPasswordError();

    void onSuccess();
}
