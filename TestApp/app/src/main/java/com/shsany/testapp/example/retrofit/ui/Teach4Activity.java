package com.shsany.testapp.example.retrofit.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.shsany.testapp.R;
import com.shsany.testapp.example.retrofit.presenter.Teach4Presenter;
import com.shsany.testapp.example.retrofit.presenter.impl.Teach4PresenterImpl;
import com.shsany.testapp.example.retrofit.view.ITeach4View;

/**
 * Created by PC on 2018/1/8.
 *
 * 使用MVP开发模式，结合RxJava进行实现数据获取到界面显示的过程
 */

public class Teach4Activity extends Activity implements View.OnClickListener,ITeach4View {
    private Teach4Presenter presenter;

    //IP地址
    private EditText mIpText;
    //请求的结果，IP信息
    private TextView mIpInfoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teach4);
        presenter = new Teach4PresenterImpl(this);
        initView();
    }

    /**
     * 初始化视图
     */
    private void initView() {
        mIpText = (EditText) findViewById(R.id.text_ip);
        mIpInfoText = (TextView) findViewById(R.id.text_ip_info);
        findViewById(R.id.button_query_execute).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.button_query_execute:
                String ip = mIpText.getText().toString();
                if (ip.length() == 0) {
                    Toast.makeText(this, "请输入IP地址", Toast.LENGTH_SHORT).show();
                    return;
                }
                presenter.queryIpInfo(ip);
                break;
        }
    }


    @Override
    public void showIpInfo(int total) {
        String ipInfo = String.format("这里是用MVP模式结合RxJava获取的数据，total是：%s", total);
        mIpInfoText.setText(ipInfo);
    }

    @Override
    public void showError(Throwable e) {
        String err = "很遗憾失败了，错误是：" + e.toString();
        mIpInfoText.setText(err);
    }
}
