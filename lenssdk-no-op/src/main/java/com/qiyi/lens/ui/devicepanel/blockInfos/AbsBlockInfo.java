package com.qiyi.lens.ui.devicepanel.blockInfos;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public abstract class AbsBlockInfo  {
    public View createView(ViewGroup parent) {
        return null;
    }
}
