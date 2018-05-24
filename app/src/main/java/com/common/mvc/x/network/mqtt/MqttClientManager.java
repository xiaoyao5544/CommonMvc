package com.common.mvc.x.network.mqtt;

import com.common.mvc.x.MyApplication;
import com.common.mvc.x.R;
import com.orhanobut.logger.Logger;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

/**
 * @author xiao
 * 单例管理类
 */
public class MqttClientManager {

    private String mqttHost = "";

    private String mqttClientId = "";

    private static final String MQTT_USERNAME = "siotuser";

    private static final String MQTT_PASWORD = "gkncugsl";

    private MqttClient mMqttClient;

    private MqttConnectOptions mqttOptions;

    /**
     * 静态初始化器，由JVM来保证线程安全
     */
    private static class SingletonHolder {
        private static final MqttClientManager INSTANCE = new MqttClientManager();
    }


    public static MqttClientManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 建立连接
     */
    public void connect() {
        try {
            // host为主机名，clientid即连接MQTT的客户端ID，一般以唯一标识符表示，MemoryPersistence设置clientid的保存形式，默认为以内存保存
            mMqttClient = new MqttClient(mqttHost, mqttClientId, new MemoryPersistence());
            mMqttClient.setCallback(new MqttCallbackListener());
            mMqttClient.connect(getOptions());
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    /**
     * 订阅消息
     *
     * @param topic 订阅消息的主题
     */
    public void subscribeMsg(String topic, int qos) {
        if (mMqttClient != null) {
            int[] Qos = {qos};
            String[] topics = {topic};
            try {
                mMqttClient.subscribe(topics, Qos);
                Logger.d("开始订阅topic=" + topic);
            } catch (MqttException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 发布消息
     *
     * @param topic      发布消息主题
     * @param msg        消息体
     * @param isRetained 是否为保留消息
     */
    public void sendMqttMessage(String topic, String msg, boolean isRetained, int qos) {

        try {
            if (mMqttClient != null) {
                MqttMessage message = new MqttMessage();
                message.setQos(qos);
                message.setRetained(isRetained);
                message.setPayload(msg.getBytes());
                mMqttClient.publish(topic, message);
                Logger.d("topic=" + topic + "--msg=" + msg + "--isRetained" + isRetained);
            }
        } catch (MqttPersistenceException e) {
            e.printStackTrace();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断是否连接
     *
     * @return
     */
    public boolean isConnected() {
        if (mMqttClient != null) {
            return mMqttClient.isConnected();
        }
        return false;
    }

    /**
     * 断开链接
     */
    public void disConnect() {
        if (mMqttClient != null && mMqttClient.isConnected()) {
            try {
                mMqttClient.disconnect();
            } catch (MqttException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 配置连接选项
     *
     * @return
     */
    private MqttConnectOptions getOptions() {
        mqttOptions = new MqttConnectOptions();
        //设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，这里设置为true表示每次连接到服务器都以新的身份连接
        mqttOptions.setCleanSession(true);
        // 设置连接的用户名
        mqttOptions.setUserName(MQTT_USERNAME);
        // 设置连接的密码
        mqttOptions.setPassword(MQTT_PASWORD.toCharArray());
        // 设置超时时间 单位为秒
        mqttOptions.setConnectionTimeout(10);
        // 设置会话心跳时间 单位为秒 服务器会每隔1.5*20秒的时间向客户端发送个消息判断客户端是否在线，但这个方法并没有重连的机制
        mqttOptions.setKeepAliveInterval(20);
        // 设置回调
        //MqttTopic topic = mMqttClient.getTopic(TOPIC);
        //setWill方法，如果项目中需要知道客户端是否掉线可以调用该方法。设置最终端口的通知消息
        //mqttOptions.setWill(topic, "close".getBytes(), 2, true);

        //配置安全证书
        try {
            KeyStore keyStore = KeyStore.getInstance("BKS");
            keyStore.load(MyApplication.getInstant().getResources().openRawResource(R.raw.kclient_ztzh_mosquitto),MQTT_PASWORD.toCharArray());
            TrustManagerFactory trustManagerFactory  =TrustManagerFactory.getInstance("X509");
            trustManagerFactory.init(keyStore);
            TrustManager[] managers = trustManagerFactory.getTrustManagers();

            SSLContext sslContext = SSLContext.getInstance("TLSv1");
            sslContext.init(null,managers,null);
            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            mqttOptions.setSocketFactory(sslSocketFactory);
        } catch (NoSuchAlgorithmException | KeyStoreException | IOException | CertificateException | KeyManagementException e) {
            e.printStackTrace();
        }
        return mqttOptions;
    }
}
