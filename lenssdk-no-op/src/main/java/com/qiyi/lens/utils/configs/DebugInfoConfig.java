package com.qiyi.lens.utils.configs;

import androidx.annotation.Nullable;
import com.qiyi.lens.ui.viewinfo.IViewClickHandle;
import com.qiyi.lens.utils.iface.IObjectDescriptor;
import java.lang.reflect.Field;
public class DebugInfoConfig {
    static DebugInfoConfig config = new DebugInfoConfig();

    private Class< ? extends IViewClickHandle> viewClickHandle;
    private IObjectDescriptor defaultDescriptor;
    private DebugInfoConfig(){}
    public static DebugInfoConfig getInstance(){

        return config;
    }

    public void setViewClickhandle(Class< ? extends IViewClickHandle> viewClickHandle){
        this.viewClickHandle = viewClickHandle;
    }
    public Class< ? extends IViewClickHandle> getViewClickHandle(){
        return viewClickHandle;
    }

    public void setDefaultObjectDescriptor(IObjectDescriptor descriptor) {
        this.defaultDescriptor = descriptor;
    }

    public void watchField(String fieldName, Object object) {
    }

    @Nullable
    private Field getField(String fieldName, Object object) {
        Field field = null;
        return field;
    }

    public void watchObject(Object object) {
    }

    public void watchObject(String name, Object object) {
    }

    public boolean hasWatched(String name, Object object) {
        return false;
    }


    public int getWatchListSize() {
        return 0;
    }

    public IObjectDescriptor getDefaultDescription(){
        return defaultDescriptor;
    }

}
