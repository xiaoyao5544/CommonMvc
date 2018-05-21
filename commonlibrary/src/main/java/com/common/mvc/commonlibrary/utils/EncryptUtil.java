package com.common.mvc.commonlibrary.utils;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * 加密
 * @author xiao 2017/11/3
 */

public class EncryptUtil {

    /**
     * 字符串倒序输出
     *
     * @param key
     * @return
     */
    public static String reverseKey(String key) {
        StringBuffer stringBuffer = new StringBuffer(key);
        stringBuffer.reverse();
        return stringBuffer.toString();
    }

    /**
     * HMACSHA 加密
     *
     * @param secret
     * @param message
     * @return
     */
    public static String hmacSha1(String secret, String message) {
        byte[] keyByte = secret.getBytes();
        Key key = new SecretKeySpec(keyByte, 0, keyByte.length, "HmacSHA1");
        try {
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(key);

            byte[] rawHmac = mac.doFinal(message.getBytes());

            //  String result = Base64.encodeToString(rawHmac, Integer.parseInt(""));
            return byteArrayToHex(rawHmac);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 转化成16进制
     *
     * @param a
     * @return
     */
    private static String byteArrayToHex(byte[] a) {
        int hn, ln, cx;
        String hexDigitChars = "0123456789abcdef";
        StringBuffer buf = new StringBuffer(a.length * 2);
        for (cx = 0; cx < a.length; cx++) {
            hn = ((int) (a[cx]) & 0x00ff) / 16;
            ln = ((int) (a[cx]) & 0x000f);
            buf.append(hexDigitChars.charAt(hn));
            buf.append(hexDigitChars.charAt(ln));
        }
        return buf.toString();
    }
}
