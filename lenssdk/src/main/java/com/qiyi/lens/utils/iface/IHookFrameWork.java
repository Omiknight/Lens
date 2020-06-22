package com.qiyi.lens.utils.iface;

import android.content.Context;

public interface IHookFrameWork {
    void addCustomHookPluginPath(String path);
    void usePluginMode(boolean pluginMode);
    void doHookDefault(String className);
    void setHookPluginInfo(Context context , String cacheDir, String pluginFile);
    ClassLoader getHookPluginClassLoader();
}
