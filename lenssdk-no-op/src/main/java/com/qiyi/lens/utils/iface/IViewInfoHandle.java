package com.qiyi.lens.utils.iface;

import android.view.View;

public interface IViewInfoHandle {
    Object[] onViewSelect(View selectedView, Object var1, int var2, int var3);
    public void onViewAnalyse(Object o, int i, int i1, StringBuilder stringBuilder);
    Object[] onViewAnalyse(Object veiw, Object value);
    void onViewDebug(ViewDebugActions viewDebugActions, View view);
}
