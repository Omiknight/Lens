package com.qiyi.lens.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;

import androidx.annotation.Nullable;

import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qiyi.lenssdk.R;

public class TitleBar extends LinearLayout {
    private String title;
    private TextView titleView;

    public TitleBar(Context context) {
        super(context);
        init(context, null);
    }

    public TitleBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public TitleBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setOrientation(VERTICAL);
        LayoutInflater.from(context).inflate(R.layout.lens_title_bar, this);
        titleView = findViewById(R.id.lens_title_view);
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TitleBar);
            title = a.getString(R.styleable.TitleBar_title);
            titleView.setText(title);
            a.recycle();
        }
    }

    public void setTitle(String title) {
        this.title = title;
        this.titleView.setText(title);
    }

    public String getTitle() {
        return title;
    }
}
