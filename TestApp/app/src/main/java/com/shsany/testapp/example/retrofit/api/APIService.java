package com.shsany.testapp.example.retrofit.api;

import com.shsany.testapp.example.retrofit.bean.ApiBean;
import com.shsany.testapp.example.retrofit.bean.DemoBean;
import com.shsany.testapp.example.retrofit.bean.IpBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by PC on 2018/1/8.
 */

public interface APIService {
    @GET("/service/getIpInfo.php")
    Call<DemoBean> getIpInfo(@Query("ip") String ip);

    @GET("/service/getIpInfo.php")
    Call<ApiBean<IpBean>> getIpInfo2(@Query("ip") String ip);

    @GET("/service/getIpInfo.php")
    Observable<ApiBean<IpBean>> getIpInfo3(@Query("ip") String ip);
}
