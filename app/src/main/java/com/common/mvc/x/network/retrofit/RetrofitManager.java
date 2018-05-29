package com.common.mvc.x.network.retrofit;

import android.support.annotation.NonNull;

import com.common.mvc.commonlibrary.rxjava.DefaultScheduler;
import com.common.mvc.x.BuildConfig;
import com.common.mvc.x.MyApplication;
import com.common.mvc.x.model.BaseModel;
import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.orhanobut.logger.Logger;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * @author xiao
 * @date 2018/5/22
 */
public class RetrofitManager {

    private Retrofit retrofit;

    private ApiService apiService;

    private static volatile OkHttpClient mOkHttpClient;

    private static final long DEFAULT_TIMEOUT = 30;

    private static final String BASE_URL = "https://www.bjztzhsiot.com:6443";

    private static final String DEBUG_BASE_URL = "http://123.57.68.237:8090";
    /**
     * 静态初始化器，由JVM来保证线程安全
     */
    private static class SingletonHolder {
        private static final RetrofitManager INSTANCE = new RetrofitManager();
    }

    public static RetrofitManager getInstance() {

        return SingletonHolder.INSTANCE;
    }

    private RetrofitManager() {
        createRetrofit();
    }

    public void createRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(getBaseUrl())
                .client(getOkHttpClient())
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    private String getBaseUrl() {
        String url;
        if (BuildConfig.DEBUG){
            url = DEBUG_BASE_URL;
        }else {
            url = BASE_URL;
        }
        return url+"/api/SIOT";
    }

    private OkHttpClient getOkHttpClient() {
        if (mOkHttpClient == null) {
            synchronized (RetrofitManager.class) {
                if (mOkHttpClient == null) {
                    ClearableCookieJar cookieJar =
                            new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(MyApplication.getInstant()));
                    mOkHttpClient = new OkHttpClient().newBuilder()
                            //拦截接口log信息
                            .addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                                @Override
                                public void log(@NonNull String s) {
                                    Logger.d(s);
                                }
                            }).setLevel(HttpLoggingInterceptor.Level.BASIC))
                            //连接超时时间
                            .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                            //请求超时
                            .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                            //读取超时
                            .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                            .retryOnConnectionFailure(true)
                            .cookieJar(cookieJar)
                            .build();
                }
            }
        }
        return mOkHttpClient;
    }

    /**
     * 进行网络请求的方法
     */
    public void  doHttp(AbstractHttpHelper<BaseModel> httpHelper){
        httpHelper.onRequest(apiService)
                .compose(new DefaultScheduler())
                .subscribe(httpHelper.onResponse());
    }
}
