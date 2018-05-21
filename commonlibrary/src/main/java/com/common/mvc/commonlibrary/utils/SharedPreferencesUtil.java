package com.common.mvc.commonlibrary.utils;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import studio.jss.jinshisong.app.JssApp;


/**
 *
 * @author xiao
 * @date 2017/10/20
 */

public class SharedPreferencesUtil {

    private static final String APP_NAME = "MyApp";


    public static String getString(String key) {
        return getSharedPreferences().getString(key, "");
    }

    public static String getString(String key, String defValue) {
        return getSharedPreferences().getString(key, defValue);
    }

    public static void setString(String key, String value) {
        getSharedPreferences().edit().putString(key, value).apply();
    }

    public static boolean getBoolean(String key) {
        return getSharedPreferences().getBoolean(key, false);
    }

    public static void setBoolean(String key, boolean value) {
        getSharedPreferences().edit().putBoolean(key, value).apply();
    }

    public static int getInt(String key) {
        return getSharedPreferences().getInt(key, 0);
    }

    public static int getInt(String key, int value) {
        return getSharedPreferences().getInt(key, value);
    }

    public static void setInt(String key, int value) {
        getSharedPreferences().edit().putInt(key, value).apply();
    }

    public static long getLong(String key) {
        return getSharedPreferences().getLong(key, 0);
    }

    public static void setLong(String key, long value) {
        getSharedPreferences().edit().putLong(key, value).apply();
    }

    public static void remove(String key) {
        getSharedPreferences().edit().remove(key).apply();
    }

    public static void clear() {
        getSharedPreferences().edit().clear().apply();
    }

    /**
     * 针对复杂类型存储<对象>
     *
     * @param key
     * @param object
     */
    public static void setObject(String key, Object object) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream out = null;
        try {

            out = new ObjectOutputStream(baos);
            out.writeObject(object);
            String objectVal = new String(android.util.Base64.encode(baos.toByteArray(), android.util.Base64.DEFAULT));
            SharedPreferences.Editor editor = getSharedPreferences().edit();
            editor.putString(key, objectVal);
            editor.commit();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T getObject(String key) {
        if (getSharedPreferences().contains(key)) {
            String objectVal = getSharedPreferences().getString(key, null);
            byte[] buffer = android.util.Base64.decode(objectVal, android.util.Base64.DEFAULT);
            ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(bais);
                T t = (T) ois.readObject();
                return t;
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (bais != null) {
                        bais.close();
                    }
                    if (ois != null) {
                        ois.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getObject(String key , T defValue) {
        if (getSharedPreferences().contains(key)) {
            String objectVal = getSharedPreferences().getString(key, null);
            byte[] buffer = android.util.Base64.decode(objectVal, android.util.Base64.DEFAULT);
            ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(bais);
                T t = (T) ois.readObject();
                return t;
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (bais != null) {
                        bais.close();
                    }
                    if (ois != null) {
                        ois.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return defValue;
    }

    public static SharedPreferences getSharedPreferences() {
        return Application.getInstant()
                .getSharedPreferences(APP_NAME, Context.MODE_PRIVATE);
    }
}
