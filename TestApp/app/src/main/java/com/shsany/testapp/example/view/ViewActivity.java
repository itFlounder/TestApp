package com.shsany.testapp.example.view;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.shsany.testapp.R;

/**
 * Created by PC on 2017/9/26.
 */

public class ViewActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.icon2);
        ImageView imageView = (ImageView) findViewById(R.id.iv_view_rid);
        imageView.setImageDrawable(new RoundImageDrawable(bitmap));
    }
}
