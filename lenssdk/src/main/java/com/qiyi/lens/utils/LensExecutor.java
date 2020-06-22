package com.qiyi.lens.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;


public class LensExecutor {

    private volatile static Handler uiHandler;
    private volatile static Handler bgHandler;

    private static void assetUIHandler() {
        if (uiHandler == null) {
            synchronized (LensExecutor.class) {
                if (uiHandler == null) {
                    uiHandler = new Handler(Looper.getMainLooper());
                }
            }
        }
    }

    public static void runOnUIThread(Runnable run) {
        assetUIHandler();
        uiHandler.post(run);
    }


    private static void assetSingleThread() {
        if (bgHandler == null) {
            synchronized (LensExecutor.class) {
                if (bgHandler == null) {
                    HandlerThread thread = new HandlerThread("lens-bg-thread");
                    thread.start();
                    bgHandler = new Handler(thread.getLooper());
                }
            }
        }

    }

    public static void runOnSingleBackThread(Runnable runnable) {
        assetSingleThread();
        bgHandler.post(runnable);
    }

}
