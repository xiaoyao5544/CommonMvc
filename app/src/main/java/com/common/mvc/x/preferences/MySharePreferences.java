package com.common.mvc.x.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.common.mvc.commonlibrary.utils.BaseSharedPreferences;
import com.common.mvc.x.MyApplication;

/**
 * @author xiao
 * 通用的存储方法及逻辑用set get方法写入
 */
public class MySharePreferences extends BaseSharedPreferences {

    private static final String NAME = "";

    @Override
    public SharedPreferences getSharedPreferences() {
        return MyApplication.getInstant().getSharedPreferences(NAME, Context.MODE_PRIVATE);
    }


}
