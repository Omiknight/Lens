package com.qiyi.lens.hook;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * when a thread is started , this manager will be notified
 */
public class LensHookListenerManager {

    private static Map<String, ArrayList<LensHookListener>> sHookListeners = new HashMap<>();

    public synchronized static void addHookListener(String methodName, LensHookListener listener) {
        if (TextUtils.isEmpty(methodName) || listener == null) {
            return;
        }
        if (!sHookListeners.containsKey(methodName)) {
            sHookListeners.put(methodName, new ArrayList<LensHookListener>());
        }
        ArrayList<LensHookListener> arrayList = sHookListeners.get(methodName);
        if (arrayList != null) {
            arrayList.add(listener);
        }
    }

    public synchronized static void removeHookListener(String methodName, LensHookListener listener) {
        if (TextUtils.isEmpty(methodName) || listener == null) {
            return;
        }
        ArrayList<LensHookListener> arrayList = sHookListeners.get(methodName);
        if (arrayList != null) {
            arrayList.remove(listener);
        }
    }

    public synchronized static void notifyHookInvoked(String methodName, Object... args) {
        if (TextUtils.isEmpty(methodName)) {
            return;
        }
        ArrayList<LensHookListener> arrayList = sHookListeners.get(methodName);
        if (arrayList != null) {
            for (LensHookListener listener : arrayList) {
                listener.onInvoke(methodName, args);
            }
        }
    }

}
