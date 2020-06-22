package com.qiyi.lens.dynamic;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.view.LayoutInflater;

/**
 * sdk-no-op 的 LensContext 实现，主要是封装 lens 的 resources 给 Panel 使用
 */
public class LensContext extends ContextWrapper {
    private static LensContext sLensContext;
    private Resources mResources;
    private Resources.Theme mTheme;
    private LayoutInflater mLayoutInflater;

    public static Context get() {
        return sLensContext;
    }

    public LensContext(Context base, Resources resources) {
        super(base);
        mResources = resources;
        sLensContext = this;
    }

    @Override
    public Resources getResources() {
        return mResources;
    }

    @Override
    public AssetManager getAssets() {
        return mResources.getAssets();
    }

    @Override
    public Resources.Theme getTheme() {
        if (mTheme == null) {
            mTheme = mResources.newTheme();
            mTheme.setTo(getBaseContext().getTheme());
        }
        return mTheme;
    }

    @Override
    public void setTheme(int resid) {
        getTheme().applyStyle(resid, true);
    }

    @Override
    public Context getApplicationContext() {
        return this;
    }

    public Application getApplication() {
        if (getBaseContext() instanceof Application) {
            return (Application) getBaseContext();
        } else if (super.getApplicationContext() instanceof Application) {
            return (Application) super.getApplicationContext();
        }
        throw new NullPointerException();
    }

    @Override
    public Object getSystemService(String name) {
        if (Context.LAYOUT_INFLATER_SERVICE.equals(name)) {
            if (mLayoutInflater == null) {
                mLayoutInflater = (LayoutInflater) super.getSystemService(name);
                mLayoutInflater = mLayoutInflater.cloneInContext(this);
            }
            return mLayoutInflater;
        }
        return super.getSystemService(name);
    }
}