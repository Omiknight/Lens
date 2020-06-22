package com.qiyi.lens;

import android.content.Context;
import android.content.ContextWrapper;

import com.qiyi.lens.utils.LL;
import com.qiyi.lens.utils.LensLog;
import com.qiyi.lens.utils.configs.ActivityInfoConfig;
import com.qiyi.lens.utils.configs.ViewInfoConfig;

/**
 * for release version : lens no-op load load plugin
 */
public class QuickStart {
    public static void start(Context context) {
        ViewInfoConfig.getInstance().setViewInfoHandler(ConfigHolder.viewInfoHandler);
        ActivityInfoConfig.getInstance().setFragmentHandler(ConfigHolder.fragmentHandler);
        LensUtil.setDefaultObjectDescriptor(ConfigHolder.defaultObjectDescriptor);
        LensUtil.setReporter(ConfigHolder.reporter);
        LensUtil.setViewClickDebugHandle(ConfigHolder.viewClickDebugHandle);
        LensUtil.setDumper(ConfigHolder.dumper);
        LensUtil.setDebugStatusChanged(ConfigHolder.debugStatusChanged);
        LensUtil.setUIVerifyFactory(ConfigHolder.uiVerifyClass);
        for (ConfigHolder.WatchConfig config : ConfigHolder.watchObjects) {
            if (config.name == null) {
                LensUtil.watchObject(config.object);
            } else {
                LensUtil.watchObject(config.name, config.object);
            }
        }
        for (ConfigHolder.WatchConfig config : ConfigHolder.watchFields) {
            LensUtil.watchField(config.name, config.object);
        }
        LensUtil.buildConfig()
                .defaultOpen(ConfigHolder.defaultOpen)
                .initAsPluginMode(ConfigHolder.initAsPluginMode)
                .enableLaunchTime(ConfigHolder.enableLaunchTime)
                .enableActivityAnalyzer(ConfigHolder.enableActivityAnalyzer)
                .enableKeyLog(ConfigHolder.enableKeyLog)
                .enableFPS(ConfigHolder.enableFPS)
                .enableCrashInfo(ConfigHolder.enableCrashInfo)
                .enableNetworkAnalyze(ConfigHolder.enableNetworkAnalyze)
                .enableDeviceInfo(ConfigHolder.enableDeviceInfo)
                .enableDisplayInfo(ConfigHolder.enableDisplayInfo)
                .enableViewInfo(ConfigHolder.enableViewInfo)
                .enablePermission(ConfigHolder.enablePermission)
                .enableHookTest(ConfigHolder.enableHookTest)
                .forceShow(context, ConfigHolder.width, ConfigHolder.state);
    }

    static Context getBaseContext(Context context) {
        while (context instanceof ContextWrapper) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        return context;
    }
}
