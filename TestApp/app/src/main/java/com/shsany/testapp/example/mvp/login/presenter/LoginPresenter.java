package com.shsany.testapp.example.mvp.login.presenter;

import com.shsany.testapp.example.mvp.login.bean.User;
import com.shsany.testapp.example.mvp.login.model.ILoginModel;
import com.shsany.testapp.example.mvp.login.model.LoginModel;
import com.shsany.testapp.example.mvp.login.model.OnLoginListener;
import com.shsany.testapp.example.mvp.login.view.ILoginView;

/**
 * Created by PC on 2017/11/28.
 */

public class LoginPresenter implements ILoginPresenter,OnLoginListener {
    private ILoginView loginView;
    private ILoginModel loginModel;

    public LoginPresenter(ILoginView loginView){
        this.loginView = loginView;
        this.loginModel = new LoginModel();
    }
    @Override
    public void verifyLogin(String userName,String password) {
        if (loginView != null){
            loginView.showProgressBar();
        }
        loginModel.Login(userName,password,this);
    }

    @Override
    public void onDestory() {
        loginView = null;
    }

    @Override
    public void onLoginSuccess(User user) {
        if (loginView != null){
            loginView.hideProgressBar();
            loginView.loginSuccess();
        }
    }

    @Override
    public void onLoginfailed() {
        if (loginView != null){
            loginView.hideProgressBar();
            loginView.loginFailed();
        }
    }

    @Override
    public void onUserNameIsEmpty() {
        if (loginView != null){
            loginView.hideProgressBar();
            loginView.userNameIsEmpty();
        }
    }

    @Override
    public void onPasswordIsEmpty() {
        if (loginView != null){
            loginView.hideProgressBar();
            loginView.passwordIsEmpty();
        }

    }
}
