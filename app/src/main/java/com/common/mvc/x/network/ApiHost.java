package com.common.mvc.x.network;

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



}
