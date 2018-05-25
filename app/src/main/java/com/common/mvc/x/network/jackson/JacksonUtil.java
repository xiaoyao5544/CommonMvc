package com.common.mvc.x.network.jackson;

/**
 * @author xiao
 * @date 2018/5/25
 */
public class JacksonUtil {

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
}