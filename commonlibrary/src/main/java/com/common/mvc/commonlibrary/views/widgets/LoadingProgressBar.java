package com.common.mvc.commonlibrary.views.widgets;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.common.mvc.commonlibrary.R;

import java.lang.ref.WeakReference;

/**
 * @author xiao
 * @date 2018/5/24
 */
public class LoadingProgressBar extends Dialog implements DialogInterface.OnCancelListener {

    private WeakReference<Context> mContext;

    private volatile static LoadingProgressBar sProgressBar;


    public LoadingProgressBar(@NonNull Context context, CharSequence msg) {
        super(context, R.style.Common_Load_dialog);
        mContext = new WeakReference<>(context);
        View view = LayoutInflater.from(context).inflate(R.layout.view_loading_process, null);
        TextView message = (TextView) view.findViewById(R.id.message);
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        if (!TextUtils.isEmpty(msg)) {
            message.setText(msg);
        }
        addContentView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        setOnCancelListener(this);
    }


    private void showLoading(Context context, CharSequence msg) {
        showLoading(context, msg, false);
    }

    /**
     * show 方法 有需求可扩充
     * @param context
     * @param message
     * @param cancelable
     */
    public static synchronized void showLoading(Context context, CharSequence message, boolean cancelable) {
        if (sProgressBar != null && sProgressBar.isShowing()) {
            sProgressBar.dismiss();
        }

        if (context == null || !(context instanceof Activity)) {
            return;
        }

        sProgressBar = new LoadingProgressBar(context, message);
        sProgressBar.setCancelable(cancelable);

        if (sProgressBar != null && !sProgressBar.isShowing() && !((Activity) context).isFinishing()) {
            sProgressBar.show();
        }
    }

    public static synchronized void stopLoading() {
        if (sProgressBar != null && sProgressBar.isShowing()) {
            sProgressBar.dismiss();
        }
        sProgressBar = null;
    }

    @Override
    public void onCancel(DialogInterface dialogInterface) {
        //dialog取消时 也要取消网络请求
        Context context = mContext.get();

    }
}
