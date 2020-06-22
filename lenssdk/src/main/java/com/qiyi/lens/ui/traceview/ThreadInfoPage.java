package com.qiyi.lens.ui.traceview;

import android.view.View;

import com.qiyi.lenssdk.R;

/**
 * 展示线程视图信息 与线程名字信息等;
 */
public class ThreadInfoPage extends SearchTextPage {

    ThreadInfoPage(TimeStampInfo info) {
        super(info);
    }

    @Override
    protected void onViewCreated(View rootView) {
        super.onViewCreated(rootView);
        TraceView traceView = rootView.findViewById(R.id.lens_trace_view);
        traceView.setTimeStamp(info);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.lens_thread_info;
    }

    @Override // override to generate search results
    protected CharSequence getDescription() {
        if (info != null) {
            return info.getThreadInfo(searchKey);
        }
        return "";
    }

    @Override
    int getDescriptionTextViewLayout() {
        return R.id.lens_trace_view_text_info;
    }
}
