package com.common.mvc.x.network;

/**
 * @author xiao
 * @date 2018/5/23
 */
public interface NetworkCallback {


    void onComplete();

    /**
     * 请求成功的回调
     */
    void onSuccess();


    /**
     * 请求失败的回调
     */
    void onError();

    /**
     * 请求丢失的回调
     */
    void onReconnection();

}
