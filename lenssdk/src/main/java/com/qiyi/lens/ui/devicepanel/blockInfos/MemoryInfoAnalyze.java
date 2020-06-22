package com.qiyi.lens.ui.devicepanel.blockInfos;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.qiyi.lens.ui.ActivityInfoPanel;
import com.qiyi.lens.ui.FloatingPanel;
import com.qiyi.lens.utils.DataPool;
import com.qiyi.lens.utils.event.DataCallBack;
import com.qiyi.lens.utils.event.EventBus;

/**
 * to display activity info : such as witch activity;
 * how many views inside
 * view levels
 */
public class MemoryInfoAnalyze extends AbsBlockInfo implements DataCallBack {
    private TextView textView;
    private Activity currentActivity;

    public MemoryInfoAnalyze(FloatingPanel panel) {
        super(panel);
    }

    @Override
    public void bind(View view) {
        textView = (TextView) view;
        textView.setTextSize(12);
        currentActivity = (Activity) DataPool.obtain().getDataAsset(DataPool.DATA_TYPE_ACTIVITY, String.class);
        //[fix bug : 热启动时候，stamp util 存在值 但是数据却需要刷新的情况]
        EventBus.registerEvent(this, DataPool.DATA_TYPE_ACTIVITY);
        setData();
    }

    @Override
    public void unBind() {
        textView = null;
        currentActivity = null;
        EventBus.unRegisterEvent(this, DataPool.DATA_TYPE_ACTIVITY);
    }

    @Override
    public void onDataArrived(Object data, int type) {
        if (data instanceof Activity) {
            currentActivity = (Activity) data;
            setData();
        }
    }

    private void setData() {
        if (textView != null && currentActivity != null) {
            textView.setText("当前界面：" + currentActivity.getClass().getName());
        }

    }

    @Override
    public void onBlockClicked() {
        FloatingPanel basePanel = getPanel();
        if (basePanel != null) {
            ActivityInfoPanel panel = new ActivityInfoPanel(basePanel);
            panel.show();
        }
    }

}