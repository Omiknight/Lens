package com.qiyi.lens.ui.abtest.content;

import android.view.View;
import android.view.ViewGroup;

import com.qiyi.lens.ui.abtest.SubPanelView;
import com.qiyi.lens.ui.abtest.Value;

public abstract class ValueContent {
    Value _value;
    ViewGroup _parent;
    String _key;
    SubPanelView _panelView;

    public ValueContent(ViewGroup parent, String key, Value value) {
        _value = value;
        _parent = parent;
        _key = key;
    }

    public void setPanel(SubPanelView panel) {
        _panelView = panel;
    }

    public abstract void loadView();

    public void detachView() {
        if (_parent != null) {
            _parent.removeAllViews();
        }
    }


    /**
     * check if view can be reused
     */
    public boolean tryLoad(String key, Value value) {

        _key = key;
        boolean a = value.isSelectableValue();
        boolean b = _value.isSelectableValue();

        if (a == b) {
            _value = value;
            loadView();
            return true;
        } else {
            //[not same ]
            detachView();
            return false;
        }
    }

    protected int size() {
        return _value.size();
    }

    protected int getChildCount() {
        if (_parent != null) {
            return _parent.getChildCount();
        }
        return 0;
    }

    protected View getChildAt(int index) {
        if (_parent != null && index < _parent.getChildCount()) {
            return _parent.getChildAt(index);
        }
        return null;
    }

}
