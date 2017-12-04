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

public class ContactFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_contact,null);
        TextView mTextView = (TextView)mView.findViewById(R.id.tv_test);
        mTextView.setText("自是白衣卿相");

//        LayoutInflater layoutInflater = LayoutInflater.from();

        /*String path = "aaa";

        try{
            URL url = new URL(path);
            InputStream is = url.openStream();
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            is.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            URL url = new URL(path);
            InputStream is = url.openStream();
            OutputStream os =

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        return mView;
    }
}
