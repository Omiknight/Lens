package com.qiyi.lens.hook;

public interface LensHookListener {

    void onInvoke(String methodName, Object... args);
}
