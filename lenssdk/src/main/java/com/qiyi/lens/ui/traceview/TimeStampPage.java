package com.qiyi.lens.ui.traceview;

import com.qiyi.lens.utils.ColorStringBuilder;

public class TimeStampPage extends SearchTextPage {
    public TimeStampPage(TimeStampInfo info) {
        super(info);
    }

    protected CharSequence getDescription() {
        ColorStringBuilder stringBuilder = new ColorStringBuilder();
        info.getStampInfo(stringBuilder, searchKey);
        return stringBuilder.build();
    }

}
