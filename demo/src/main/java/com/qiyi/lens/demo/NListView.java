package com.qiyi.lens.demo;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ListView;

public class NListView extends ListView {
    public NListView(Context context) {
        super(context);
        setBackgroundColor(0xff998877);
    }

    public NListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(0xff998877);
    }

    public NListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setBackgroundColor(0xff998877);
    }


    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }



    @Override
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }


}
