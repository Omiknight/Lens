package com.qiyi.lens.demo;

import android.content.Context;
import android.graphics.Rect;

import androidx.annotation.NonNull;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class UIUtils {
    public static Rect getRectInView(@NonNull ViewGroup viewGroup , @NonNull View view) {
        int[] ar = new int [2];
        viewGroup.getLocationInWindow(ar);
        int[] br = new int[2];
        view.getLocationInWindow(br);

        Rect rect = new Rect();
        rect.left = br[0] - ar[0];
        rect.top = br[1] - ar[1];
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        return rect;
    }

    public static void changeSiblingsVisibility(View view , int visibility) {
        if(view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) parent;
                int count = viewGroup.getChildCount();
                for (int i = 0; i < count; i++) {
                    View child = viewGroup.getChildAt(i);
                    if (child != view) {
                        child.setVisibility(visibility);
                    }
                }
                changeSiblingsVisibility((View) parent, visibility);
            }
        }
    }

    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public static int px2dp(Context context, float pxValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5F);
    }

    public static int dp2px(Context context , float dp){
        return (int) (context.getResources().getDisplayMetrics().density * dp + 0.5f);
    }

    public static int sp2px(Context context, float sp) {
        return (int) TypedValue.applyDimension(2, sp, context.getResources().getDisplayMetrics());
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

}
