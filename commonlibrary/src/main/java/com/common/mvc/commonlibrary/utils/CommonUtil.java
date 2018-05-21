package com.common.mvc.commonlibrary.utils;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import com.common.mvc.commonlibrary.R;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 常用的一些工具类
 * @author xiao 2017/11/3
 */

public class CommonUtil {
    /**
     * 邮箱格式
     */
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";


    /**
     * 邮箱验证
     *
     * @param emailText
     * @return
     */
    public static boolean verifyEmail(String emailText) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(emailText);
        return matcher.matches();
    }

    /**
     * 常用集合判断
     */
    public static class Collection {

        public static boolean isEmpty(java.util.Collection e) {
            return e == null || e.size() <= 0;
        }

        public static int sizeOfCollection(java.util.Collection e) {
            return isEmpty(e) ? 0 : e.size();
        }

        public static boolean hasItem(java.util.Collection e, Object object) {
            boolean re = isEmpty(e) ? false : e.contains(object);
            return re;
        }
    }

    /**
     * 加上钱币符号
     *
     * @param price
     * @return
     */
    public static String chinesePrice(int price) {
        return "¥ " + price;
    }

    public static String chinesePrice(String price) {
        if (TextUtils.isDigitsOnly(price)) {
            return "¥ " + price;
        } else {
            return price;
        }
    }


    /**
     * 是否由数字组成
     *
     * @param string
     * @return
     */
    public static boolean isNumeric(String string) {
        if (string == null || string.length() == 0) {
            return false;
        }

        int l = string.length();
        for (int i = 0; i < l; i++) {
            int c = string.codePointAt(i);
            if (!Character.isDigit(c) && c != '.') {
                return false;
            }
        }
        return true;
    }

    /**
     * 去除.0
     *
     * @param total
     * @return
     */
    public static String split(String total) {
        return total.replace(".0", "");
    }

    /**
     * 判断一个字符串是否含有数字
     */
    public static boolean HasDigit(String content) {
        boolean flag = false;
        Pattern p = Pattern.compile(".*\\d+.*");
        Matcher m = p.matcher(content);
        if (m.matches()) {
            flag = true;
        }
        return flag;
    }


    public static void setActiveText(Context context, String activeText, TextView... tvs) {
        for (TextView tv : tvs) {
            setActiveText(context, activeText, tv);
        }
    }

    public static void setActiveText(Context context, String activeText, List<TextView> tvs) {
        for (TextView tv : tvs) {
            setActiveText(context, activeText, tv);
        }
    }

    private static void setActiveText(Context context, String activeText, TextView tv) {
        String fullString = tv.getText().toString();
        setActiveText(context, activeText, tv, fullString);
    }

    private static void setActiveText(Context context, String activeText, TextView tv, String fullString) {
        SpannableString sp = new SpannableString(fullString);
        int index = fullString.indexOf(activeText);
        if (index != -1) {
            sp.setSpan(
                    new ForegroundColorSpan(context.getResources().getColor(
                            R.color.yellow_text)), index, index + activeText.length(),
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        tv.setText(sp);
    }
}
