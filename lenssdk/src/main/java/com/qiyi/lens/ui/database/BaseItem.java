package com.qiyi.lens.ui.database;

import androidx.annotation.LayoutRes;

public abstract class BaseItem<T> {

    public T data;

    public BaseItem(T data) {
        this.data = data;
    }

    public abstract void onBinding(int position, CommonDBAdapter.ViewPool pool, T data);

    public abstract @LayoutRes
    int getLayout();

    private Object tag;

    public final BaseItem setTag(Object tag) {
        this.tag = tag;
        return this;
    }

    public final Object getTag() {
        return tag;
    }
}
