package com.qiyi.lens.ui.database;

import android.view.View;
import android.view.ViewGroup;

import com.qiyi.lens.ui.FloatingPanel;
import com.qiyi.lenssdk.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class DatabaseTableListPanel extends DatabasePanel {

    DatabaseTableListPanel(FloatingPanel panel) {
        super(panel);
    }

    @Override
    protected View onCreateView(ViewGroup viewGroup) {
        setBase(false);
        return super.onCreateView(viewGroup);
    }

    void refreshTables(BaseItem item) {
        if (item.data instanceof String) {
            setTitle((String) item.data);
        }
        if (item instanceof DBItem) {
            final int key = ((DBItem) item).key;
            List<String> tables = LensProvider.get().getDatabases().getTableNames(key);
            Collections.sort(tables);
            List<BaseItem> data = new ArrayList<>(tables.size());
            data.add(new TitleItem(String.format(Locale.getDefault(),
                    "%d TABLES", tables.size())));
            for (int i = 0; i < tables.size(); i++) {
                data.add(new NameItem(tables.get(i)));
            }
            getAdapter().setItems(data);

            getAdapter().setListener(new CommonDBAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(int position, BaseItem item) {
                    if (item instanceof NameItem) {
                        DatabaseTablePanel tablePanel = new DatabaseTablePanel(getFloatingPanel());
                        tablePanel.initCondition((NameItem) item, key);
                        tablePanel.show();
                    }
                }
            });
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.len_title_bar_back) {
            dismiss();
        }
    }

}
