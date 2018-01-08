package com.shsany.testapp.example.observer.eventmsg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.shsany.testapp.R;

/**
 * Created by PC on 2017/12/4.
 */

public class FirstActivity extends Activity implements Observer {

    private Button event;
    private TextView test;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_test);
        initView();
        EventCar.getInstance().register(this);
    }

    private void initView() {
        event = (Button) findViewById(R.id.bt_event);
        test = (TextView)findViewById(R.id.tv_test);
        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstActivity.this,ThirdActivity.class));
            }
        });
    }

    @Override
    public void updata(Object object) {
        if (!(object instanceof EventMsg)){
            return;
        }
        EventMsg eventMsg = (EventMsg)object;
        test.setText("message: " +eventMsg.getMsg() +"\n from: "+ eventMsg.getFrom());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventCar.getInstance().unregister(this);
    }
}
