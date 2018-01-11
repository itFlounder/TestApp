package com.shsany.testapp.example.retrofit.view;

/**
 * Created by PC on 2018/1/8.
 *
 * 世界接口
 */

public interface ITeach4View {
    /**
     * 显示IP信息
     *
     * @param total
     */
    public void showIpInfo(int total);

    /**
     * 显示错误消息
     *
     * @param e 错误
     */
    public void showError(Throwable e);
}
