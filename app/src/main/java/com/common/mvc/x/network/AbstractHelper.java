package com.common.mvc.x.network;

/**
 * @author xiao
 * @date 2018/5/24
 */
public interface AbstractHelper<T> {

     BaseRequest onRequest();

     BaseResponse<T> onResponse();
}
