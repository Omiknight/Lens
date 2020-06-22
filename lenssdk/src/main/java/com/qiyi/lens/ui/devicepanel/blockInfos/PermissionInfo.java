package com.qiyi.lens.ui.devicepanel.blockInfos;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qiyi.lens.utils.DataPool;
import com.qiyi.lens.ui.FloatingPanel;
import com.qiyi.lens.ui.permission.PermissionPanel;
import com.qiyi.lens.utils.event.DataCallBack;
import com.qiyi.lens.utils.event.EventBus;
import com.qiyi.lenssdk.R;

/**
 * 权限监控
 */
public class PermissionInfo extends AbsBlockInfo implements DataCallBack {

    private TextView tvPermissionInfo;

    public PermissionInfo(FloatingPanel panel) {
        super(panel);
    }

    @Override
    public void bind(View view) {
        EventBus.registerEvent(this, DataPool.EVENT_PERMISSION_REQUEST_SIZE);
    }

    @Override
    public void unBind() {
        EventBus.unRegisterEvent(this, DataPool.EVENT_PERMISSION_REQUEST_SIZE);
    }

    @Override
    public View createView(ViewGroup parent) {
        View root = inflateView(parent, R.layout.lens_block_permission_info);
        tvPermissionInfo = root.findViewById(R.id.tv_permission_info);
        bindBlockClickEvent(root);
        return root;
    }

    @Override
    protected void onBlockClicked() {
        super.onBlockClicked();
        FloatingPanel basePanel = getPanel();
        if (basePanel != null) {
            new PermissionPanel(basePanel).show();
        }
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onDataArrived(Object data, int type) {
        if (data != null) {
            tvPermissionInfo.setText(String.format("监控到%d处权限请求", (Integer) data));
        }
    }
}
