package com.qiyi.lens.ui.setting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qiyi.lens.utils.SharedPreferenceUtils;
import com.qiyi.lens.utils.iface.ISwitchAction;
import com.qiyi.lenssdk.R;

public class SettingItem extends EventViewItem {

    boolean isEnabled;
    private String mKey;

    SettingItem(Context context, String spKey, String name, int id,
                ConfigEventCallBack changed) {
        super(changed, name, id);
        // load default value
        mKey = spKey;
        if (spKey != null) {
            isEnabled = SharedPreferenceUtils.getSharedPreferences(spKey, context, false);
        }
    }


    @Override
    public View createView(LayoutInflater inflater, ViewGroup parent) {
        return inflater.inflate(R.layout.lens_setting_grid_item, parent, false);
    }

    @Override
    public void bindView(TextView textView) {
        super.bindView(textView);
        textView.setActivated(isEnabled);
    }

    @Override
    public void onClick(View v) {
        updateViewSP(v, mKey);
    }

    private void updateViewSP(View view, String sp) {
        boolean selected = !view.isActivated();
        view.setActivated(selected);
        if (mKey != null) {
            SharedPreferenceUtils.setSharedPreferences(sp, selected, view.getContext());
        }
        notifyStatusChange(selected);
    }

    protected void notifyStatusChange(boolean selected) {
        ISwitchAction switchAction = dataWatcher.switchAction;
        if (switchAction != null) {
            switchAction.onSwitchChange(mKey, eventId, selected);
        }
    }

}
