package com.qiyi.lens.ui.setting;

import com.qiyi.lens.utils.iface.IJumpAction;
import com.qiyi.lens.utils.iface.ISwitchAction;

public class ConfigEventCallBack {
    IJumpAction jumpAction;
    ISwitchAction switchAction;

    ConfigEventCallBack(IJumpAction action, ISwitchAction sAction) {
        jumpAction = action;
        switchAction = sAction;
    }
}
