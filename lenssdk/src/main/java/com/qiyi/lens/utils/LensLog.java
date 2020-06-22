package com.qiyi.lens.utils;

import android.util.Log;

import com.qiyi.lens.Lens;

public class LensLog {
    private static final String TAG = "Lens-Log";

    public static void d(String msg) {
        if (Lens.isDebug()) {
            Log.d(TAG, msg);
        }
    }

    public static void e(String msg) {
        Log.e(TAG, msg);
    }
}
