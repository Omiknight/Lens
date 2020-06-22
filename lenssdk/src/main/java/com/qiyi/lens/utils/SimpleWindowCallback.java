package com.qiyi.lens.utils;

import android.os.Build;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;

public class SimpleWindowCallback implements Window.Callback {
    private Window.Callback origin;

    public SimpleWindowCallback(Window.Callback origin) {
        this.origin = origin;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        return origin != null && origin.dispatchKeyEvent(event);
    }

    @Override
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        return origin != null && origin.dispatchKeyShortcutEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return origin != null && origin.dispatchTouchEvent(event);
    }

    @Override
    public boolean dispatchTrackballEvent(MotionEvent event) {
        return origin != null && origin.dispatchTrackballEvent(event);
    }

    @Override
    public boolean dispatchGenericMotionEvent(MotionEvent event) {
        return origin != null && origin.dispatchGenericMotionEvent(event);
    }

    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        return origin != null && origin.dispatchPopulateAccessibilityEvent(event);
    }

    @Nullable
    @Override
    public View onCreatePanelView(int featureId) {
        return origin != null ? origin.onCreatePanelView(featureId) : null;
    }

    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        return origin != null && origin.onCreatePanelMenu(featureId, menu);
    }

    @Override
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        return origin != null && origin.onPreparePanel(featureId, view, menu);
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        return origin != null && origin.onMenuOpened(featureId, menu);
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        return origin != null && origin.onMenuItemSelected(featureId, item);
    }

    @Override
    public void onWindowAttributesChanged(WindowManager.LayoutParams attrs) {
        if (origin != null) origin.onWindowAttributesChanged(attrs);
    }

    @Override
    public void onContentChanged() {
        if (origin != null) origin.onContentChanged();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (origin != null) origin.onWindowFocusChanged(hasFocus);
    }

    @Override
    public void onAttachedToWindow() {
        if (origin != null) origin.onAttachedToWindow();
    }

    @Override
    public void onDetachedFromWindow() {
        if (origin != null) origin.onDetachedFromWindow();
    }

    @Override
    public void onPanelClosed(int featureId, Menu menu) {
        if (origin != null) origin.onPanelClosed(featureId, menu);
    }

    @Override
    public boolean onSearchRequested() {
        return origin != null && origin.onSearchRequested();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public boolean onSearchRequested(SearchEvent searchEvent) {
        return origin != null && origin.onSearchRequested(searchEvent);
    }

    @Nullable
    @Override
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return origin != null ? origin.onWindowStartingActionMode(callback) : null;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int type) {
        return origin != null ? origin.onWindowStartingActionMode(callback, type) : null;
    }

    @Override
    public void onActionModeStarted(ActionMode mode) {
        if (origin != null) origin.onActionModeStarted(mode);
    }

    @Override
    public void onActionModeFinished(ActionMode mode) {
        if (origin != null) origin.onActionModeFinished(mode);
    }
}
