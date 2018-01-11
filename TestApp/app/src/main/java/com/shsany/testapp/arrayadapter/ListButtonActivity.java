package com.shsany.testapp.arrayadapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.shsany.testapp.DownLoad.LoadActivity;
import com.shsany.testapp.Login.LoginActivity;
import com.shsany.testapp.R;
import com.shsany.testapp.activity.ListviewActivity;
import com.shsany.testapp.contacts.ContactsActivity;
import com.shsany.testapp.example.Tab.TraditionalActivity;
import com.shsany.testapp.example.expandable.ExpanActivity;
import com.shsany.testapp.example.expandable.ExpandeActivity;
import com.shsany.testapp.example.fish.FishActivity;
import com.shsany.testapp.example.mvx.mvc.controllers.ChatController;
import com.shsany.testapp.example.mvx.mvc.controllers.LoginController;
import com.shsany.testapp.example.observer.eventmsg.FirstActivity;
import com.shsany.testapp.example.observer.eventmsg.ThirdActivity;
import com.shsany.testapp.example.retrofit.ui.RetrofitActivity;
import com.shsany.testapp.example.retrofit.ui.Teach1Activity;
import com.shsany.testapp.example.retrofit.ui.Teach2Activity;
import com.shsany.testapp.example.retrofit.ui.Teach3Activity;
import com.shsany.testapp.example.retrofit.ui.Teach4Activity;
import com.shsany.testapp.example.service.ServiceTestActivity;
import com.shsany.testapp.example.view.CustomStateActivity;
import com.shsany.testapp.example.view.ViewActivity;
import com.shsany.testapp.mvvm.view.MvvmTestActivity;

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
        catalogList.add(new Catalog("ListviewActivity", ListviewActivity.class));
        catalogList.add(new Catalog("TraditionalActivity", TraditionalActivity.class));
        catalogList.add(new Catalog("LoadActivity", LoadActivity.class));
        catalogList.add(new Catalog("FishActivity", FishActivity.class));
        catalogList.add(new Catalog("ViewActivity", ViewActivity.class));
        catalogList.add(new Catalog("ContactsActivity", ContactsActivity.class));
        catalogList.add(new Catalog("CustomStateActivity", CustomStateActivity.class));
        catalogList.add(new Catalog("LoginActivity", LoginActivity.class));
        catalogList.add(new Catalog("MvvmTestActivity", MvvmTestActivity.class));
        catalogList.add(new Catalog("ServiceTestActivity", ServiceTestActivity.class));
        catalogList.add(new Catalog("mvp.login.LoginActivity", com.shsany.testapp.example.mvp.login.LoginActivity.class));
        catalogList.add(new Catalog("FirstActivity", FirstActivity.class));
        catalogList.add(new Catalog("ThirdActivity", ThirdActivity.class));
        catalogList.add(new Catalog("ChatController", ChatController.class));
        catalogList.add(new Catalog("LoginController", LoginController.class));
        catalogList.add(new Catalog("ExpandeActivity", ExpandeActivity.class));
        catalogList.add(new Catalog("ExpanActivity", ExpanActivity.class));
        catalogList.add(new Catalog("Teach1Activity", Teach1Activity.class));
        catalogList.add(new Catalog("Teach2Activity", Teach2Activity.class));
        catalogList.add(new Catalog("Teach3Activity", Teach3Activity.class));
        catalogList.add(new Catalog("Teach4Activity", Teach4Activity.class));
        catalogList.add(new Catalog("RetrofitActivity", RetrofitActivity.class));

        catalogList.add(new Catalog("LoginController", LoginController.class));
        catalogList.add(new Catalog("LoginController", LoginController.class));
        catalogList.add(new Catalog("LoginController", LoginController.class));
        catalogList.add(new Catalog("LoginController", LoginController.class));
        catalogList.add(new Catalog("LoginController", LoginController.class));
        catalogList.add(new Catalog("LoginController", LoginController.class));
        catalogList.add(new Catalog("LoginController", LoginController.class));
        catalogList.add(new Catalog("LoginController", LoginController.class));
        catalogList.add(new Catalog("LoginController", LoginController.class));
        catalogList.add(new Catalog("LoginController", LoginController.class));
        catalogList.add(new Catalog("LoginController", LoginController.class));
        catalogList.add(new Catalog("LoginController", LoginController.class));
        catalogList.add(new Catalog("LoginController", LoginController.class));
        catalogList.add(new Catalog("LoginController", LoginController.class));
        catalogList.add(new Catalog("LoginController", LoginController.class));
        catalogList.add(new Catalog("LoginController", LoginController.class));
        catalogList.add(new Catalog("LoginController", LoginController.class));
        catalogList.add(new Catalog("LoginController", LoginController.class));
        catalogList.add(new Catalog("LoginController", LoginController.class));
        catalogList.add(new Catalog("LoginController", LoginController.class));
        catalogList.add(new Catalog("LoginController", LoginController.class));
        catalogList.add(new Catalog("LoginController", LoginController.class));




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
