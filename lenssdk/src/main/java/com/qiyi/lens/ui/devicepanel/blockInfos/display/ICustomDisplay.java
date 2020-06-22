package com.qiyi.lens.ui.devicepanel.blockInfos.display;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 数据展示模块
 */
public interface ICustomDisplay {

    //创建自己的视图
    View createView(ViewGroup parent);

    // 返回用于展示数据的TextView
    TextView getDisplay();

    //  返回用于过滤数据的 tags
    String[] getFilterTags();

}
