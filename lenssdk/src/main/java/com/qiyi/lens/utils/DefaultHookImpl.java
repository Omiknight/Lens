package com.qiyi.lens.utils;

import android.content.Context;

import com.qiyi.lens.utils.iface.IHookFrameWork;

public class DefaultHookImpl implements IHookFrameWork {
    @Override
    public void addCustomHookPluginPath(String path) {

    }

    @Override
    public void usePluginMode(boolean pluginMode) {

    }

    @Override
    public void doHookDefault(String className) {

    }

    @Override
    public void setHookPluginInfo(Context context, String cacheDir, String pluginFile) {

    }

    @Override
    public ClassLoader getHookPluginClassLoader() {
        return null;
    }
}
