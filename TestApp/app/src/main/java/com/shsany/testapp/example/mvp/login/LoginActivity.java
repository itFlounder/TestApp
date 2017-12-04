package com.shsany.testapp.example.mvp.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.shsany.testapp.R;
import com.shsany.testapp.Utils.ToastUtils;
import com.shsany.testapp.activity.MainActivity;
import com.shsany.testapp.example.mvp.login.presenter.ILoginPresenter;
import com.shsany.testapp.example.mvp.login.presenter.LoginPresenter;
import com.shsany.testapp.example.mvp.login.view.ILoginView;

/**
 * Created by PC on 2017/11/28.
 */

public class LoginActivity extends Activity implements ILoginView {

    private EditText userName;
    private EditText password;
    private Button login;
    private ProgressBar progress;
    private ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        userName = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        login = (Button)findViewById(R.id.button);
        progress = (ProgressBar)findViewById(R.id.progress);

        loginPresenter = new LoginPresenter(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.verifyLogin(userName.getText().toString(),password.getText().toString());
            }
        });

    }

    @Override
    public void showProgressBar() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progress.setVisibility(View.GONE);
    }

    @Override
    public void loginSuccess() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
        ToastUtils.show(this,"login successed",3*1000);
    }

    @Override
    public void loginFailed() {
        ToastUtils.show(this,"login failed",3*1000);
    }

    @Override
    public void userNameIsEmpty() {
        ToastUtils.show(this,"username not be empty",3*1000);
    }

    @Override
    public void passwordIsEmpty() {
        ToastUtils.show(this,"password not be empty",3*1000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.onDestory();
    }
}
