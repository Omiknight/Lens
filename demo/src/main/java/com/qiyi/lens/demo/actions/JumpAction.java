package com.qiyi.lens.demo.actions;

import android.content.Context;

import com.qiyi.lens.utils.iface.IJumpAction;

/**
 * Lens 设置页面 支持自定义跳转的逻辑
 * 用于客户端自己实现自己的 快速跳转逻辑
 */
public class JumpAction implements IJumpAction {
    @Override
    public boolean jump(Context context, String key, int eventId) {
        return false;
    }
}
