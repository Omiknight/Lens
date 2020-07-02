package com.qiyi.lens.ui.abtest.content;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qiyi.lens.ui.abtest.Value;
import com.qiyi.lens.utils.UIUtils;
import com.qiyi.lenssdk.R;

/**
 * 支持选择方式的展示内容数据
 * 采用文本行高亮展示的方式
 * AB test module: used for selecting a value from a group
 */
public class RadioBoxContent extends ValueContent implements View.OnClickListener {

    public RadioBoxContent(ViewGroup parent, String key, Value value) {
        super(parent, key, value);
    }


    @Override
    public void loadView() {
        String[] vars = _value.toContentVars();
        if (vars == null) {
            vars = new String[]{"value type error!"};
        }

        //[do load views]
        //[reuse views]
        int count = getChildCount();

        if (count == 0 || count == vars.length) {
            bindViews(vars, null);
        } else {
            int needSize = Math.min(vars.length, count);
            View[] cached = new View[vars.length];
            for (int i = 0; i < needSize; i++) {
                cached[i] = getChildAt(i);
            }
            detachView();
            bindViews(vars, cached);
        }

    }

    // 现在就直接用text view 实现了
    private void bind(View target, boolean hightLight, String value) {

        TextView textView = (TextView) target;
        int color = hightLight ? 0xFF2dbb55 : Color.BLACK;
        int testSize = hightLight ? 16 : 14;
        textView.setTextSize(testSize);
        textView.setTextColor(color);
        textView.setText(value);

    }


    private void bindViews(String vars[], View[] cached) {
        int p = 0;

        for (String s : vars) {
            View target;
            if (cached == null) {
                target = getChildAt(p);
            } else {
                target = cached[p];
            }

            if (target == null) {
                target = //new TextView(_parent.getContext());
                        UIUtils.inflateVew(_parent, R.layout.lens_radio_select_item_view, false);
            }
            target.setId(p);
            target.setOnClickListener(this);
            if (target.getParent() != _parent) {
                _parent.addView(target);
            }

            //[seleted ? ]
            bind(target, _value.getIndex(_key) == p, s);
            p++;
        }

    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        _value.setIndex(_key, id);
        String[] vars = _value.toContentVars();
        if(vars != null) {
            bindViews(vars, null);
        }

    }
}
