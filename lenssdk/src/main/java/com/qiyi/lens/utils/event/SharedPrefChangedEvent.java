package com.qiyi.lens.utils.event;

import com.qiyi.lens.obj.SPItem;

public class SharedPrefChangedEvent {
    public SPItem item;

    public SharedPrefChangedEvent(SPItem item) {
        this.item = item;
    }
}
