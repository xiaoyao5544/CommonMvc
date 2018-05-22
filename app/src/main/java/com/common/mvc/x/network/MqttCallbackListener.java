package com.common.mvc.x.network;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * @author xiao
 * @date 2018/5/22
 */
public class MqttCallbackListener implements MqttCallback {


    @Override
    public void connectionLost(Throwable cause) {

    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        //接收到订阅的消息
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        //发送成功的消息
    }
}
