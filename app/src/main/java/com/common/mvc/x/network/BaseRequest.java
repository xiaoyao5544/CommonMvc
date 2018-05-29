package com.common.mvc.x.network;

import com.common.mvc.x.model.BaseModel;
import com.common.mvc.x.network.jackson.JsonUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author xiao
 * @date 2018/5/28
 */
public class BaseRequest extends BaseModel {

    private static final long serialVersionUID = -6166759121945318837L;

    /**
     * 协议名称及版本号. siot/1.0
     */
    @JsonProperty
    String SIOT = "siot 1.0";

    /**
     * 本地ID, 其中xxxx由mac地址低4字节构成(出于保护隐私, 高2字节不使用. 例如 local-df:ef:ca:65)待讨论.
     * local-xxxxx
     */
    @JsonProperty
    String LOCAL_ID;

    /**
     * 消息发送者类型 gateway(主机), app(手机), server(服务器).
     */
    @JsonProperty
    String CAPACITY = "app";

    /**
     * dest-xxxxxx, 目的ID.
     */
    @JsonProperty
    String DEST_ID;

    /**
     * fuctionType, 功能类型;
     */
    @JsonProperty
    String TYPE;

    /**
     * 随机值, 使请求消息和回复消息一一对应.
     */
    @JsonProperty
    String MAGIC_NUM;

    @JsonProperty
    ObjectNode IS_ENCRYPT;

    /**
     * @param LOCAL_ID  当前登录账号
     * @param DEST_ID   地址 服务器或者主机
     * @param TYPE      请求类型
     */
    public BaseRequest(String LOCAL_ID, String DEST_ID, String TYPE) {
        this.LOCAL_ID = LOCAL_ID;
        this.DEST_ID = DEST_ID;
        this.TYPE = TYPE;
        this.MAGIC_NUM = getMAGIC_NUM();
        this.IS_ENCRYPT = JsonUtil.creatENCRYPT(LOCAL_ID + this.MAGIC_NUM);
    }

    @JsonIgnore
    public String getSIOT() {
        return SIOT;
    }

    @JsonIgnore
    public void setSIOT(String SIOT) {
        this.SIOT = SIOT;
    }

    @JsonIgnore
    public String getLOCAL_ID() {
        return LOCAL_ID;
    }

    @JsonIgnore
    public void setLOCAL_ID(String LOCAL_ID) {
        this.LOCAL_ID = LOCAL_ID;
    }

    @JsonIgnore
    public String getCAPACITY() {
        return CAPACITY;
    }

    @JsonIgnore
    public void setCAPACITY(String CAPACITY) {
        this.CAPACITY = CAPACITY;
    }

    @JsonIgnore
    public String getDEST_ID() {
        return DEST_ID;
    }

    @JsonIgnore
    public void setDEST_ID(String DEST_ID) {
        this.DEST_ID = DEST_ID;
    }

    @JsonIgnore
    public String getTYPE() {
        return TYPE;
    }

    @JsonIgnore
    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    /**
     * 生成随机数, 如果随机数重复几率太高, 再换成临时缓存自增的方式.
     */
    @JsonIgnore
    public String getMAGIC_NUM() {
        return (int) (Math.random() * 10000 * 10000) + "";
    }

    @JsonIgnore
    public void setMAGIC_NUM(String MAGIC_NUM) {
        this.MAGIC_NUM = MAGIC_NUM;
    }

    @JsonIgnore
    public ObjectNode getIS_ENCRYPT() {
        return IS_ENCRYPT;
    }

    @JsonIgnore
    public void setIS_ENCRYPT(ObjectNode IS_ENCRYPT) {
        this.IS_ENCRYPT = IS_ENCRYPT;
    }
}
