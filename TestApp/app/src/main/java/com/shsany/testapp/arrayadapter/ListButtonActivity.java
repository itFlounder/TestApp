package com.shsany.testapp.arrayadapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.shsany.testapp.Login.LoginActivity;
import com.shsany.testapp.R;
import com.shsany.testapp.example.Tab.TraditionalActivity;
import com.shsany.testapp.example.view.CustomStateActivity;
import com.shsany.testapp.example.view.ViewActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 2017/11/1.
 */

public class ListButtonActivity extends Activity {

    private ListView lv;
    private List<Catalog> catalogList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        initView();
    }

    private void initView() {
        lv = (ListView)findViewById(R.id.lv_listview);
        catalogList = new ArrayList<Catalog>();
        catalogList.add(new Catalog("按钮1", ViewActivity.class));
        catalogList.add(new Catalog("按钮2", CustomStateActivity.class));
        catalogList.add(new Catalog("按钮3", LoginActivity.class));
        catalogList.add(new Catalog("按钮4", TraditionalActivity.class));
        catalogList.add(new Catalog("按钮5", com.shsany.testapp.example.mvp.login.LoginActivity.class));
        catalogList.add(new Catalog("按钮6", ViewActivity.class));
        catalogList.add(new Catalog("按钮7", ViewActivity.class));

        // 这里ListView的适配器选用ArrayAdapter，ListView中每一项的布局选用系统的simple_list_item_1
        ArrayAdapter<Catalog> adapter = new ArrayAdapter<Catalog>(this,android.R.layout.simple_list_item_1,catalogList);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(ListButtonActivity.this,catalogList.get(position).mCls));
            }
        });
    }

}
