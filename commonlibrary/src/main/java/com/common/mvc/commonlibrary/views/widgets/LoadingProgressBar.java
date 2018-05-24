package com.common.mvc.commonlibrary.views.widgets;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * @author xiao
 * @date 2018/5/24
 */
public class LoadingProgressBar extends Dialog {


    public LoadingProgressBar(@NonNull Context context) {
        super(context);
    }

    public LoadingProgressBar(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected LoadingProgressBar(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }
}
