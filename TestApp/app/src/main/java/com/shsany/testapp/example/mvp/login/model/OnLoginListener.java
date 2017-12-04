package com.shsany.testapp.example.mvp.login.model;

import com.shsany.testapp.example.mvp.login.bean.User;

/**
 * Created by PC on 2017/11/28.
 */

public interface OnLoginListener {

    void onLoginSuccess(User user);

    void onLoginfailed();

    void onUserNameIsEmpty();

    void onPasswordIsEmpty();

}
