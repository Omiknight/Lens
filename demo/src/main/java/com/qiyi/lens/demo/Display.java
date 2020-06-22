package com.qiyi.lens.demo;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qiyi.lens.ui.devicepanel.blockInfos.display.ICustomDisplay;

/**
 * 定制Lens 数据展示项：
 * KeyLog的信息会自动输出到 这个面板上。
 */
public class Display implements ICustomDisplay {
    private TextView textView;
    @Override
    public View createView(ViewGroup parent) {
        LinearLayout linearLayout = new LinearLayout(parent.getContext());
        linearLayout.setMinimumHeight(200);
        linearLayout.setBackgroundColor(Color.BLUE);
        TextView textView = new TextView(parent.getContext());
        textView.setMinHeight(100);
        linearLayout.addView(textView);
        this.textView = textView;
        return linearLayout;
    }

    @Override
    public TextView getDisplay() {
        return textView;
    }

    @Override
    public String[] getFilterTags() {
        return new String[]{"uu"};
    }
}
