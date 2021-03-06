package com.shsany.testapp.example.retrofit.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.shsany.testapp.R;
import com.shsany.testapp.example.retrofit.api.APIService;
import com.shsany.testapp.example.retrofit.bean.SectionBean;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by PC on 2018/1/8.
 *
 * Retrofit结合RxJava进行数据请求，在Android开发中可使用RxAndroid
 */

public class Teach3Activity extends Activity implements View.OnClickListener {
    //IP地址
    private EditText mIpText;
    //请求的结果，IP信息
    private TextView mIpInfoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teach3);
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
                retrofitRxjava();
                break;
        }
    }

    /**
     * 使用RxJava获取数据，可以代替线程的开启，设置订阅者为主线程进行更新界面，如果对RxJava不熟悉的童鞋，建议先去学习再回来读本节教程
     */
    private void retrofitRxjava() {
        final String ip = mIpText.getText().toString();
        if (ip.length() == 0) {
            Toast.makeText(this, "请输入IP地址", Toast.LENGTH_SHORT).show();
            return;
        }
        String baseUrl = "http://192.168.0.159:8080";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // RxCallAdapter
                .build();
        APIService apiService = retrofit.create(APIService.class);
        Observable<SectionBean> myObservable = apiService.getInfo();
        myObservable.subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
                .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
                .subscribe(new Subscriber<SectionBean>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        String err = "很遗憾失败了，错误是：" + e.toString();
                        mIpInfoText.setText(err);
                    }

                    @Override
                    public void onNext(SectionBean sectionBean) {
                        String ipInfo = String.format("这里是结合RxJava获取的数据，IP是：%s，我在%s", sectionBean.getState(),sectionBean.getData().get(1).getBmmc());
                        mIpInfoText.setText(ipInfo);
                    }
                });
    }
}
