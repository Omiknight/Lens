package com.qiyi.lens.utils.configs;

import com.qiyi.lens.ui.devicepanel.blockInfos.display.ICustomDisplay;

public class DisplayCofiguration {
    public static DisplayCofiguration obtain(){
        return new DisplayCofiguration();
    }

    public DisplayCofiguration setDisplayHeight(int height){
        return this;
    }
    public int getDisplayHeight() {
        return 0;
    }


    public DisplayCofiguration setRefreshDuration( int duration) {
        return this;
    }

    public int getRefreshDuration() {
        return 0;
    }
    public DisplayCofiguration setCustomDisplay(Class clss){
        return this;
    }

    public ICustomDisplay getCustomDisplay(){
        return null;
    }

}
