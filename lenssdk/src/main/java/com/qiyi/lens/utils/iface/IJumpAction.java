package com.qiyi.lens.utils.iface;

import android.content.Context;

/**
 * 设置页面：支持页面跳转能力
 */
public interface IJumpAction {
    boolean jump(Context context, String key, int eventId);
}
