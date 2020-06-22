package com.qiyi.lens.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

import com.qiyi.lens.utils.LL;

public class WrapGridView extends GridView {
    int childDemandHeight;
    public WrapGridView(Context context) {
        super(context);

    }

    public WrapGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int heightSpec;

        if (getLayoutParams().height == LayoutParams.WRAP_CONTENT) {
            // The great Android "hackatlon", the love, the magic.
            // The two leftmost bits in the height measure spec have
            // a special meaning, hence we can't use them to describe height.
            heightSpec = MeasureSpec.makeMeasureSpec(
                    Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        }
        else {
            // Any other height should be respected as is.
            heightSpec = heightMeasureSpec;
        }
        super.onMeasure(widthMeasureSpec, heightSpec);
        // only first child is measured;

        int count = getChildCount();
        if(count > 0) {
            View first = getChildAt( 0);
            childDemandHeight = first.getMeasuredHeight();
        }

    }


    @Override
    public void measureChild(View child, int parentWidthMeasureSpec,
                   int parentHeightMeasureSpec){

        super.measureChild(child, parentWidthMeasureSpec, parentHeightMeasureSpec);
        childDemandHeight = child.getMeasuredHeight();

    }
}
