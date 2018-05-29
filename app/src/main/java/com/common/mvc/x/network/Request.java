package com.common.mvc.x.network;

/**
 * @author xiao
 * @date 2018/5/24
 * 请求
 */
public class Request<T> extends BaseRequest {

    private static final long serialVersionUID = -347446981081245550L;

    private T data;


    public Request(String type, T data) {
        super("", "", type);
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
