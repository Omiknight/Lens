package com.qiyi.lens.utils.reflect;

import android.app.Fragment;

import androidx.viewpager.widget.ViewPager;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.qiyi.lens.utils.ViewClassifyUtil;
import com.qiyi.lens.utils.iface.IFragmentHandle;

import java.util.LinkedList;

public class FragmentInfo extends FieldInfo {


    private ViewClassifyUtil util;
    private IFragmentHandle handle;

    public FragmentInfo(Object obj, SparseArray hashMap, Invalidate par) {
        super(obj, hashMap, par);
    }

    @Override
    public void makeList(LinkedList linkedList, boolean allInherited, boolean filterDuplicated) {
        //[find view pager of this fragment]
        if (list == null) {
            list = new LinkedList<>();
        } else {
            list.clear();
        }
        LinkedList<ViewPager> pagers = util.getPagers();
        if (pagers != null) {
            View view = getFragmentRootView(value);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                ViewPager pager = findChildPager(viewGroup, pagers);
                if (pager != null) {

                    ViewPagerInfo pagerInfo = new ViewPagerInfo(pager, hashMap, this);
                    pagerInfo.setUtils(util, handle);
                    pagerInfo.setLevel(level);
                    list.add(pagerInfo);
                }
            }
        }


    }

    public void setUtil(ViewClassifyUtil util, IFragmentHandle handle) {
        this.util = util;
        this.handle = handle;
    }


    private View getFragmentRootView(Object value) {
        if (value instanceof Fragment) {
            Fragment fragment = (Fragment) value;
            return fragment.getView();
        } else if (value instanceof androidx.fragment.app.Fragment) {
            androidx.fragment.app.Fragment fragment = (androidx.fragment.app.Fragment) value;
            return fragment.getView();
        }

        return null;
    }


    private ViewPager findChildPager(ViewGroup group, LinkedList<ViewPager> pagers) {

        ViewPager thePager = null;
        if (pagers != null) {
            int minLevel = Integer.MAX_VALUE;

            for (ViewPager pager : pagers) {

                int level = getLevel(pager, group);
                if (level < minLevel) {
                    thePager = pager;
                    minLevel = level;
                }

            }

        }
        return thePager;

    }


    private int getLevel(View view, ViewGroup parent) {

        int level = 0;
        while (view != parent) {

            ViewParent viewParent = view.getParent();

            if (viewParent instanceof ViewGroup) {
                level++;
                view = (View) viewParent;
            } else {
                return Integer.MAX_VALUE;
            }

        }

        return level;
    }

    @Override
    public String toString() {
        if (value != null) {
            if (handle != null) {
                StringBuilder stringBuilder = new StringBuilder();
                handle.onFragmentAnalyse(value, stringBuilder);
                return value.getClass().getSimpleName() + " " + stringBuilder.toString();
            }
            return value.getClass().getSimpleName();
        }

        return "null-fr";
    }

}
