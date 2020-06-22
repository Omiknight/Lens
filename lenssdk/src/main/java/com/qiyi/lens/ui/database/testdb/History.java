package com.qiyi.lens.ui.database.testdb;

import android.provider.BaseColumns;

import java.util.List;

@TestDatabase.Table("activity_history")
public class History {

    static {
        clear();
    }

    @TestDatabase.Column(value = BaseColumns._ID, primaryKey = true)
    public int id;
    @TestDatabase.Column("createTime")
    public long createTime;
    @TestDatabase.Column("activity")
    public String activity;
    @TestDatabase.Column("event")
    public String event;

    public static void clear() {
        TestDatabase.delete(History.class);
    }

    public static void insert(History history) {
        TestDatabase.insert(history);
    }

    public static List<History> query() {
        String condition = "order by createTime desc";
        return TestDatabase.queryList(History.class, null, condition);
    }
}
