package com.qiyi.lens.ui.widget;

import androidx.viewpager.widget.ViewPager;

import android.view.View;
import android.view.ViewGroup;

/**
 * bind view pager index with TextViews in view group
 * 高亮选中需要 TextView 自行实现selector
 */
public class ViewPagerTitleBinder implements ViewPager.OnPageChangeListener {
    private ViewPager pager;
    private ViewGroup group;
    private View currentSelect;


    public ViewPagerTitleBinder(ViewPager pager, ViewGroup group) {
        this.pager = pager;
        this.group = group;
        if (pager != null) {
            pager.addOnPageChangeListener(this);
        }
        registerClick();
        doSelectItem(0);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        // do - nothing
    }

    @Override
    public void onPageSelected(int position) {
        //select tab
        updateTextViewSelection(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

        // do - nothing
    }

    private void updateTextViewSelection(int position) {
        int count = pager.getChildCount();
        if (position < 0 || position >= count) {
            return;
        }
        doSelectItem(position);
    }

    private void doSelectItem(int position) {
        if (currentSelect != null) {
            currentSelect.setSelected(false);
        }
        currentSelect = group.getChildAt(position);
        currentSelect.setSelected(true);
    }


    private void selectPage(int index) {
        updateTextViewSelection(index);
        pager.setCurrentItem(index);
    }


    private void registerClick() {


        if (group != null) {
            int count = group.getChildCount();
            for (int i = 0; i < count; i++) {
                View view = group.getChildAt(i);
                view.setOnClickListener(new ClickLis(i));
            }
        }

    }


    class ClickLis implements View.OnClickListener {
        private int index;

        ClickLis(int i) {
            index = i;
        }

        @Override
        public void onClick(View v) {
            selectPage(index);
        }
    }
}
