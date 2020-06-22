package com.qiyi.lens.dynamic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;

/*PlaceHolder，真正使用时应该加载到 lens 插件里面的 LensContext*/
public class LensContext extends ContextWrapper {
    @SuppressLint("StaticFieldLeak")
    private static Context sContext;

    public LensContext(Context base, Resources resources) {
        super(base);
        sContext = base;
    }

    public static Context get() {
        return sContext;
    }
}
