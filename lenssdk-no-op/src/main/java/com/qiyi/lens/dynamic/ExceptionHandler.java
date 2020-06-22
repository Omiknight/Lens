package com.qiyi.lens.dynamic;

import androidx.annotation.RestrictTo;
import android.util.Log;

import com.qiyi.lens.Lens;

@RestrictTo(RestrictTo.Scope.LIBRARY)
public class ExceptionHandler {
    public static void throwIfDebug(Throwable e, String tag, String msg) {
        if (Lens.isDebug()) {
            throw new RuntimeException(e);
        } else {
            Log.e(tag, msg, e);
        }
    }

    public static void throwIfDebug(Throwable e, String tag) {
        throwIfDebug(e, tag, "");
    }

    public static void throwIfDebug(Throwable e) {
        throwIfDebug(e, "");
    }
}
