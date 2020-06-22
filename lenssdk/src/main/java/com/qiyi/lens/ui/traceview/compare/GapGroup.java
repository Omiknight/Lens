package com.qiyi.lens.ui.traceview.compare;

import androidx.annotation.NonNull;

import java.util.Arrays;

public class GapGroup {
    private String tag;
    private int count;
    private long timeStamp;

    public GapGroup(String tag, int count, long timeStamp) {
        this.tag = tag;
        this.count = count;
        this.timeStamp = timeStamp;
    }

    public String getTag() {
        return tag;
    }

    public int getCount() {
        return count;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public boolean isSameTag(GapGroup gapGroup) {
        return gapGroup != null && equals(tag, gapGroup.tag);
    }

    private static boolean equals(Object a, Object b) {
        return (a == b) || (a != null && a.equals(b));
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof GapGroup) {
            return equals(((GapGroup) o).tag, tag) && ((GapGroup) o).count == count;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(new int[]{tag == null ? 0 : tag.hashCode(), count});
    }

    @NonNull
    @Override
    public String toString() {
        return tag + ":" + count;
    }
}
