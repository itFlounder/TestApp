package com.shsany.testapp.Login.view;

/**
 * Created by PC on 2017/11/2.
 * Class Note:登陆View的接口，实现类也就是登陆的activity
 */

public interface LoginView {

    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToHome();

}
