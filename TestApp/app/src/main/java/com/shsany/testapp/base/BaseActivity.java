package com.shsany.testapp.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

/**
 * Created by PC on 2017/11/13.
 */

public abstract class BaseActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null){
            initParam(savedInstanceState);
        }else if (getIntent() != null && getIntent().getExtras() != null){
            initParam(getIntent().getExtras());
        }
    }

    /**
     * Activity之间都会传参，所以可以封装一个参数处理的函数initParam()，在BaseActivity的onCreate里去判断是否有参数传过来；
     * 这个方法不是必须重写的。
     * @param bundle
     */
    protected void initParam(Bundle bundle){

    }

    /**
     * 一般的Activity里都会用到很多的findViewById这个方法，而且每次都要强制类型转换，这样会显得很繁琐，如果在BaseActivity里封装好，就能省事
     * @param id
     * @param <T>
     * @return
     */
    protected <T extends View> T findView(int id){
        return (T)findViewById(id);
    }

    /**
     * 一般的Activity里都会需要初始化视图和数据
     */
    public abstract void initData();
    public abstract void initView();


    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        initView();
        initData();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        initView();
        initData();
    }

    /**
     * 一般会在Application类里去定义一个isDebug来判断是否开启调试（开发者模式）
     * 在BaseActivity里，我们可以把isDebug作为总开关，控制是否显示调试信息
     * 这样一键关闭调试，就不用去一个个删项目里的Log信息
     * @param msg
     */
    public void tLog(String msg){
        if (MyApplication.isDebug){
            Log.d(MyApplication.APP_NAME,msg);
        }
    }

    /**
     * 防止快速点击
     */
    private boolean fastClick(){
        long lastClick = 0;
        if (System.currentTimeMillis() - lastClick <= 1000){
            return false;
        }
        lastClick = System.currentTimeMillis();
        return true;
    }


}
