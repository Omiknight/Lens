package com.qiyi.lens.ui.viewinfo;

import android.graphics.PixelFormat;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.qiyi.lens.Constants;
import com.qiyi.lens.ui.FloatingPanel;
import com.qiyi.lens.ui.FullScreenPanel;
import com.qiyi.lens.utils.Utils;
import com.qiyi.lenssdk.R;

/**
 * 视图拾取功能
 */
public class SelectViewPanel extends FullScreenPanel {
    private SelectWidgetView selectWidgetView;//
    private View topView;
    private boolean isActivityRoot;

    public SelectViewPanel(FloatingPanel panel) {
        super(panel);
        enableAnimation = false;
        topView = ViewRootLoader.getCurrentTopView();
        if (topView != null && ViewRootLoader.isActivityRoot(topView)) {
            topView = topView.findViewById(android.R.id.content);
            isActivityRoot = true;
        }
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    protected boolean onBackPressed() {
        if (isAdded) {
            dismiss();
            return true;
        }
        return super.onBackPressed();
    }

    @Override
    protected View onCreateView(ViewGroup viewGroup) {
        viewGroup.setId(R.id.lens_select_view_panel_root);
        selectWidgetView = new SelectWidgetView(getContext(), topView);
        return selectWidgetView;
    }

    public void showRelativePos(boolean ifShow) {
        selectWidgetView.setShowRelativePosition(ifShow);
    }

    public void showSibling(boolean ifShow) {
        selectWidgetView.setShowSibling(ifShow);
    }

    public void selectParent() {
        selectWidgetView.selectParent();
    }

    public void selectListRow(View view) {
        selectWidgetView.selectListRow(view);
    }

    public void selectNext() {
        selectWidgetView.selectNextWidget();
    }

    @Override
    public int getPanelType() {
        return Utils.hasFloatingWindowPermission() ? Constants.PANEL_SELECT_VIEW_PANEL_WINDOW : Constants.PANEL_SELECT_VIEW_PANEL;
    }


    @Override
    public void onPause() {
        FloatingPanel panel = getFloatingPanel();
        if (panel != null) panel.hide();
    }


    @Override
    public void onResume() {
        FloatingPanel panel = getFloatingPanel();
        if (panel != null) panel.expand();
    }

    @Override
    protected WindowManager.LayoutParams getDefaultLayoutParams() {
        WindowManager.LayoutParams wlp = new WindowManager.LayoutParams();
        wlp.width = -1;
        wlp.height = -1;
        wlp.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;//WindowManager.LayoutParams.FLAG_FULLSCREEN
        if (isActivityRoot) {
            wlp.type = WindowManager.LayoutParams.TYPE_APPLICATION_SUB_PANEL;
        } else if (Build.VERSION.SDK_INT >= 26) {
            wlp.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        } else {
            wlp.type = WindowManager.LayoutParams.TYPE_PHONE;
        }
        //WindowManager.LayoutParams.TYPE_APPLICATION_PANEL;
        wlp.gravity = Gravity.TOP | Gravity.LEFT;
        wlp.format = PixelFormat.RGBA_8888;
        return wlp;
    }

    public boolean shouldBringTofront() {
        if (Utils.hasFloatingWindowPermission()) return !isActivityRoot;
        else return true;
    }
}
