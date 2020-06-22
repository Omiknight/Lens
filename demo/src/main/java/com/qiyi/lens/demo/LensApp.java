package com.qiyi.lens.demo;

import android.app.Application;
import android.content.Context;

import com.qiyi.lens.Lens;
import com.qiyi.lens.demo.dump.Dump;
import com.qiyi.lens.utils.LensConfig;
import com.qiyi.lens.utils.TimeStampUtil;


public class LensApp extends Application {
    private static final String LENS_CONFIG_URL = "http://api.dementor.qiyi.domain/lens/apk?version=" + Lens.VERSION;
    private Object mLensApplication;
    private static LensApp sInstance;

    public static LensApp getInstance() {
        return sInstance;
    }

    @Override
    protected void attachBaseContext(Context base) {


        sInstance = this;
        TimeStampUtil.obtain(LensConfig.LAUNCH_TIME_STAMP_NAME).setEndViewId(android.R.id.content);
        super.attachBaseContext(base);
        Lens.setPreferAbi("armeabi");
        Lens.init(this, true);
        // Lens 插件化方案 自动下载Lens 插件的远端配置地址
        Lens.addDownloadConfigUrl(LENS_CONFIG_URL);
        try {
            Class<?> lensApplication = getClassLoader().loadClass("com.qiyi.lens.demo.LensApplicationDelegate");
            mLensApplication = lensApplication.getConstructor(Application.class).newInstance(this);
            mLensApplication.getClass().getMethod("attachBaseContext", Context.class).invoke(mLensApplication, base);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        try {
            mLensApplication.getClass().getMethod("onCreate").invoke(mLensApplication);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Dump
    public String dump() {
        return mLensApplication == null ? "null" : mLensApplication.getClass().getName();
    }
}
