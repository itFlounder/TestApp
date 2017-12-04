package com.shsany.testapp.example.Tab;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.shsany.testapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 2017/9/14.
 * viewPager基础讲解
 */

public class TraditionalActivity extends Activity {
    private List<View> mViews;
    private LayoutInflater mLayoutInflater;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traditional);
        mLayoutInflater = LayoutInflater.from(this);
        ViewPager mViewPager = (ViewPager)findViewById(R.id.vp_traditional);

        initView();

        mViewPager.setAdapter(new PagerAdapter() {
            /**
             * 返回要滑动的VIew的个数
             * @return
             */
            @Override
            public int getCount() {
                return mViews.size();
            }


            /**
             * 从当前container中删除指定位置（position）的View;
             * @param container
             * @param position
             * @param object
             */
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mViews.get(position));
            }

            /**
             * 做了两件事，第一：将当前视图添加到container中，第二：返回当前View
             * @param container
             * @param position
             * @return
             */
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = mViews.get(position);
                container.addView(view);
//                return view;
                return position;
            }

            /**
             *该函数用来判断instantiateItem(ViewGroup, int)函数所返回来的Key与一个页面视图是否是代表的同一个视图(即它俩是否是对应的，对应的表示同一个View)
             * @param view
             * @param object
             * @return 如果对应的是同一个View，返回True，否则返回False。
             */
            @Override
            public boolean isViewFromObject(View view, Object object) {
//                return view == object;
                return view == mViews.get(Integer.parseInt(object.toString()));
            }
        });


        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    public void initView(){
        Button bt1 = (Button)findViewById(R.id.bt_button1);
        Button bt2 = (Button)findViewById(R.id.bt_button2);
        Button bt3 = (Button)findViewById(R.id.bt_button3);
        Button bt4 = (Button)findViewById(R.id.bt_button4);

        mViews = new ArrayList<View>();
        View home = mLayoutInflater.inflate(R.layout.fragment_test,null);
        View test = mLayoutInflater.inflate(R.layout.fragment_test,null);
        View friend = mLayoutInflater.inflate(R.layout.fragment_test,null);
        View contact = mLayoutInflater.inflate(R.layout.fragment_contact,null);
        mViews.add(home);
        mViews.add(test);
        mViews.add(friend);
        mViews.add(contact);

    }
}
