package com.qiyi.lens.ui.database.protocol;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import java.io.File;
import java.util.List;

/**
 * If the database is not in the default path,
 * you can provide the file by implementing the interface
 */

public interface IProvider {
    List<File> getDatabaseFiles();

    SQLiteDatabase openDatabase(File databaseFile) throws SQLiteException;
}
