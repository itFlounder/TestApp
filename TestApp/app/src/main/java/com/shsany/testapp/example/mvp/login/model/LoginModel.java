package com.shsany.testapp.example.mvp.login.model;

import android.os.Handler;
import android.text.TextUtils;

import com.shsany.testapp.example.mvp.login.bean.User;

/**
 * Created by PC on 2017/11/28.
 */

public class LoginModel implements ILoginModel {
    @Override
    public void Login(final String username, final String password, final OnLoginListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (TextUtils.isEmpty(username)){
                    listener.onUserNameIsEmpty();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    listener.onPasswordIsEmpty();
                    return;
                }
                if (username.equals(password)){
                    User user= new User();
                    user.setUserName(username);
                    user.setPassword(password);
                    listener.onLoginSuccess(user);
                }else {
                    listener.onLoginfailed();
                }
            }
        },2*1000);
    }
}
