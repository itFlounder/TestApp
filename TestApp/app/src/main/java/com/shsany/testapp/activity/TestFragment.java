package com.shsany.testapp.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shsany.testapp.R;

/**
 * Created by PC on 2017/9/13.
 */

public class TestFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_test,null);
        TextView mTextView = (TextView)mView.findViewById(R.id.tv_test);
        mTextView.setText("鹤冲天");
        return mView;
    }

}
