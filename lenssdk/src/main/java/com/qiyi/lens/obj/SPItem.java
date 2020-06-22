package com.qiyi.lens.obj;

import java.io.File;
import java.util.Map;

/**
 * used for SharedPreference key value in model : SP
 */
public class SPItem {

    public String key;
    public String value;
    public String newValue; //用于记录编辑后的值
    public String fileName;
    public File descriptor;
    public Map<String, String> data;

    public SPItem(String name, String key, String value) {
        this.fileName = name;
        this.key = key;
        this.value = value;
    }

}
