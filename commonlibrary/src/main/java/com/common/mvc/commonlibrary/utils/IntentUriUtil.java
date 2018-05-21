package com.common.mvc.commonlibrary.utils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * @author xiao 2017/10/27
 */

public class IntentUriUtil {

    /**
     * 跳转到应用市场
     *
     * @param context
     */
    public static void intentMarket(Context context) {
        Uri uri = Uri.parse("market://details?id="
                + context.getPackageName());
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }
    }
}
