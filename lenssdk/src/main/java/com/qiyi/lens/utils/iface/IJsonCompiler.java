package com.qiyi.lens.utils.iface;

import com.qiyi.lens.ui.viewinfo.json.IJson;

/**
 * 支持UI自动验收功能： JSON 数据写出接口
 */
public interface IJsonCompiler {
    void addPair(String key, int value);

    void addPair(String key, float value);

    void addPair(String key, String value);

    void addPair(String key, IJson value);

    void addPair(String key, int[] array);
}
