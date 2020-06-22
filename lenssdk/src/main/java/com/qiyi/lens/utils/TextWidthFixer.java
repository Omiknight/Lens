package com.qiyi.lens.utils;

import android.util.SparseArray;

/**
 * 在字符串前或者后添加空格，补齐长度
 */
public class TextWidthFixer {
    private static TextWidthFixer sInstance = new TextWidthFixer();
    private SparseArray<String> cachedFixer = new SparseArray<>();

    private TextWidthFixer() {
    }

    public static TextWidthFixer getInstance() {
        return sInstance;
    }

    public String fix(String str, int targetSize) {
        return fix(str, targetSize, false);
    }

    public String fix(String str, int targetSize, boolean append) {
        if (str == null || str.length() >= targetSize) {
            return str;
        }
        int diff = targetSize - str.length();
        String fixer = cachedFixer.get(diff);
        if (fixer == null) {
            fixer = createFixer(diff);
            cachedFixer.put(diff, fixer);
        }
        return append ? str + fixer : fixer + str;
    }

    private String createFixer(int diff) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < diff; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }
}
