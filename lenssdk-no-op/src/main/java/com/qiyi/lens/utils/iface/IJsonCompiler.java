package com.qiyi.lens.utils.iface;

public interface IJsonCompiler {
    void addPair(String key, int value);

    void addPair(String key, float value);

    void addPair(String key, String value);

    void addPair(String key, IJosn value);

    void addPair(String key, int[] array);
}
