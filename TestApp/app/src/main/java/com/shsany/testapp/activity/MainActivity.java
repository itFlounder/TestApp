package com.shsany.testapp.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.shsany.testapp.R;
import com.shsany.testapp.example.expandable.ExpanActivity;
import com.shsany.testapp.example.retrofit.ui.RetrofitActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    /*List mDate = new ArrayList();*/
    private List<Fragment> fragments = new ArrayList<Fragment>();
    private Fragment newFragment = null;
    private HomeFragment homeFragment = null;
    private FriendFragment friendFragment = null;
    private ContactFragment contactFragment = null;
    private TestFragment testFragment  = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt1 = (Button)findViewById(R.id.bt_button1);
        Button bt2 = (Button)findViewById(R.id.bt_button2);
        Button bt3 = (Button)findViewById(R.id.bt_button3);
        Button bt4 = (Button)findViewById(R.id.bt_button4);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);




        initView();

        /*ListView mListView = (ListView)findViewById(R.id.lv_main);
        setDate();
        mListView.setAdapter(new MyAdapter(this));
        mListView.setOnItemClickListener(new MainItemClick());*/
        Button mButton = (Button)findViewById(R.id.bt_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this,LoadActivity.class));
//                startActivity(new Intent(MainActivity.this,ListButtonActivity.class));
                startActivity(new Intent(MainActivity.this, RetrofitActivity.class));
            }
        });

        Button mButtonf = (Button)findViewById(R.id.bt_buttonf);
        mButtonf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ExpanActivity.class));
            }
        });





    }
    public void initView(){

        newFragment =new TestFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fm_new,newFragment);
        fragmentTransaction.commit();
    }
    public void init(){
        fragments.add(new TestFragment());
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fm_new,newFragment);
        switch (v.getId()){
            case R.id.bt_button1:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                }
                fragmentTransaction.replace(R.id.fm_new,homeFragment);
                break;
            case R.id.bt_button2:
                if (friendFragment == null) {
                    friendFragment = new FriendFragment();
                }
                fragmentTransaction.replace(R.id.fm_new,friendFragment);
                break;
            case R.id.bt_button3:
                if (contactFragment == null) {
                    contactFragment = new ContactFragment();
                }
                fragmentTransaction.replace(R.id.fm_new,contactFragment);
                break;
            case R.id.bt_button4:
                if (testFragment == null) {
                    testFragment = new TestFragment();
                }
                fragmentTransaction.replace(R.id.fm_new,testFragment);
                break;

        }
        fragmentTransaction.commit();
    }




























   /* public void setDate(){
        for (int i = 0;i<50;i++){
            mDate.add(i,"item"+i);
        }
    }
    class MyAdapter extends BaseAdapter {
        public Context mContext;
        public LayoutInflater mLayoutInflater;
        public MyAdapter(Context context){
            this.mContext = context;
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
            if (convertView== null){
                mViewHolder = new ViewHolder();
                convertView = mLayoutInflater.inflate(R.layout.item_listview,null);
                mViewHolder.tv1 = (TextView)convertView.findViewById(R.id.tv_t1);
                mViewHolder.tv2 = (TextView)convertView.findViewById(R.id.tv_t2);
                mViewHolder.tv3 = (TextView)convertView.findViewById(R.id.tv_t3);
                mViewHolder.iv1 = (ImageView)convertView.findViewById(R.id.iv_i1);
                mViewHolder.iv2 = (ImageView)convertView.findViewById(R.id.iv_i2);
                convertView.setTag(mViewHolder);

            }else {
                mViewHolder = (ViewHolder) convertView.getTag();
            }
            mViewHolder.tv2.setText(mDate.get(position+1).toString());
            return convertView;
        }
    }
    class ViewHolder{
        TextView tv1,tv2,tv3;
        ImageView iv1,iv2;
    }
    class MainItemClick implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(getApplication(),"你点击了item"+(position+1),Toast.LENGTH_SHORT).show();
        }
    }
*/
}
