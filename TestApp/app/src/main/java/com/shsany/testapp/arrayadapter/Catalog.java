package com.shsany.testapp.arrayadapter;

import android.app.Activity;

/**
 * Created by PC on 2017/11/1.
 */

public class Catalog {
    //条目name
    private String mName;
    // 点击条目要跳转到的目标Activity的类型
    public Class <? extends Activity> mCls;

    public Catalog(String name, Class<? extends Activity> cls){
        this.mName = name;
        this.mCls = cls;
    }

    @Override
    public String toString() {
        return mName;
    }
}
