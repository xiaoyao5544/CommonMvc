package com.common.mvc.x.network.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author xiao
 * @date 2018/5/25
 */
public class JacksonMapper {



    private static class SingletonHolder {
        private static final ObjectMapper INSTANCE = new ObjectMapper();
    }

    public static ObjectMapper getInstance() {

        return JacksonMapper.SingletonHolder.INSTANCE;
    }
}
