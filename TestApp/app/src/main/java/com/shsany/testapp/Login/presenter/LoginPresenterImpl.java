package com.shsany.testapp.Login.presenter;

import com.shsany.testapp.Login.model.LoginModel;
import com.shsany.testapp.Login.model.LoginModelImpl;
import com.shsany.testapp.Login.model.OnLoginFinishedListener;
import com.shsany.testapp.Login.view.LoginView;

/**
 * Created by PC on 2017/11/2.
 * Class Note:
 * 1 完成presenter的实现。这里面主要是Model层和View层的交互和操作。
 * 2  presenter里面还有个OnLoginFinishedListener，
 * 其在Presenter层实现，给Model层回调，更改View层的状态，确保 Model层不直接操作View层。
 * 如果这一接口(OnLoginFinishedListener)没有在LoginPresenterImpl实现的话，
 * LoginPresenterImpl只有View和Model的引用,那么Model怎么把结果告诉View呢？
 */

public class LoginPresenterImpl implements LoginPresenter,OnLoginFinishedListener {
    private LoginView mLoginView;
    private LoginModel mLoginModel;

    public LoginPresenterImpl(LoginView loginView){
        this.mLoginView = loginView;
        this.mLoginModel = new LoginModelImpl();
    }

    @Override
    public void onUserNameError() {
        if (mLoginView != null){
            mLoginView.setUsernameError();
            mLoginView.hideProgress();
        }

    }

    @Override
    public void onPasswordError() {
        if (mLoginView != null){
            mLoginView.setPasswordError();
            mLoginView.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if (mLoginView != null){
            mLoginView.navigateToHome();
        }
    }

    @Override
    public void validateCredentials(String username, String password) {
        if (mLoginView != null){
            mLoginView.showProgress();
        }
        mLoginModel.login(username,password,this);
    }

    @Override
    public void onDestory() {
        mLoginView = null;
    }
}
