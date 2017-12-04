package com.shsany.testapp.contacts;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.shsany.testapp.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by PC on 2017/10/13.
 */

public class ContactsActivity extends Activity {

    private MikyouLetterListView mikyouLetterListView;
    private TextView initial;
    private ListView contactListView;
    private List<PersonBean> sourceDateList;
    private MyAdapter myAdapter;
    private EditTextDel serch;
    private Handler handler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        initViews();
    }
    private void initViews(){
        serch = (EditTextDel)findViewById(R.id.et_serch);
        mikyouLetterListView = (MikyouLetterListView)findViewById(R.id.mllv_contact);
        initial = (TextView)findViewById(R.id.tv_tips);
        contactListView = (ListView)findViewById(R.id.lv_contact);
        initEvents();
        setAdapter();

    }

    /**
     * 设置显示当前按下的字母的TextView
     * @param words
     */
    private void initDatas(String words){
        handler = new Handler();
        initial.setText(words);
        initial.setVisibility(View.VISIBLE);
        handler.removeCallbacksAndMessages(null);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                initial.setVisibility(View.GONE);
            }
        },2000);

//        mikyouLetterListView.setTextView(initial);
    }
    private void setAdapter(){
        sourceDateList = filledData(getResources().getStringArray(R.array.contacts));
        Collections.sort(sourceDateList,new PinYinComparator());
        myAdapter = new MyAdapter(this,sourceDateList);
        contactListView.setAdapter(myAdapter);


    }
    private List<PersonBean> filledData(String[] data){
        List<PersonBean> personBeens = new ArrayList<>();
        ArrayList<String > indexString = new ArrayList<>();
        for (int i = 0; i < data.length;i++){
            PersonBean personBean = new PersonBean();
            personBean.setPerson(data[i]);
            String pinyin = PinYinUtils.getPinYin(data[i]);
            String sortString = pinyin.substring(0,1).toUpperCase();
            if (sortString.matches("[A-Z]")){
                personBean.setInitial(sortString.toUpperCase());
                if (!indexString.contains(sortString)){
                    indexString.add(sortString);
                }
            }
            personBeens.add(personBean);
        }
        Collections.sort(indexString);
//        mikyouLetterListView.setIndexText(indexString);
        return personBeens;
    }

    private void initEvents(){
        //设置右侧字母触摸监听
        mikyouLetterListView.setOntouchingLetterChangedListener(new MikyouLetterListView.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String s) {
                initDatas(s);
                //该字母首次出现的位置
                int position = myAdapter.getPositionForSection(s.charAt(0));
                if (position != -1){
                    contactListView.setSelection(position);
                }
            }
        });
        //设置listview条目点击
        contactListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        //输入框搜索过滤
        serch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    ///当输入框里面的值为空，更新为原来的列表，否则为过滤数据列表
                filterData(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    /**
     * 根据输入框传来的值过滤数据并更新
     * @param s
     */
    private void filterData(String s) {
        List<PersonBean> contactList = new ArrayList<>();
        if (TextUtils.isEmpty(s)){
            contactList = sourceDateList;
        }else {
            contactList.clear();
            for (PersonBean contact : sourceDateList){
                String name = contact.getPerson();
                if (name.toUpperCase().indexOf(s.toUpperCase()) != -1 || PinYinUtils.getPinYin(name).toUpperCase().startsWith(s.toUpperCase())){
                    contactList.add(contact);
                }
            }
        }
        //排序
        Collections.sort(contactList,new PinYinComparator());
        myAdapter.updateListView(contactList);
    }

}
