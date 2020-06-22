package com.qiyi.lens.utils;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;

import java.util.LinkedList;

/**
 * 给TextView 文本构建不同颜色的字体
 */
public class ColorStringBuilder {
    Spannable spannable;
    StringBuilder builder;
    LinkedList<SpanInfo> colorList;

    public ColorStringBuilder() {
        builder = new StringBuilder();
        colorList = new LinkedList();
    }

    public void append(String var) {
        builder.append(var);
    }

    public void append(char c) {
        builder.append(c);
    }

    public void append(String var, int color) {
        if (var != null && var.length() > 0) {
            int start = builder.length();
            builder.append(var);
            colorList.addLast(new SpanInfo(start, start + var.length(), color));
        }
    }

    public Spannable build() {
        spannable = new SpannableStringBuilder(builder);
        while (!colorList.isEmpty()) {
            SpanInfo info = colorList.pop();
            spannable.setSpan(new ForegroundColorSpan(info.color), info.start, info.end
                    , Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        }

        return spannable;
    }

    public class SpanInfo {
        int start;
        int end;
        int color;

        public SpanInfo(int s, int e, int c) {
            start = s;
            end = e;
            color = c;
        }
    }
}
