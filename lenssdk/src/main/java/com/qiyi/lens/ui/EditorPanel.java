package com.qiyi.lens.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.qiyi.lens.obj.SPItem;
import com.qiyi.lens.utils.DataPool;
import com.qiyi.lens.utils.event.SharedPrefChangedEvent;
import com.qiyi.lenssdk.R;

public class EditorPanel extends FullScreenPanel implements View.OnClickListener {

    private Context mContext;
    private EditText mEditText;
    private String originData;
    private SPItem spItem;

    public EditorPanel(FloatingPanel panel) {
        super(panel);
        mContext = context;
    }

    public void bindData(SPItem item) {
        if (item != null) {
            spItem = item;
            originData = item.value;
        }
    }

    @Override
    protected View onCreateView(ViewGroup viewGroup) {
        View content = inflateView(R.layout.lens_editor_panel, viewGroup);
        TextView operation = content.findViewById(R.id.len_title_bar_operation);
        operation.setText(mContext.getString(R.string.lens_common_title_bar_save));
        operation.setVisibility(View.VISIBLE);
        operation.setOnClickListener(this);
        content.findViewById(R.id.len_title_bar_back).setOnClickListener(this);
        TextView title = content.findViewById(R.id.len_title_bar_title);
        title.setText(mContext.getString(R.string.lens_common_title_bar_edit));
        mEditText = content.findViewById(R.id.lens_edit);
        mEditText.setLineSpacing(0, 1.2f);
        mEditText.setSelection(mEditText.getText().length());
        return content;
    }

    @Override
    public void onViewCreated(View root) {
        super.onViewCreated(root);
        mEditText.setText(originData);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.len_title_bar_back) {
            dismiss();
        } else if (id == R.id.len_title_bar_operation) {
            String curValue = mEditText.getText().toString();
            if (TextUtils.equals(curValue, originData)) {
                showToast(mContext.getString(R.string.lens_edit_toast_save_fail));
            } else {
                if (spItem != null) {
                    spItem.newValue = curValue;
                    notifyResult(spItem);
                }
            }
            dismiss();
        }
    }

    @Override
    public void showToast(String data) {
        Toast.makeText(mContext, data, Toast.LENGTH_SHORT).show();
    }

    private void notifyResult(SPItem item) {
        DataPool.obtain().putData(DataPool.EVENT_EDIT_SHARED_PREFERENCES, new SharedPrefChangedEvent(item));
    }
}
