package com.qiyi.lens.ui.devicepanel.blockInfos.display;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public interface ICustomDisplay {

    public View createView(ViewGroup parent);
    public TextView getDisplay();

}
