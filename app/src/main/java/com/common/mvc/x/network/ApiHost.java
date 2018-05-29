package com.common.mvc.x.network;

import com.common.mvc.commonlibrary.utils.NetWorkUtil;
import com.common.mvc.x.MyApplication;
import com.common.mvc.x.network.mqtt.MqttClientManager;
import com.common.mvc.x.network.nettty.NettyClientManager;

/**
 * @author xiao
 * @date 2018/5/22
 */
public class ApiHost {

    private static class SingletonHolder {
        private static final ApiHost INSTAANCE = new ApiHost();
    }

    public static ApiHost getInstance() {
        return SingletonHolder.INSTAANCE;
    }



    public void sendRequest(AbstractHelper helper) {
        /*Observable.create(emitter -> { }).compose(new DefaultScheduler())
                .subscribe(helper.onResponse());*/
        if (NetWorkUtil.isWifi(MyApplication.getInstant())){
            Request request = new Request("",helper.onRequest());
            NettyClientManager.getInstance().sendNettyMessage(request);
        }else {
            Request request = new Request("",helper.onRequest());
            MqttClientManager.getInstance().sendMqttMessage(request);
        }
    }



}
