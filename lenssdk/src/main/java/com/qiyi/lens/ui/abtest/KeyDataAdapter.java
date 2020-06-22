package com.qiyi.lens.ui.abtest;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.qiyi.lens.utils.ApplicationLifecycle;
import com.qiyi.lens.utils.UIUtils;
import com.qiyi.lens.utils.configs.ABNTestConfig;

/**
 * use in SP model & AB test model
 */
public class KeyDataAdapter extends BaseAdapter implements View.OnClickListener {

    private String[] keys;
    private SubPanelView subPanelView;
    private int textViewPadding = 10;
    private int selectedIndex = -1;

    KeyDataAdapter(SubPanelView subPanelView) {
        keys = ABNTestConfig.getInstance().getKeys();
        this.subPanelView = subPanelView;
        textViewPadding = UIUtils.dp2px(ApplicationLifecycle.getInstance().getContext(), 8);
    }

    @Override
    public int getCount() {
        return keys == null ? 0 : keys.length;
    }

    @Override
    public Object getItem(int position) {
        if (keys != null && position < getCount()) {
            return keys[position];
        }
        return "error";
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;
        if (convertView == null) {
            TextView view = new TextView(parent.getContext());

            view.setGravity(Gravity.CENTER);
            view.setMaxLines(1);
            view.setPadding(0, textViewPadding, 0, textViewPadding);
            textView = view;
        } else {
            textView = (TextView) convertView;
        }

        if (selectedIndex == position) {
            textView.setTextColor(Color.RED);
            textView.setTextSize(18);
        } else {
            textView.setTextSize(16);
            textView.setTextColor(Color.BLACK);
        }


        //bind
        textView.setText(keys[position]);
        textView.setId(position);
        textView.setOnClickListener(this);
        return textView;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id >= 0 && id < getCount()) {
            //[show panel]
            showSelector(id);
        }

    }

    public void showSelector(int index) {
        String key = keys[index];
        selectedIndex = index;
        Value value = ABNTestConfig.getInstance().getValue(key);
        if (value != null) {
            subPanelView.showData(key, value);
            notifyDataSetChanged();
        }
    }
}
