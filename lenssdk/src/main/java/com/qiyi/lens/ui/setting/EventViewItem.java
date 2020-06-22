package com.qiyi.lens.ui.setting;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.CallSuper;

import com.qiyi.lens.utils.ApplicationLifecycle;
import com.qiyi.lens.utils.iface.IJumpAction;
import com.qiyi.lenssdk.R;

/**
 * 事件任务刷新的基类：
 * 用于捷径
 */
public class EventViewItem implements View.OnClickListener {
    ConfigEventCallBack dataWatcher;
    private String displayValue; // 页面上展示的文字
    int eventId;

    EventViewItem(ConfigEventCallBack changed, String display, int event) {
        this.dataWatcher = changed;
        this.displayValue = display;
        eventId = event;
    }

    @Override
    public void onClick(View v) {
        IJumpAction jumpAction = dataWatcher.jumpAction;
        jumpAction.jump(ApplicationLifecycle.getInstance().getCurrentActivity(), displayValue, eventId);
    }

    public View createView(LayoutInflater inflater, ViewGroup parentView) {
        return inflater.inflate(R.layout.lens_setting_entrance_item, parentView, false);
    }

    @CallSuper
    public void bindView(TextView view) {
        view.setOnClickListener(this);
        view.setText(displayValue);
    }
}
