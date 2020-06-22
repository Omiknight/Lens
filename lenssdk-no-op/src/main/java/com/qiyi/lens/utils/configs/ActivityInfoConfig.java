package com.qiyi.lens.utils.configs;

import com.qiyi.lens.ConfigHolder;
import com.qiyi.lens.utils.iface.IFragmentHandle;

public class ActivityInfoConfig {
    Class<? extends IFragmentHandle> fragClass;
    private static ActivityInfoConfig infoConfig = new ActivityInfoConfig();

    public static ActivityInfoConfig getInstance() {
        return infoConfig;
    }

    private ActivityInfoConfig() {
    }

    public void setFragmentHandler(Class< ? extends IFragmentHandle> fragmentHandler) {
        fragClass = fragmentHandler;
        ConfigHolder.fragmentHandler = fragmentHandler;
    }

    public Class<? extends IFragmentHandle> getFragClassHandle() {
        return fragClass;
    }

}
