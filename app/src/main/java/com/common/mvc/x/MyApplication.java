package com.common.mvc.x;

import android.app.Application;

/**
 * @author gitxi
 */
public class MyApplication extends Application {

    private static MyApplication context;

    public static MyApplication getInstant() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
