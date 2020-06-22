package com.qiyi.lens.ui.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;

public abstract class DataViewLoader {
    private View cached;

    public View loadView(ViewGroup group) {
        if (cached != null) {
            return cached;
        }
        return createView(group, getLayoutRes());
    }

    protected View createView(ViewGroup group, @LayoutRes int layoutId) {
        View view = LayoutInflater.from(group.getContext()).inflate(layoutId, group, false);
        onViewCreated(view);
        return view;
    }

    protected abstract void onViewCreated(View rootView);

    public abstract @LayoutRes
    int getLayoutRes();

    // 用于判断两个字串是否改变
    protected final boolean keyChanged(String a, String b) {
        // keep ==
        if (a == b) {
            return false;
        } else if (a == null) {
            return true;
        }

        return !a.equals(b);
    }

}
