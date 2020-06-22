package com.qiyi.lens.utils.configs;

/**
 * AB test 只用于设置一些基础类型数据 & String （避免非法传入一些object 导致内存泄漏问题）
 */
public class ABNTestConfig {
    private static ABNTestConfig config = new ABNTestConfig();
    public void addABTest(String key, int[] vars) {
    }

    public void addABTest(String key, String[] vars) {
    }

    //add for boolean
    public void addABTest(String key) {
    }

    public static ABNTestConfig getInstance() {
        return config;
    }


    public boolean getBoolean(String key) {
        return false;
    }

    public int getInt(String key) {
        return 0;
    }

    public String getString(String key) {
        return "";
    }

    public String[] getKeys() {
        return new String[0];
    }

    public boolean hasTestData() {
        return false;
    }
}
