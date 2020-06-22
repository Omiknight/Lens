package com.qiyi.lens.ui.traceview.compare;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qiyi.lens.utils.DataPool;
import com.qiyi.lens.ui.FullScreenPanel;
import com.qiyi.lens.utils.TimeStampUtil;
import com.qiyi.lenssdk.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class SelectLaunchTimePanel extends FullScreenPanel implements View.OnClickListener {
    @SuppressLint("SimpleDateFormat")
    private DateFormat mDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private TimeStampUtilDao dao;

    public SelectLaunchTimePanel() {
        super(null);
    }

    @Override
    protected View onCreateView(ViewGroup viewGroup) {
        final View view = inflateView(R.layout.lens_select_launch_time_panel, viewGroup);
        final ViewGroup container = view.findViewById(R.id.lens_history_launch_container);
        dao = new TimeStampUtilDao(context);
        dao.readAll(new TimeStampUtilDao.Callback<List<LaunchRecord>>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResult(List<LaunchRecord> data) {
                for (LaunchRecord record : data) {
                    View view = LayoutInflater.from(context).inflate(R.layout.lens_compare_select_launch_item, null);
                    ((TextView) view.findViewById(R.id.lens_time_view)).setText(mDateFormat.format(record.getTime()));
                    ((TextView) view.findViewById(R.id.lens_cost_view)).setText(record.getTotalTime() + "ms");
                    view.setTag(record.getId());
                    view.setOnClickListener(SelectLaunchTimePanel.this);
                    container.addView(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                }
            }
        });
        return view;
    }

    @Override
    public void onClick(View v) {
        int id = (int) v.getTag();

        final TimeStampUtil a = (TimeStampUtil) DataPool.obtain().getData(DataPool.DATA_TYPE_LAUNCH_TIME);
        dao.read(id, new TimeStampUtilDao.Callback<TimeStampUtil>() {
            @Override
            public void onResult(final TimeStampUtil da) {
                new LaunchTimeComparePanel(a, da).show();
            }
        });
    }
}
