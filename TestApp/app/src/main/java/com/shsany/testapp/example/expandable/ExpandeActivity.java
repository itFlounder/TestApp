package com.shsany.testapp.example.expandable;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ExpandableListView;

import com.shsany.testapp.R;
import com.shsany.testapp.Utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 2018/1/5.
 */

public class ExpandeActivity extends Activity {

    private List<String> mGroup = null;
    private List<String> mChild = null;
    private ExpandableListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expande);

        listView = (ExpandableListView)findViewById(R.id.elv_list);

        setData();
        MyExpandeAdapter myExpandeAdapter = new MyExpandeAdapter(this,mGroup,mChild);
        listView.setAdapter(myExpandeAdapter);
        setListeners();
    }

    public void setData(){
        mGroup = new ArrayList<>();
        mChild = new ArrayList<>();
        for (int i = 0 ;i <1;i++){
            mGroup.add("item"+i);
        }
        for (int i = 0;i<10;i++){
            mChild.add("childItem"+i);
        }

    }

    private void setListeners(){
        //分组展开
        listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                ToastUtils.show(getApplication(),"分组展开",3*1000);
                return true;
            }
        });
        //分组关闭
        listView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                ToastUtils.show(getApplication(),"分组关闭",3*1000);

            }
        });
        //点击子项
        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                ToastUtils.show(getApplication(),"点击子item",3*1000);
                return false;
            }
        });
    }

}
