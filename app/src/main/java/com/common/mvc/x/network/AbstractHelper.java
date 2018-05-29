package com.common.mvc.x.network;

import com.common.mvc.x.model.BaseModel;

/**
 * @author xiao
 * @date 2018/5/24
 */
public interface AbstractHelper<T> {

    /**
     * 请求
     * @return
     */
    BaseModel onRequest();

    /**
     * 返回
     * @return
     */
    BaseResponse<T> onResponse();
}
