package com.shsany.testapp.mvvm.view;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.shsany.testapp.R;
import com.shsany.testapp.databinding.ActivityMvvmTestBinding;
import com.shsany.testapp.mvvm.bean.User;

/**
 * Created by PC on 2017/11/7.
 */

public class MvvmTestActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMvvmTestBinding activityMvvmTestBinding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm_test);
        User user = new User();
        user.setUsername("乌托邦");
        user.setPassword("2001");
        activityMvvmTestBinding.setUser(user);

    }
}
