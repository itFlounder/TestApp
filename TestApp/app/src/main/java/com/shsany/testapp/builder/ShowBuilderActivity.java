package com.shsany.testapp.builder;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.shsany.testapp.R;

/**
 * Created by PC on 2017/11/7.
 * Builder模式用例，可增加代码的可读性
 */

public class ShowBuilderActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showbuilder);
        Person.Builder builder = new Person.Builder();
        Person person = builder
                .name("伯兮")
                .age(16)
                .weight(55)
                .height(175)
                .builder();

    }
}
