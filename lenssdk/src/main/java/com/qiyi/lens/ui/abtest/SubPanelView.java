package com.qiyi.lens.ui.abtest;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

import com.qiyi.lens.ui.abtest.content.EditTextContent;
import com.qiyi.lens.ui.abtest.content.RadioBoxContent;
import com.qiyi.lens.ui.abtest.content.ValueContent;
import com.qiyi.lenssdk.R;

/*

 */

/**
 * 其实就两种编辑状
 * 1, 固定内容编辑； 选择index
 * 2， 自己edit 内容编辑；
 * <p>
 * sub panel to display all value candidates.
 */
public class SubPanelView implements View.OnClickListener {
    private ViewGroup viewRoot;
    private ViewGroup viewContainer;
    private View closeBtn;
    private int dur = 200;
    private ValueContent valueContent;
    private String _key;
    private DismissCallback _callback;

    public SubPanelView(ViewGroup root) {
        //[必须是viewGroup ]
        viewRoot = (ViewGroup) root;
        viewContainer = root.findViewById(R.id.lens_sub_panel_container);
        closeBtn = root.findViewById(R.id.lens_sub_panel_close_btn);
        closeBtn.setOnClickListener(this);
    }


    //[attach content view into parent]
    public void showData(String key, Value value) {
        _key = key;
        if (value != null) {
            //[do show]
            loadContentView(value);
            if (viewRoot.getVisibility() != View.VISIBLE) {
                viewRoot.setVisibility(View.VISIBLE);
                TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0
                        , Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 0f);
                translateAnimation.setDuration(dur + 50);
                translateAnimation.setInterpolator(new AccelerateInterpolator());
                translateAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                viewRoot.startAnimation(translateAnimation);
            }
        }
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.lens_sub_panel_close_btn) {
            dismiss();
        }

    }

    public void dismiss() {
        TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0
                , Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 1f);
        translateAnimation.setDuration(dur);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                viewRoot.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        viewRoot.startAnimation(translateAnimation);

        if (valueContent != null) {
            valueContent.detachView();
            valueContent = null;
        }

        if (_callback != null) {
            _callback.onDismiss();
        }
    }

    //[viewContainer as parent to load view]
    private void loadContentView(Value value) {

        if (valueContent != null) {
            if (!valueContent.tryLoad(_key, value)) {
                valueContent = null;
            }
        }
        if (valueContent == null) {
            if (value.isSelectableValue()) {
                valueContent = new RadioBoxContent(viewContainer, _key, value);
            } else {
                valueContent = new EditTextContent(viewContainer, _key, value);
                valueContent.setPanel(this);
            }
        }
        valueContent.loadView();
    }


    public void setOnDismissCallback(DismissCallback call) {
        _callback = call;
    }

    public interface DismissCallback {
        void onDismiss();
    }


}
