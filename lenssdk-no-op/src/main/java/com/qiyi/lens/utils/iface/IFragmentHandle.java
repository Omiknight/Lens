package com.qiyi.lens.utils.iface;

public interface IFragmentHandle {
    public void onFragmentAnalyse(Object fragment, StringBuilder stringBuilder);
    public Object getFragmentInstance(Object adapter, int index);
}
