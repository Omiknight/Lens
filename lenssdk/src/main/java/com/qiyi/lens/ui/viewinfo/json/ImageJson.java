package com.qiyi.lens.ui.viewinfo.json;

import android.graphics.Rect;
import android.view.View;

import com.qiyi.lens.utils.iface.IUIVerifyFactory;

public class ImageJson extends ViewJson {
    public ImageJson(IUIVerifyFactory factory, View view, Rect rect) {
        super(factory, view, rect);
        mType = "image";
    }
}
