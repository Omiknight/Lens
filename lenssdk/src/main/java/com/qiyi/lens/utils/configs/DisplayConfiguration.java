package com.qiyi.lens.utils.configs;

import com.qiyi.lens.ui.devicepanel.blockInfos.display.ICustomDisplay;

public class DisplayConfiguration {

    private int displayHeight;
    private int refreshDuration = 1000;
    private static DisplayConfiguration config;
    private Class<? extends ICustomDisplay> displayClass;

    public static DisplayConfiguration obtain() {
        if (config == null) {
            config = new DisplayConfiguration();
        }
        return config;
    }

    public DisplayConfiguration setDisplayHeight(int height) {
        this.displayHeight = height;
        return this;
    }

    public int getDisplayHeight() {
        return displayHeight;
    }


    public DisplayConfiguration setRefreshDuration(int duration) {
        this.refreshDuration = duration;
        return this;
    }

    public int getRefreshDuration() {
        return refreshDuration;
    }

    public DisplayConfiguration setCustomDisplay(Class<? extends ICustomDisplay> clss) {
        displayClass = clss;
        return this;
    }

    public ICustomDisplay getCustomDisplay() {
        if (displayClass != null) {
            try {
                return displayClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
