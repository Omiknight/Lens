package com.qiyi.lens.utils.configs;

import com.qiyi.lens.utils.iface.IViewInfoHandle;

public class ViewInfoConfig {
    private Class<? extends IViewInfoHandle> fragClass;
    private static ViewInfoConfig infoConfig = new ViewInfoConfig();

    public static ViewInfoConfig getInstance() {
        return infoConfig;
    }

    private ViewInfoConfig() {
    }

    public void setViewInfoHandler(Class<? extends IViewInfoHandle> fragmentHandler) {
        this.fragClass = fragmentHandler;
    }

    public Class<? extends IViewInfoHandle> getViewInfoHandle() {
        return this.fragClass;
    }
}
