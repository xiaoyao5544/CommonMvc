package com.common.mvc.x.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.common.mvc.commonlibrary.utils.BaseSharedPreferences;
import com.common.mvc.x.MyApplication;

/**
 * @author xiao
 * 账号相关的数据存这里,账号退出时可不清空
 */
public class AccountSharedPreference extends BaseSharedPreferences {

    private static final String ACCOUNT_NAME = "";

    @Override
    public SharedPreferences getSharedPreferences() {
        return MyApplication.getInstant().getSharedPreferences(ACCOUNT_NAME, Context.MODE_PRIVATE);
    }
}
