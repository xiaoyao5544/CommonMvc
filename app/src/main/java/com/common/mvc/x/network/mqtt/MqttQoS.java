package com.common.mvc.x.network.mqtt;

/**
 * @author xiao
 * mqtt协议通讯质量
 */

public enum MqttQoS {
    /**
     * 最多一次
     * 至少一次
     *
     */
    AT_MOST_ONCE(0),
    AT_LEAST_ONCE(1),
    EXACTLY_ONCE(2),
    FAILURE(0x80);

    private final int value;

    MqttQoS(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static MqttQoS valueOf(int value) {
        for (MqttQoS q: values()) {
            if (q.value == value) {
                return q;
            }
        }
        throw new IllegalArgumentException("invalid QoS: " + value);
    }
}
