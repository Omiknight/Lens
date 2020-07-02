package com.qiyi.lens.utils.iface;

import androidx.annotation.RestrictTo;
import android.view.View;
import android.view.ViewGroup;

import com.qiyi.lens.LensUtil;

public class ViewDebugActions {
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    public ViewDebugActions(ViewGroup viewGroup) {
    }

    public void add(String name, Runnable action) {
    }

    public void setViewDebugInfo(View view, String info) {
    }

    public void watchObject(Object obj) {
    }


    public void watchObject(String name, Object obj) {

    }

    public void watchField(String name, Object obj) {

    }

    public void exitViewDebug() {
    }

    @RestrictTo(RestrictTo.Scope.LIBRARY)
    public void show() {
    }

    @RestrictTo(RestrictTo.Scope.LIBRARY)
    public void dismiss() {
    }

    public void setViewDebugInfo(View view, String info, int color) {

    }
}
