package com.qiyi.lens.utils;

import android.os.Build;

public class OSUtils {
    public static boolean isPreQ() {
        return Build.VERSION.SDK_INT < 29;
    }
}
