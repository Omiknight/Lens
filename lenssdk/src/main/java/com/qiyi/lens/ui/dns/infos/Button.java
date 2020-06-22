package com.qiyi.lens.ui.dns.infos;

import android.view.View;

import com.qiyi.lens.utils.reflect.Info;
import com.qiyi.lens.utils.reflect.Invalidate;
import com.qiyi.lens.utils.reflect.SpanableInfo;

import java.util.LinkedList;

public class Button extends Info {
    private int eventId;
    private ClickListener listener;

    public Button(int id, Invalidate par) {
        super(par);
        this.eventId = id;
    }

    @Override
    protected void makeList(LinkedList linkedList) {

    }

    @Override
    protected void preBuildSpannables(StringBuilder stringBuilder, LinkedList<SpanableInfo> infosList) {

    }

    @Override
    protected void afterBuildSpannables(StringBuilder stringBuilder, LinkedList<SpanableInfo> infosList) {

    }

    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onClick(eventId);
        }
    }

    public void setOnClickListener(ClickListener clickListener) {
        listener = clickListener;
    }
}
