package com.qiyi.lens.ui.database.protocol;

import android.database.sqlite.SQLiteException;

import com.qiyi.lens.ui.database.DatabaseResult;

import java.util.List;


/**
 * Database driver：SQLite、ContentProvider
 */

public interface IDriver<T extends IDescriptor> {
    List<T> getDatabaseNames();

    List<String> getTableNames(T databaseDesc) throws SQLiteException;

    void executeSQL(T databaseDesc, String query, DatabaseResult result) throws SQLiteException;
}
