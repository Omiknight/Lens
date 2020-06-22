package com.qiyi.lens.ui.database;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.widget.TextView;

import com.qiyi.lenssdk.R;


public class GridItem extends BaseItem<String> {

    public boolean isColumnName;
    private boolean isPrimaryKey;
    public String primaryKeyValue;
    public String columnName;

    public void setIsPrimaryKey() {
        isPrimaryKey = true;
    }

    public boolean isEnable() {
        return !isColumnName && !isPrimaryKey && !Column.ROW_ID.equals(columnName);
    }

    public GridItem(String columnValue, String primaryKeyValue, String columnName) {
        super(columnValue);
        this.primaryKeyValue = primaryKeyValue;
        this.columnName = columnName;
    }

    public GridItem(String data, boolean isColumnName) {
        super(data);
        this.isColumnName = isColumnName;
    }

    @Override
    public void onBinding(int position, CommonDBAdapter.ViewPool pool, String data) {
        TextView itemText = pool.getView(R.id.lens_gird_text);
        Context context = itemText.getContext();
        itemText.setTypeface(null,
                TextUtils.isEmpty(data) ? Typeface.ITALIC : Typeface.NORMAL);
        itemText.setTextColor(TextUtils.isEmpty(data) ?
                context.getResources().getColor(R.color.lens_label) : Color.BLACK);
        pool.setText(R.id.lens_gird_text, TextUtils.isEmpty(data) ? "NULL" : data);
        pool.setBackgroundColor(R.id.lens_gird_text, !isEnable() ?
                context.getResources().getColor(R.color.lens_item_key) : Color.WHITE);
    }

    @Override
    public int getLayout() {
        return R.layout.lens_item_table_cell;
    }
}
