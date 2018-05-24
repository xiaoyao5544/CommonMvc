/*
 * Copyright © Yan Zhenjie. All Rights Reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.common.mvc.commonlibrary.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.view.View;

/**
 * @author xiao
 */
public class Toast {

    private static Handler sHandler = new Handler(Looper.getMainLooper());

    public static void show(Context context, CharSequence msg) {
        android.widget.Toast.makeText(context, msg, android.widget.Toast.LENGTH_LONG).show();
    }

    public static void show(Context context, @StringRes int stringId) {
        android.widget.Toast.makeText(context, stringId, android.widget.Toast.LENGTH_LONG).show();
    }

    public static void show(View view, CharSequence msg) {
        show(view.getContext(), msg);
    }

    public static void show(View view, @StringRes int stringId) {
        show(view.getContext(), stringId);
    }

    public static void showToast(Context ctx, int resId) {
        String text = ctx.getText(resId).toString();
        showToast(ctx, text);
    }

    /**
     * 子线程需要toast时调用
     * @param context
     * @param message
     */
    public synchronized static void showToast(final Context context, final CharSequence message) {
        sHandler.post(new Runnable() {
            @Override
            public void run() {
                if (context == null || TextUtils.isEmpty(message)) {
                    return;
                }
                android.widget.Toast.makeText(context, message, android.widget.Toast.LENGTH_LONG).show();
            }
        });
    }

}
