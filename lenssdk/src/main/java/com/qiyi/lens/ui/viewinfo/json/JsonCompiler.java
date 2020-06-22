package com.qiyi.lens.ui.viewinfo.json;

import com.qiyi.lens.utils.iface.IJsonCompiler;

public class JsonCompiler implements IJsonCompiler, IJson {
    private StringBuilder stringBuilder = new StringBuilder();
    private boolean started;


    public JsonCompiler() {
        begin();
    }

    private void begin() {
        if (!started) {
            stringBuilder.setLength(0);
            stringBuilder.append('{');
            started = true;
        }
    }

    private void end() {
        if (started) {

            if (stringBuilder.charAt(stringBuilder.length() - 1) == ',') {
                stringBuilder.setLength(stringBuilder.length() - 1);
            }
            stringBuilder.append('}');
            started = false;
        }
    }

    private void appKey(String key) {
        stringBuilder.append('\"');
        stringBuilder.append(key);
        stringBuilder.append('\"');
    }

    public void addPair(String key, int value) {
        appKey(key);
        stringBuilder.append(':');
        stringBuilder.append(value);
        stringBuilder.append(',');
    }

    public void addPair(String key, float value) {
        appKey(key);
        stringBuilder.append(':');
        stringBuilder.append(value);
        stringBuilder.append(',');
    }

    public void addPair(String key, String value) {
        appKey(key);
        stringBuilder.append(':');
        appKey(value);
        stringBuilder.append(',');
    }

    public void addPair(String key, IJson value) {
        appKey(key);
        stringBuilder.append(':');
        value.toJson(stringBuilder);
        stringBuilder.append(',');
    }

    @Override
    public void addPair(String key, int[] array) {
        appKey(key);
        stringBuilder.append(':');
        stringBuilder.append('[');
        if (array != null && array.length > 0) {
            for (int i : array) {
                stringBuilder.append(i);
                stringBuilder.append(',');
            }
            stringBuilder.setLength(stringBuilder.length() - 1);
        }
        stringBuilder.append(']');
        stringBuilder.append(',');
    }

    public String value() {
        end();
        return stringBuilder.toString();
    }

    @Override
    public String toJson() {
        return value();
    }

    @Override
    public void toJson(StringBuilder builder) {
        builder.append(toJson());
    }
}