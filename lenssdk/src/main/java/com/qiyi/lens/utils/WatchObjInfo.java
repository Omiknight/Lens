package com.qiyi.lens.utils;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qiyi.lens.ui.FloatingPanel;
import com.qiyi.lens.ui.objectinfo.WatchObjectListAdapter;
import com.qiyi.lens.ui.devicepanel.blockInfos.AbsBlockInfo;
import com.qiyi.lens.utils.event.DataCallBack;
import com.qiyi.lens.utils.event.EventBus;
import com.qiyi.lenssdk.R;

import java.util.Timer;
import java.util.TimerTask;

public class WatchObjInfo extends AbsBlockInfo implements View.OnClickListener, DataCallBack {

    private TextView tvRefresh;
    private WatchObjectListAdapter adapter;
    private Timer timer = new Timer();

    public WatchObjInfo(FloatingPanel panel) {
        super(panel);
    }

    @Override
    public void bind(View view) {
        tvRefresh = view.findViewById(R.id.tv_refresh);
        tvRefresh.setOnClickListener(this);
        RecyclerView rvWatchList = view.findViewById(R.id.rv_watch_list);
        rvWatchList.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new WatchObjectListAdapter(this);
        rvWatchList.setAdapter(adapter);
        EventBus.registerEvent(this, DataPool.EVENT_WATCH_LIST_ADD);
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                tvRefresh.post(new Runnable() {
                    @Override
                    public void run() {
                        refresh();
                    }
                });
            }
        };
        timer.schedule(timerTask, 1000L, 1000L);
    }

    @Override
    public void unBind() {
        EventBus.unRegisterEvent(this, DataPool.EVENT_WATCH_LIST_ADD);
        timer.cancel();
    }

    @Override
    public View createView(ViewGroup group) {
        return inflateView(group, R.layout.lens_block_watch_obj);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == R.id.tv_refresh) {
            refresh();
        }
    }

    @Override
    public void onDataArrived(Object data, int type) {
        adapter.onDataChange();
        timer.cancel();
    }

    private void refresh() {
        adapter.onDataChange();
    }
}
