package com.qiyi.lens.ui.database;

public class DBItem extends NameItem {

    public int key;

    DBItem(String data, int key) {
        super(data);
        this.key = key;
    }
}
