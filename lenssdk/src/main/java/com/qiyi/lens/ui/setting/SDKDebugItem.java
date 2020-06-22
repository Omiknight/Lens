package com.qiyi.lens.ui.setting;

import android.content.Context;

public class SDKDebugItem extends SettingItem {
    static boolean enable; // 不持久化 , 只保留内存状态

    public SDKDebugItem(Context context, String spKey, String name, int id, ConfigEventCallBack changed) {
        super(context, spKey, name, id, changed);
        isEnabled = enable;
    }

    @Override
    public void notifyStatusChange(boolean status) {
        super.notifyStatusChange(status);
        enable = status;
    }


}
