package com.shsany.testapp.DownLoad;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by PC on 2017/9/14.
 */

/**
 * String : 网络图片的路径
 * Void : （参数的包装类）是进度的刻度
 * Bitmap ：任务执行的返回结果
 */
public class DownTask extends AsyncTask<String ,Void,Bitmap> {
    ProgressDialog dialog ;
    public Context mContext;
    public DownTask(Context context){
        this.mContext = context;
        dialog = new ProgressDialog(context);
    }

    /**
     * //这里是开始线程之前执行的,在UI线程执行
     */
    @Override
    protected void onPreExecute() {
        dialog.setTitle("提示");
        dialog.setMessage("正在下载...");
        dialog.show();
            }

    /**
     * //在后台子线程中执行的
     * @param params
     * @return
     */
    @Override
    protected Bitmap doInBackground(String... params) {//三个点，代表可变参数
        Bitmap bitmap = null;
        URL url = null;
        try{
            url = new URL(params[0]);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            InputStream inputStream = connection.getInputStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }


    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        LoadActivity load = new LoadActivity();
        load.image.setImageBitmap(bitmap);
        dialog.dismiss();
    }

}
