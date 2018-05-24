package com.common.mvc.x.base;

/**
 * @author xiao
 * @date 2018/5/24
 * 请求
 */
public class BaseRequest<T> {


    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
