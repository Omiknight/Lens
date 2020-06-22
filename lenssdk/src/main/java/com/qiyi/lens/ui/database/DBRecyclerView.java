package com.qiyi.lens.ui.database;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.View;
import android.widget.BaseAdapter;

public class DBRecyclerView extends RecyclerView {
    public DBRecyclerView(Context context) {
        super(context);
    }

    public DBRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DBRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private RvContextMenuInfo contextMenuInfo;

    @Override
    protected ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return contextMenuInfo;
    }

    @Override
    public boolean showContextMenuForChild(View originalView) {
        // only valid for the direct child
        if (indexOfChild(originalView) == -1) {
            return false;
        }
        final int position = getChildAdapterPosition(originalView);
        RecyclerView.Adapter adapter = getAdapter();
        if (position >= 0 && adapter != null) {
            final long itemId = adapter.getItemId(position);
            contextMenuInfo = new RvContextMenuInfo(originalView, position, itemId);
            return super.showContextMenuForChild(originalView);
        }
        return false;
    }

    public static class RvContextMenuInfo implements ContextMenu.ContextMenuInfo {

        RvContextMenuInfo(View targetView, int position, long id) {
            this.targetView = targetView;
            this.position = position;
            this.id = id;
        }

        View targetView;
        public int position;
        public long id;
    }
}
