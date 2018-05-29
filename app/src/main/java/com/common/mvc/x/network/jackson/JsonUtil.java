package com.common.mvc.x.network.jackson;

import com.common.mvc.commonlibrary.utils.MD5Utils;
import com.common.mvc.x.data.Constant;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author xiao
 * @date 2018/5/25
 */
public class JsonUtil {

    /**
     * string 转pojo
     *
     * @param str
     * @param c
     * @param <T>
     * @return
     */
    public static <T> T str2Object(String str, Class<T> c) {
        T t = null;
        try {
            t = JacksonMapper.getInstance().readValue(str, c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * obj转json格式的string
     * @param object
     * @return
     * @throws Exception
     */
    public String getJsonString(Object object) throws Exception {
        return JacksonMapper.getInstance().writeValueAsString(object);
    }

    public static ObjectNode creatENCRYPT(String str) {
        String s = str + getEntprytKey(Constant.ENCRYPT_INDEX_VALUE);

        String tocken = MD5Utils.MD5(s);
        ObjectNode JsonEncrypt = null;

        JsonNodeFactory nodeFactory = new JsonNodeFactory(false);

        try {
            JsonEncrypt = nodeFactory.objectNode();
            JsonEncrypt.put(Constant.ENCRYPT_INDEX, Constant.ENCRYPT_INDEX_VALUE);
            JsonEncrypt.put(Constant.TOCKEN, tocken);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonEncrypt;
    }

    private static String getEntprytKey(String encryptIndexValue) {
        if (Constant.ENCRYPT_INDEX_VALUE.equals(encryptIndexValue)){
            return Constant.ENCRYPT_INDEX_KEY;
        }
        return null;
    }

}