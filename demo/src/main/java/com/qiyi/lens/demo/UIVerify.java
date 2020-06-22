package com.qiyi.lens.demo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;

import com.qiyi.lens.utils.iface.IJsonCompiler;
import com.qiyi.lens.utils.iface.IPanel;
import com.qiyi.lens.utils.iface.IUIVerifyFactory;

public class UIVerify implements IUIVerifyFactory {
    @Override
    public void onJsonBuild(Activity activity, IJsonCompiler json) {
        if (activity != null) {
            json.addPair("activity", activity.getClass().getSimpleName());
            View view = activity.findViewById(android.R.id.content);
            if (view != null) {
                json.addPair("width", view.getWidth());
                json.addPair("height", view.getHeight());
            }
        }

    }

    @Override
    public void onJsonBuildView(View view, IJsonCompiler json) {

    }

    @Override
    public boolean onJsonBuildDrawable(Drawable drawable, IJsonCompiler jsonCompiler) {

        return false;
    }

    @Override
    public View onCreateView(IPanel panel, Context context) {
        View view = new View(context);

        view.setBackgroundColor(Color.WHITE);
        return view;
    }

    // call set data to Server
    @Override
    public void onDataPrepared( String data, String filePath) {

    }
}
