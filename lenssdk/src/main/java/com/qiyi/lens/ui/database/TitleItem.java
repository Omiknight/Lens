package com.qiyi.lens.ui.database;


import com.qiyi.lenssdk.R;

public class TitleItem extends BaseItem<String> {
    public TitleItem(String data) {
        super(data);
    }

    @Override
    public void onBinding(int position, CommonDBAdapter.ViewPool pool, String data) {
        pool.setText(R.id.lens_item_title_id, data);
    }

    @Override
    public int getLayout() {
        return R.layout.lens_item_title;
    }
}
