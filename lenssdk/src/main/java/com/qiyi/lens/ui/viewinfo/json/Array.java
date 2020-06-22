package com.qiyi.lens.ui.viewinfo.json;

public class Array implements IJson {
    private IJson mArray[];

    public Array(IJson[] array) {
        mArray = array;
    }

    @Override
    public String toJson() {
        StringBuilder stringBuilder = new StringBuilder();
        buildJson(stringBuilder);
        return stringBuilder.toString();
    }

    private void buildJson(StringBuilder stringBuilder) {
        if (mArray != null && mArray.length > 0) {
            stringBuilder.append('[');
            for (IJson json : mArray) {
                stringBuilder.append(json.toJson());
                stringBuilder.append(',');
            }
            stringBuilder.setLength(stringBuilder.length() - 1);
            stringBuilder.append(']');
        } else {
            stringBuilder.append("[]");
        }
    }

    @Override
    public void toJson(StringBuilder stringBuilder) {
        buildJson(stringBuilder);
    }
}
