package com.qiyi.lens.ui.traceview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.CallSuper;

import com.qiyi.lens.ui.widget.DataViewLoader;
import com.qiyi.lens.utils.SearchBoxActions;
import com.qiyi.lenssdk.R;

/**
 * 搜索按钮，搜索后 高亮显示文字
 */
public abstract class SearchTextPage extends DataViewLoader {
    TimeStampInfo info;
    private TextView textView;// detail info
    private SearchBoxActions actions;
    String searchKey;
    private boolean dataChanged = true;


    public SearchTextPage(TimeStampInfo info) {
        this.info = info;
    }

    @Override
    @CallSuper
    protected void onViewCreated(View rootView) {
        textView = rootView.findViewById(getDescriptionTextViewLayout());
        actions = new SearchBoxActions((ViewGroup) rootView.findViewById(R.id.lens_seach_box_container)) {
            @Override
            public void onSearch(String text) {
                if (text != null) {
                    if (text.length() == 0) {
                        text = null;
                    } else {
                        text = text.toLowerCase();
                    }
                }
                dataChanged = keyChanged(searchKey, text);
                searchKey = text;
                loadSeachResult();
            }
        };

        loadSeachResult();
    }


    abstract CharSequence getDescription();

    int getDescriptionTextViewLayout() {
        return R.id.lens_task_info;
    }

    private void loadSeachResult() {
        if (dataChanged) {
            textView.setText(getDescription());
        }
    }

    @Override
    public int getLayoutRes() {
        return R.layout.lens_time_search_view;
    }


}
