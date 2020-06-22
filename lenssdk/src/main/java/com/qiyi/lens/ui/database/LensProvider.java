package com.qiyi.lens.ui.database;

import androidx.core.content.FileProvider;


public final class LensProvider extends FileProvider {

    private static LensProvider INSTANCE;

    private Databases databases;

    public LensProvider() {
        if (INSTANCE != null) {
            throw new RuntimeException();
        }
    }

    @Override
    public boolean onCreate() {
        INSTANCE = this;
        databases = new Databases(getContext());
        return super.onCreate();
    }


    public static LensProvider get() {
        return INSTANCE;
    }

    public Databases getDatabases() {
        return databases;
    }

}
