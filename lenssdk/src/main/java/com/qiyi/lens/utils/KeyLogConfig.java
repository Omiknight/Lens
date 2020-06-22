package com.qiyi.lens.utils;

public class KeyLogConfig {
    int maxLine;
    int briefLine;
    String[] filters;
    private int count;

    public KeyLogConfig() {
        this.maxLine = 20;
        this.briefLine = 5;
    }

    /**
     * 支持添多个 filter
     *
     * @return
     */
    public KeyLogConfig addFilter(String key) {
        if (filters == null) {
            filters = new String[3];
        }
        if (count < filters.length) {
            filters[count] = key;
        } else {
            String[] ns = new String[count + 3];
            System.arraycopy(filters, 0, ns, 0, count);
            ns[count] = key;
            filters = ns;
        }
        count++;
        return this;
    }


    public KeyLogConfig setMaxLine(int line) {
        this.maxLine = line;
        return this;
    }

    public KeyLogConfig setBriefLine(int line) {
        briefLine = line;
        return this;
    }

    public static KeyLogConfig builder() {
        return new KeyLogConfig();
    }

}
