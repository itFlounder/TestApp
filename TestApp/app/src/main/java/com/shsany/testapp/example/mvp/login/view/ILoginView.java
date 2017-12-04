package com.shsany.testapp.example.mvp.login.view;

/**
 * Created by PC on 2017/11/28.
 */

public interface ILoginView {

    void showProgressBar();

    void hideProgressBar();

    void loginSuccess();

    void loginFailed();

    void userNameIsEmpty();

    void passwordIsEmpty();

}
