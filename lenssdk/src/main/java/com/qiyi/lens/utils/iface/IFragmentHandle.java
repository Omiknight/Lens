package com.qiyi.lens.utils.iface;

/**
 * 支持页面分析：
 * Fragment 分析
 */
public interface IFragmentHandle {
    // 往Fragment 中 添加定制的识别内容
    void onFragmentAnalyse(Object fragment, StringBuilder stringBuilder);

    //从Fragment Adapter 中返回对应的Fragment 对象。（尽量必要重新创建 ）
    Object getFragmentInstance(Object adapter, int index);
}
