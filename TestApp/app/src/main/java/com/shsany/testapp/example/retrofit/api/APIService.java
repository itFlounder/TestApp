package com.shsany.testapp.example.retrofit.api;

import com.shsany.testapp.example.retrofit.bean.ApiBean;
import com.shsany.testapp.example.retrofit.bean.Book;
import com.shsany.testapp.example.retrofit.bean.IpBean;
import com.shsany.testapp.example.retrofit.bean.SectionBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by PC on 2018/1/8.
 */

public interface APIService {
    @GET("book/search")
    Call<Book> getIpInfo(@Query("q") String name,
                         @Query("tag") String tag,
                         @Query("start") int start,
                         @Query("count") int count);

    @GET("/service/getIpInfo.php")
    Call<ApiBean<IpBean>> getIpInfo2(@Query("ip") String ip);

//    @GET("/service/getIpInfo.php")
//    Observable<ApiBean<IpBean>> getIpInfo3(@Query("ip") String ip);
    @GET("book/search")
    Observable<Book> getIpInfo3(@Query("q") String name,
                                @Query("tag") String tag,
                                @Query("start") int start,
                                @Query("count") int count);

    @GET("/location/bm")
    Observable<SectionBean> getInfo();
}
