package com.common.mvc.x.network;

import com.common.mvc.x.network.mqtt.MqttCallbackListener;
import com.common.mvc.x.network.nettty.NettyClientHandler;

/**
 * @author xiao
 * @date 2018/5/24
 */
public abstract class BaseResponse<T> implements NetworkCallback {

    public BaseResponse() {
        new NettyClientHandler(this);
        new MqttCallbackListener(this);
    }

    @Override
    public void onComplete() {

    }


    @Override
    public void onError() {

    }

    @Override
    public void onReconnection() {

    }
}
