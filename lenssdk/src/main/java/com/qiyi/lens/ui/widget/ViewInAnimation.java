package com.qiyi.lens.ui.widget;

import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

import com.qiyi.lens.ui.BasePanel;

import static java.lang.System.currentTimeMillis;

/**
 * Created by Carlyle_Lee on 2017/7/21.
 */

public class ViewInAnimation extends Animation {
    private View _view;
    private int visible;
    private BasePanel _panel;
    private long now = 0L;
    private long offset = -1;

    private float mFromXDelta;
    private float mToXDelta;
    private float mFromYDelta;
    private float mToYDelta;
    private int _gra;

    public ViewInAnimation(BasePanel panel, float fromXDelta, float toXDelta, float fromYDelta, float toYDelta) {
        super();
        mFromXDelta = fromXDelta;
        mToXDelta = toXDelta;
        mFromYDelta = fromYDelta;
        mToYDelta = toYDelta;
        _panel = panel;
        _view = panel.getContentView();
        visible = _view.getVisibility();
        _view.setVisibility(View.GONE);
        this.setDuration(300);
        this.setAnimationListener(new AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
//                    _view.setVisibility(View.VISIBLE);
                updateTranslationInfo();
                _view = null;

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                onEnd();
                _panel = null;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });


    }

    public long getStartOffset() {
        if (now != 0) {
            if (offset < 0) {
                offset = currentTimeMillis() - now;
            }
            return offset;
        }
        return 0;
    }

    public void start() {
        _view.setVisibility(View.VISIBLE);
        _view.setAnimation(ViewInAnimation.this);
        now = currentTimeMillis();
        super.start();
        _view.invalidate();
    }

    public void startAnimationDelay(Handler handler, int dur) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                _view.setVisibility(View.VISIBLE);
                _view.setAnimation(ViewInAnimation.this);
                now = currentTimeMillis();
                ViewInAnimation.this.start();
                _view.invalidate();
            }
        }, dur);
    }

    public void setAdjustTranslateEnabled(int gravity) {
        _gra = gravity;
    }


    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        float dx = mFromXDelta;
        float dy = mFromYDelta;
        if (mFromXDelta != mToXDelta) {
            dx = mFromXDelta + ((mToXDelta - mFromXDelta) * interpolatedTime);
        }
        if (mFromYDelta != mToYDelta) {
            dy = mFromYDelta + ((mToYDelta - mFromYDelta) * interpolatedTime);
        }
        t.getMatrix().setTranslate(dx, dy);
    }


    private void updateTranslationInfo() {
        if (_gra != 0) {
            if (_gra == Gravity.BOTTOM) {
                mFromYDelta = _view.getHeight();
            } else {
                mFromXDelta = _view.getWidth();
            }
        }
    }

    protected void onEnd() {

    }

}
