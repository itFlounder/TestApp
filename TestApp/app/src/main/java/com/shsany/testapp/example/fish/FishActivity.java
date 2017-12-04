package com.shsany.testapp.example.fish;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.shsany.testapp.R;

/**
 * Created by PC on 2017/9/22.
 * 自绘制一条红鲤鱼，随手指点击而移动
 */

public class FishActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish);
    }
}
