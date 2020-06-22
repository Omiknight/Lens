package com.qiyi.lens.ui.viewinfo;

import android.view.View;

public class ClickProxy implements View.OnClickListener {

    IViewClickHandle handle;

    public ClickProxy(IViewClickHandle handle, View.OnClickListener lis) {
        this.handle = handle;
        handle.setClick(lis);
    }

    @Override
    public void onClick(View v) {
        handle.onViewClick(v);
    }
}
