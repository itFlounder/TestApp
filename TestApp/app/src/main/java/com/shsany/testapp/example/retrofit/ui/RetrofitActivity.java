package com.shsany.testapp.example.retrofit.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.shsany.testapp.R;

/**
 * Created by PC on 2018/1/8.
 */

public class RetrofitActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        int id = v.getId();
        switch (id) {
            case R.id.button:
                intent = new Intent(this, Teach1Activity.class);
                break;
            case R.id.button2:
                intent = new Intent(this, Teach2Activity.class);
                break;
            case R.id.button3:
                intent = new Intent(this, Teach3Activity.class);
                break;
            case R.id.button4:
                intent = new Intent(this, Teach4Activity.class);
                break;
        }
        startActivity(intent);
    }
}
