package com.common.mvc.x.network;

import android.content.Context;

import com.common.mvc.commonlibrary.views.widgets.LoadingProgressBar;
import com.common.mvc.x.base.activity.BaseContentActivity;
import com.common.mvc.x.network.mqtt.MqttCallbackListener;
import com.common.mvc.x.network.mqtt.MqttClientManager;
import com.common.mvc.x.network.nettty.NettyClientHandler;

import java.lang.ref.WeakReference;

import io.reactivex.functions.Consumer;

/**
 * @author xiao
 * @date 2018/5/24
 */
public abstract class BaseResponse<T> implements NetworkCallback, Consumer {

    private Context mContext;

    private WeakReference<Context> contextWeakReference;

    private LoadingProgressBar mProgressBar;

    public BaseResponse(Context context) {
        init(context);
    }

    private void init(Context context) {
        init(context, null);
    }

    private void init(Context context, CharSequence tips) {
        contextWeakReference = new WeakReference<Context>(context);
        mContext = contextWeakReference.get();
        mProgressBar = new LoadingProgressBar(context,tips);
        new NettyClientHandler(this);
        new MqttCallbackListener(this);
    }

    @Override
    public void onComplete() {

    }


    @Override
    public void onError() {
        ((BaseContentActivity)mContext).showLoadingView();
    }

    @Override
    public void onReconnection() {
        MqttClientManager.getInstance().connect();
    }


}
