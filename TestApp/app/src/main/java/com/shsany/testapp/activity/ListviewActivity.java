package com.shsany.testapp.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.shsany.testapp.R;

import java.util.ArrayList;

/**
 * Created by PC on 2017/9/7.
 */

public class ListviewActivity extends Activity {

    private ListView listView;
    ArrayList mDate = new ArrayList();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        listView = (ListView)findViewById(R.id.lv_listview);
        setInfo();
        listView.setAdapter(new MyAdapter(this));
        listView.setOnItemClickListener(new ItemClick());


    }

    private void setInfo() {
        for (int i = 0;i<100;i++){
            mDate.add(i,"item"+(i+1));
        }
    }

    class MyAdapter extends BaseAdapter {
        public Context mContext;
        private LayoutInflater mLayoutInflater = null;

        public MyAdapter(Context context){
            this.mContext =context;
            mLayoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return mDate.size();
        }

        @Override
        public Object getItem(int position) {
            return mDate.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder mViewHolder = null;
            if (convertView == null){
                mViewHolder = new ViewHolder();
                convertView = mLayoutInflater.inflate(R.layout.item_listview,null);
                mViewHolder.t1 = (TextView) convertView.findViewById(R.id.tv_t1);
                mViewHolder.t2 = (TextView) convertView.findViewById(R.id.tv_t2);
                mViewHolder.t3 = (TextView) convertView.findViewById(R.id.tv_t3);
                mViewHolder.i1 = (ImageView)convertView.findViewById(R.id.iv_i1);
                mViewHolder.i2 = (ImageView)convertView.findViewById(R.id.iv_i2);
                convertView.setTag(mViewHolder);
            }else {
                mViewHolder =(ViewHolder) convertView.getTag();
            }
            mViewHolder.t1.setText(mDate.get(position).toString());
            return convertView;
        }
    }

    class ViewHolder{
        TextView t1;
        TextView t2;
        TextView t3;
        ImageView i1;
        ImageView i2;
    }

    class ItemClick implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(getApplication(),"点击item"+(position+1),Toast.LENGTH_SHORT).show();
        }
    }

}
