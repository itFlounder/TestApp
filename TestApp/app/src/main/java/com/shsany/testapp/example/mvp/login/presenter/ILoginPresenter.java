package com.shsany.testapp.example.mvp.login.presenter;

/**
 * Created by PC on 2017/11/28.
 */

public interface ILoginPresenter {
    void verifyLogin(String userName,String password);
    void onDestory();
}
