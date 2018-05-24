package com.common.mvc.x.network;

import com.common.mvc.x.base.BaseRequest;

/**
 * @author xiao
 * @date 2018/5/24
 */
public interface AbstractHelper<T> {

     BaseRequest onRequest();

     BaseResponse<T> onResponse();
}
