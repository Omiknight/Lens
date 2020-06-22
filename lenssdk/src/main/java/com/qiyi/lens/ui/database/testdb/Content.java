package com.qiyi.lens.ui.database.testdb;

import android.provider.BaseColumns;

@TestDatabase.Table("http_content")
public class Content {

    static {
        clear();
    }

    @TestDatabase.Column(value = BaseColumns._ID, primaryKey = true)
    public long id;
    @TestDatabase.Column("requestBody")
    public String requestBody;
    @TestDatabase.Column("responseBody")
    public String responseBody;

    public static Content query(long id) {
        return TestDatabase.queryList(Content.class, BaseColumns._ID + " = " + String.valueOf(id), "limit 1").get(0);
    }

    public static long insert(Content content) {
        return TestDatabase.insert(content);
    }

    public static void update(Content content) {
        TestDatabase.update(content);
    }

    public static void clear() {
        TestDatabase.delete(Content.class);
    }
}
