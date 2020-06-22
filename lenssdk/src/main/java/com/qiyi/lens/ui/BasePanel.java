package com.qiyi.lens.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qiyi.lens.dynamic.LensContext;
import com.qiyi.lens.utils.ApplicationLifecycle;
import com.qiyi.lens.utils.SimpleWindowCallback;
import com.qiyi.lens.utils.iface.IPanel;


public abstract class BasePanel implements IPanel {
    protected boolean isAdded;
    protected Context context;
    ViewManager.IViewManager viewManager;
    ViewGroup mDecorView;
    private Handler handler = new Handler(Looper.getMainLooper());

    public BasePanel() {
        context = LensContext.get();
        // 兼容没有老版本 lens，没有调用 Lens.init 方法
        if (context == null) {
            context = ApplicationLifecycle.getInstance().getContext();
        }
        Activity activity = getActivity();
        activity.getWindow().setCallback(new SimpleWindowCallback(activity.getWindow().getCallback()) {
            @Override
            public boolean dispatchKeyEvent(KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
                    BasePanel topPanel = PanelManager.getInstance().getTopPanel();
                    return (topPanel != null && topPanel.onBackPressed()) || super.dispatchKeyEvent(event);
                } else {
                    return super.dispatchKeyEvent(event);
                }
            }
        });
    }

    public Context getContext() {
        return context;
    }

    public Activity getActivity() {
        return ApplicationLifecycle.getInstance().getCurrentActivity();
    }

    public Handler getMainHandler() {
        return handler;
    }

    protected View createView() {
        return null;
    }

    protected void onViewCreated(View root) {

    }

    public void reattach(Activity activity) {
        if (mDecorView != null) {
            // closed
            viewManager.removeView(mDecorView);
            viewManager = ViewManager.create(this);
            viewManager.addView(mDecorView, mDecorView.getLayoutParams());
            isAdded = true;
        } else {
            // 更新 viewManager，随时可以触发 show 展示
            viewManager = ViewManager.create(this);
        }
    }

    public void show() {
        if (!isAdded) {
            isAdded = true;
            viewManager = ViewManager.create(this);
            View view = createView();
            this.mDecorView = (ViewGroup) view;
            onViewCreated(view);
            if (view != null) {
                view.setClickable(true);
                ViewGroup.LayoutParams clp = getDefaultLayoutParams();
                viewManager.addView(view, clp);
                PanelManager.getInstance().register(this, getPanelType());
                onShow();
            }
        }
    }

    protected void onShow() {

    }

    protected abstract ViewGroup.LayoutParams getDefaultLayoutParams();

    // content view to be dismissed
    public void dismiss() {
        if (isAdded) {
            viewManager.removeView(mDecorView);
            PanelManager.getInstance().removePanel(this);
            isAdded = false;
            mDecorView = null;
        }
    }

    protected View findViewById(int id) {
        if (mDecorView != null) {
            return mDecorView.findViewById(id);
        }
        return null;
    }

    public View getDecorView() {
        return mDecorView;
    }

    public View getContentView() {
        return mDecorView;
    }

    protected View inflateView(int id, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(id, parent, false);
    }

    protected abstract int getPanelType();

    protected boolean onBackPressed() {
        return false;
    }

    protected void postUI(Runnable runnable){
        getMainHandler().post(runnable);
    }
    protected void onPause(){}
    protected void onResume(){}
}
