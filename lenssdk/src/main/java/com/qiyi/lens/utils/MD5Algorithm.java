package com.qiyi.lens.utils;

import java.security.MessageDigest;

/**
 * md5算法
 */
public class MD5Algorithm {

    private MD5Algorithm() {
        throw new IllegalStateException("Utility class");
    }

    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4',
            '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * MD5算法
     *
     * @param str 待加密字符串
     * @return 返回小写md5加密后字符串
     */
    public static String md5(String str) {
        return md5(str, true);
    }

    /**
     * MD5算法
     *
     * @param str     待加密字符串
     * @param isLower true：返回小写字符
     *                false： 返回大写字符
     * @return md5加密后字符串
     */
    public static String md5(String str, boolean isLower) {

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
            byte[] byteArray = messageDigest.digest();

            StringBuilder hexString = new StringBuilder();
            for (byte b : byteArray) {
                hexString.append(HEX_DIGITS[b >> 4 & 0xf]);
                hexString.append(HEX_DIGITS[b & 0xf]);
            }

            String res = hexString.toString();
            if (!isLower) {
                //大写
                res = res.toUpperCase();
            }

            return res;
        } catch (Exception ignore) {
            ignore.printStackTrace();
        }

        return str;
    }
}