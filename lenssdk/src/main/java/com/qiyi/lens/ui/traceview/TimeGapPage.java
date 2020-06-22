package com.qiyi.lens.ui.traceview;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.qiyi.lens.ui.widget.DataViewLoader;
import com.qiyi.lens.utils.SearchBoxActions;
import com.qiyi.lens.utils.TextWidthFixer;
import com.qiyi.lens.utils.UIUtils;
import com.qiyi.lenssdk.R;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TimeGapPage extends DataViewLoader {
    private Context context;
    private List<TimeGap> gaps;
    private TextWidthFixer widthFixer = TextWidthFixer.getInstance();
    private TimeGapAdapter adapter;
    private SearchBoxActions actions;
    private String searchKey;
    private boolean dataChanged = true;
    private int minHeight = 40;
    private SparseArray<Comparator<TimeGap>> comparator = new SparseArray<>();

    {
        comparator.put(R.id.lens_cost, new Comparator<TimeGap>() {
            @Override
            public int compare(TimeGap o1, TimeGap o2) {
                return o1.duration - o2.duration;
            }
        });
        comparator.put(R.id.lens_cput, new Comparator<TimeGap>() {
            @Override
            public int compare(TimeGap o1, TimeGap o2) {
                return o1.cpuDuration - o2.cpuDuration;
            }
        });
        comparator.put(R.id.lens_st, new Comparator<TimeGap>() {
            @Override
            public int compare(TimeGap o1, TimeGap o2) {
                return (int) (o1.timeStamp - o2.timeStamp);
            }
        });
        comparator.put(R.id.lens_name, new Comparator<TimeGap>() {
            @Override
            public int compare(TimeGap o1, TimeGap o2) {
                return o1.tag.compareTo(o2.tag);
            }
        });
    }

    private View.OnClickListener sortBy = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Collections.sort(gaps, comparator.get(v.getId()));
            if (v.isSelected()) {
                Collections.reverse(gaps);
            }
            adapter.setData(gaps);
            adapter.notifyDataSetChanged();
            v.setSelected(!v.isSelected());
        }
    };

    public TimeGapPage(Context context, TimeStampInfo info) {
        this.context = context;
        this.gaps = info.getGaps();
        minHeight = UIUtils.dp2px(context, 35);

    }

    @Override
    protected void onViewCreated(View rootView) {
        ViewGroup header = rootView.findViewById(R.id.lens_list_label);
        TextView id = header.findViewById(R.id.lens_id);
        TextView cost = header.findViewById(R.id.lens_cost);
        TextView cput = header.findViewById(R.id.lens_cput);
        TextView st = header.findViewById(R.id.lens_st);
        TextView tag = header.findViewById(R.id.lens_name);


        fixWidth(id, 3, true);
        fixWidth(cost, 5, false);
        fixWidth(cput, 6, false);
        fixWidth(st, 6, false);
        fixWidth(tag, 6, false);
        cost.setOnClickListener(sortBy);
        cput.setOnClickListener(sortBy);
        st.setOnClickListener(sortBy);
        tag.setOnClickListener(sortBy);

        ListView listView = rootView.findViewById(R.id.lens_list_view);
        adapter = new TimeGapAdapter(context);
        adapter.setData(gaps);
        listView.setAdapter(adapter);


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

    }

    private void fixWidth(TextView textView, int width, boolean append) {
        textView.setText(widthFixer.fix(textView.getText().toString(), width, append));
        textView.setMinHeight(minHeight);
        textView.setTextSize(10);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.lens_trace_view_search_list_view;
    }

    private void loadSeachResult() {
        if (dataChanged) {
            adapter.updateSearchKey(searchKey);
            adapter.notifyDataSetChanged();
        }
    }
}
