package com.shsany.testapp.example.observer.eventmsg;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.shsany.testapp.R;

/**
 * Created by PC on 2017/12/5.
 */

public class ThirdActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_contact);
        initView();
    }

    private void initView() {
        Button button = (Button)findViewById(R.id.bt_third);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventCar.getInstance().post(new EventMsg("as long as you love me",String.valueOf(getClass().getName())));
            }
        });
    }

}
