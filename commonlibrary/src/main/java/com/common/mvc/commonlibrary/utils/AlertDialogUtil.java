package com.common.mvc.commonlibrary.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.ContextThemeWrapper;

import com.common.mvc.commonlibrary.R;


/**
 * 通用的dialog类 theme可改
 * @author xiao
 * @date 2017/1/17
 */
public class AlertDialogUtil {

    public static void alert(String msg, Context context, Callback callback) {
        int yesId = R.string.common_ok;
        int noId = R.string.common_cancel;
        alert(msg, yesId, noId, context, callback);
    }

    public static void alert(int msgId, Context context, Callback callback) {
        String msg = context.getResources().getString(msgId);
        int yesId = R.string.common_ok;
        int noId = R.string.common_cancel;
        alert(msg, yesId, noId, context, callback);
    }

    public static void alert(String msg, int yesId, int noId, Context context, final Callback callback) {
        new AlertDialog.Builder(new ContextThemeWrapper(context, android.R.style.Theme_Holo_Light))
                .setMessage(msg)
                .setPositiveButton(yesId, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        callback.onYesClick(true);
                    }
                })
                .setNegativeButton(noId, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        callback.onYesClick(false);
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setCancelable(false)
                .create()
                .show();
    }

    public static void alert(String msg, Context context, Callback callback, boolean isOutSide) {
        int yesId = R.string.common_ok;
        int noId = R.string.common_cancel;
        alert(msg, yesId, noId, context, callback, isOutSide);
    }

    public static void alert(String msg, int yesId, int noId, Context context, final Callback callback, boolean isOutSide) {
        new AlertDialog.Builder(new ContextThemeWrapper(context, android.R.style.Theme_Holo_Light))// R.style.AppTheme_Base))
                .setCancelable(isOutSide)
                //.setTitle(context.getResources().getString(R.string.alert_title_default))
                .setMessage(msg)
                .setPositiveButton(yesId, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        callback.onYesClick(true);
                    }
                })
                .setNegativeButton(noId, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        callback.onYesClick(false);
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .create()
                .show();
    }

    public interface Callback {
        /**
         * 确认的回调
         *
         * @param yes
         */
        void onYesClick(boolean yes);
    }
}
