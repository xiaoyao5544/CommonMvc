package com.common.mvc.commonlibrary.utils;

import android.content.SharedPreferences;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * @author xiao
 * @date 2017/10/20
 */

public abstract class BaseSharedPreferences {

    private static final String APP_NAME = "MyApp";


    public String getString(String key) {
        return getSharedPreferences().getString(key, "");
    }

    public String getString(String key, String defValue) {
        return getSharedPreferences().getString(key, defValue);
    }

    public void setString(String key, String value) {
        getSharedPreferences().edit().putString(key, value).apply();
    }

    public boolean getBoolean(String key) {
        return getSharedPreferences().getBoolean(key, false);
    }

    public void setBoolean(String key, boolean value) {
        getSharedPreferences().edit().putBoolean(key, value).apply();
    }

    public int getInt(String key) {
        return getSharedPreferences().getInt(key, 0);
    }

    public int getInt(String key, int value) {
        return getSharedPreferences().getInt(key, value);
    }

    public void setInt(String key, int value) {
        getSharedPreferences().edit().putInt(key, value).apply();
    }

    public long getLong(String key) {
        return getSharedPreferences().getLong(key, 0);
    }

    public void setLong(String key, long value) {
        getSharedPreferences().edit().putLong(key, value).apply();
    }

    public void remove(String key) {
        getSharedPreferences().edit().remove(key).apply();
    }

    public void clear() {
        getSharedPreferences().edit().clear().apply();
    }

    /**
     * 针对复杂类型存储<对象>
     *
     * @param key
     * @param object
     */
    public void setObject(String key, Object object) {

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
    public <T> T getObject(String key) {
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
    public <T> T getObject(String key, T defValue) {
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

    /**
     * 重写该方法生成不同的文件
     * @return
     */
    public abstract SharedPreferences getSharedPreferences();
}
