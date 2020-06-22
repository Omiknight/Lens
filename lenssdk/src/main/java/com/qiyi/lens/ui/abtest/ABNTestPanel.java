package com.qiyi.lens.ui.abtest;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.qiyi.lens.ui.FloatingPanel;
import com.qiyi.lens.ui.FullScreenPanel;
import com.qiyi.lenssdk.R;

/**
 * 页面设计& 交互流程
 * 1，进入页面展示全部的key；
 * if(has more than one : show select list ;
 * else show result panel;
 * panel can be closed;
 * <p>
 * If AB test is configured,  the AB test entrance will be shown on the floating panel;
 * Click the entrance , this panel will show.
 */
public class ABNTestPanel extends FullScreenPanel {

    public ABNTestPanel(FloatingPanel panel) {
        super(panel);
    }

    @Override
    public View onCreateView(ViewGroup group) {
        return inflateView(R.layout.lens_ab_test_panel, group);
    }

    @Override
    public void onViewCreated(View root) {
        super.onViewCreated(root);
        ListView listView = root.findViewById(R.id.lens_ab_test_panel_list);
        ViewGroup group = root.findViewById(R.id.lens_ab_test_edit_sub_panel);
        SubPanelView subPanelView = new SubPanelView(group);
        KeyDataAdapter adapter = new KeyDataAdapter(subPanelView);
        listView.setAdapter(adapter);
        if (adapter.getCount() == 1) {
            adapter.showSelector(0);
        }
    }

}
