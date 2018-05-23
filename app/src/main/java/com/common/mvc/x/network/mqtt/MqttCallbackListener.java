package com.common.mvc.x.network.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * @author xiao
 * @date 2018/5/22
 */
public class MqttCallbackListener implements MqttCallback {



    /**
     * 发送成功的回调
     * @param token
     */
    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {

    }

    /**
     * 接收到订阅的回调
     * @param topic
     * @param message
     * @throws Exception
     */
    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {

    }

    /**
     * 连接丢失的回调重连
     * @param cause
     */
    @Override
    public void connectionLost(Throwable cause) {

    }
}
