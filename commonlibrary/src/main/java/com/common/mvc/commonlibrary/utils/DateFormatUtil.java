package com.common.mvc.commonlibrary.utils;

import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间格式化
 * @author xiao 2017/11/8
 */

public class DateFormatUtil {

    static public String toString(Date s, Context context) {
        SimpleDateFormat sf = new SimpleDateFormat("MMMM,dd", context
                .getResources().getConfiguration().locale);
        return sf.format(s);
    }

    static public String toMY(Date s, Context context) {
        SimpleDateFormat sf = new SimpleDateFormat("MMMM, yyyy", context
                .getResources().getConfiguration().locale);
        return sf.format(s);
    }

    static public String toCouponString(Date s, Context context) {
        SimpleDateFormat sf = new SimpleDateFormat("E,MMMM,dd,yyyy", context
                .getResources().getConfiguration().locale);
        return sf.format(s);
    }

    static public String toDetailedTime(Date s, Context context) {//
        SimpleDateFormat sf = new SimpleDateFormat("MM-dd HH:mm", context
                .getResources().getConfiguration().locale);
        return sf.format(s);
    }

    static public String toSimpleTime(Date s, Context context) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm", context
                .getResources().getConfiguration().locale);
        return sf.format(s);
    }
}
