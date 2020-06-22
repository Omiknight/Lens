package com.qiyi.lens.ui.viewinfo.uicheck;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.qiyi.lens.Lens;
import com.qiyi.lens.dynamic.LensContext;
import com.qiyi.lens.ui.FloatingPanel;
import com.qiyi.lens.ui.FullScreenPanel;
import com.qiyi.lens.ui.viewinfo.ViewRootLoader;
import com.qiyi.lens.utils.LensConfig;
import com.qiyi.lens.utils.iface.IUIVerifyFactory;

public class UIUploadPanel extends FullScreenPanel {
    private View currentView;
    private IUIVerifyFactory verifyFactory;

    public UIUploadPanel(FloatingPanel panel) {
        super(panel);
        verifyFactory = LensConfig.getInstance().getUIVeryfyFactory();
    }

    public void setCurrentView(View view) {
        currentView = view;
    }

    @Override
    public View onCreateView(ViewGroup group) {
        if (verifyFactory != null) {
            return verifyFactory.onCreateView(UIUploadPanel.this, getActivity());
        }
        return null;
    }

    @Override
    public void onShow() {
        super.onShow();
        if (verifyFactory == null || checkPermission()) {
            dismiss();
            return;
        }

        showProgress();
        prepareData();
    }

    private boolean checkPermission() {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(context, "需要存储权限", Toast.LENGTH_SHORT).show();
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
            return true;
        }
        return false;
    }

    private void prepareData() {
        ViewRootLoader.prepareUIData(verifyFactory, currentView, new ILoadCallback() {
            @Override
            public void onDataLoaded(String json, String file) {

                verifyFactory.onDataPrepared(json, file);

                postUI(new Runnable() {
                    @Override
                    public void run() {
                        dismissProgress();
                    }
                });
//
            }
        });


    }


}
