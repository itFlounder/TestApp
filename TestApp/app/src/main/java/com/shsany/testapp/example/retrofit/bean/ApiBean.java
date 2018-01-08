package com.shsany.testapp.example.retrofit.bean;

import java.io.Serializable;

/**
 * Created by PC on 2018/1/8.
 *
 * API实体类
 * 使用泛型进行封装，将请求的结果和数据隔离开，这样，就可以更多类型的数据格式，统一做处理
 */

public class ApiBean<T> implements Serializable {
    //结果
    public int code;
    //数据
    public T data;
}
