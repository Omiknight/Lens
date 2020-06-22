package com.qiyi.lens.demo;

import android.view.View;

import com.qiyi.lens.utils.iface.IViewInfoHandle;
import com.qiyi.lens.utils.iface.ObjectDescription;
import com.qiyi.lens.utils.iface.ViewDebugActions;

import java.util.UUID;

public class ViewInfoHandle implements IViewInfoHandle {
    @Override
    public Object[] onViewSelect(View selectedView, Object var1, int var2, int var3) {
        return null;
    }

    @Override
    public void onViewAnalyse(Object o, int i, int i1, StringBuilder stringBuilder) {

    }

    @Override
    public Object[] onViewAnalyse(Object view, Object value) {
        return new ObjectDescription[]{new ObjectDescription(value, "Your Message")};
    }

    @Override
    public void onViewDebug(final ViewDebugActions actions, final View view) {
        if (view instanceof MYTextView) {
//            actions.setViewDebugInfo(view, "this is the view debug info");
            actions.add("reload", new Runnable() {
                @Override
                public void run() {
                    ((MYTextView) view).setText(UUID.randomUUID().toString());
                }
            });
            actions.add("clear", new Runnable() {
                @Override
                public void run() {
                    ((MYTextView) view).setText("");
                    actions.exitViewDebug();
                }
            });
        }
    }
}
