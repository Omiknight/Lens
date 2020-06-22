package com.qiyi.lens.utils.reflect;

public class SpanableInfo {
    public int star;
    public int end;
    public Info clickSpan;

    public SpanableInfo(int a, int b, Info obj) {
        star = a;
        end = b;
        clickSpan = obj;
    }

    public boolean isClickable() {
        return !clickSpan.isBasicType();
    }

}
