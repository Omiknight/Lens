package com.qiyi.lens;

import android.content.Context;

import com.qiyi.lens.dynamic.LensContext;
import com.qiyi.lenssdk.BuildConfig;

/*placeholder，保证 sdk 与 sdk-no-op 之间的切换*/
public class Lens {

    public static final String VERSION = BuildConfig.VERSION_NAME;

    public static void init(Context context, boolean debug) {
    }

    public static Context wrapContext(Context context) {
        return new LensContext(context, context.getResources());
    }

    public static void showManually(Context context) {
        LensUtil.showManually(context);
    }

    public static boolean isSDKMode() {
        return true;
    }

    public static boolean isDebug() {
        return false;
    }

    public static void addDownloadConfigUrl(String url) {
    }

    public static void addDownloadConfigUrl(int position, String url) {
    }

    public static void setPreferAbi(String abi) {

    }
}
