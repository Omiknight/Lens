package com.qiyi.lens.utils;

import android.content.Context;
import androidx.annotation.RestrictTo;


@RestrictTo(RestrictTo.Scope.LIBRARY)
public class SharedPreferenceUtils {//
    /* 修改时必须和 sdk 同步修改 */
    private static final String PREFERENCE_NAME = "Lens";

    public static void set(String propertyName, int propertyValue, Context context) {
        context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE).edit().putInt(propertyName, propertyValue).apply();
    }

    public static void set(String propertyName, String propertyValue, Context context) {
        context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE).edit().putString(propertyName, propertyValue).apply();
    }

    public static String getString(String propertyName, String defaultValue, Context context) {
        return context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE).getString(propertyName, defaultValue);
    }
}
