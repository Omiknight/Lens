package com.qiyi.lens.ui.database;

import android.view.View;

import com.qiyi.lenssdk.R;


public class NameItem extends BaseItem<String> {

    public NameItem(String data) {
        super(data);
    }

    @Override
    public void onBinding(int position, CommonDBAdapter.ViewPool pool, String data) {
        pool.setVisibility(R.id.lens_common_item_info, View.GONE)
                .setText(R.id.lens_common_item_title, data);
    }

    @Override
    public int getLayout() {
        return R.layout.lens_db_item_common;
    }
}
