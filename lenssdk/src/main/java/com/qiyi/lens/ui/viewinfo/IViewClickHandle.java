package com.qiyi.lens.ui.viewinfo;

import androidx.annotation.CallSuper;

import android.view.View;

public class IViewClickHandle {
    private View.OnClickListener mc;

    @CallSuper
    public void onViewClick(View view) {
        if (mc != null) {
            mc.onClick(view);
        }
    }

    void setClick(View.OnClickListener click) {
        mc = click;
    }

    public View.OnClickListener get() {
        return mc;
    }
}
