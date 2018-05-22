package com.common.mvc.x;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

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

        initTool();
    }

    /**
     * 初始化一些工具类
     */
    private void initTool() {
        initLog();
    }

    /**
     * logger 设置
     */
    private void initLog() {
        FormatStrategy strategy = PrettyFormatStrategy.newBuilder()
                .tag("MyApp")
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(strategy){
            @Override
            public boolean isLoggable(int priority, String tag) {
                return BuildConfig.DEBUG;
            }
        });
    }
}
