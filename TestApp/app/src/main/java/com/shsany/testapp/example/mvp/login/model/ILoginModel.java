package com.shsany.testapp.example.mvp.login.model;

/**
 * Created by PC on 2017/11/28.
 */

public interface ILoginModel {
    void Login(String username,String password,OnLoginListener listener);
}
