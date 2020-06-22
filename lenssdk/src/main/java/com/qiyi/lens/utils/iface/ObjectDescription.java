package com.qiyi.lens.utils.iface;

public class ObjectDescription implements IObjectDescriptor {
    public Object value;
    public String objectDescription;

    public ObjectDescription(Object var) {
        this.value = var;

    }

    public ObjectDescription(Object var, String des) {
        this.value = var;
        this.objectDescription = des;

    }

    private String parseDescription(String var){
        if(var == null) return "";
        return var;
    }


    @Override//what we need to display
    public String toString(Object object) {
        if(value instanceof String) {
            return value +" "+ parseDescription(objectDescription);
        }
        return value.getClass().getSimpleName() + " " + parseDescription(objectDescription);
    }

    @Override
    public String getTag(Object object) {
        return null;
    }

    @Override
    public String toString() {
        return toString(this);
    }

    public Object getValue() {
        return value;
    }
}
