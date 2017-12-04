package com.shsany.testapp.Login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.shsany.testapp.Login.presenter.LoginPresenter;
import com.shsany.testapp.Login.presenter.LoginPresenterImpl;
import com.shsany.testapp.Login.view.LoginView;
import com.shsany.testapp.R;
import com.shsany.testapp.activity.MainActivity;

/**
 * Created by PC on 2017/11/2.
 * Class Note:MVP模式中View层对应一个activity，这里是登陆的activity
 * demo的代码流程：Activity做了一些UI初始化的东西并需要实例化对应
 * LoginPresenter的引用和实现 LoginView的接口，监听界面动作，
 * Go按钮按下后即接收到查询天气的事件，在onClick里接收到即通过LoginPresenter
 * 的引用把它交给LoginPresenter处理。LoginPresenter接收到了登陆的逻辑就知道要登陆了，
 * 然后LoginPresenter显示进度条并且把逻辑交给我们的Model去处理，也就是这里面的LoginModel，
 * （LoginModel的实现类LoginModelImpl），同时会把OnLoginFinishedListener也就是LoginPresenter
 * 自身传递给我们的Model（LoginModel）。LoginModel处理完逻辑之后，结果通过
 * OnLoginFinishedListener回调通知LoginPresenter，LoginPresenter再把结果返回给view层的Activity，
 * 最后activity显示结果
 */

public class LoginActivity extends Activity implements LoginView,View.OnClickListener {

    private ProgressBar progressbar;
    private EditText username;
    private EditText password;
    private Button button;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init() {
        progressbar = (ProgressBar)findViewById(R.id.progress);
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(this);

        presenter = new LoginPresenterImpl(this);
    }

    @Override
    protected void onDestroy() {
        presenter.onDestory();
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        presenter.validateCredentials(username.getText().toString(),password.getText().toString());
    }

    @Override
    public void showProgress() {
        progressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressbar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        username.setError("Username not be empty");
    }

    @Override
    public void setPasswordError() {
        password.setError("Passwor not be empty");
    }

    @Override
    public void navigateToHome() {
        Toast.makeText(this,"login success",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }
}
