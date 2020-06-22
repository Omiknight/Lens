package com.qiyi.lens.ui.database;

import com.qiyi.lens.ui.database.protocol.IDescriptor;

import java.io.File;


public class DatabaseDescriptor implements IDescriptor {
    public final File file;

    public DatabaseDescriptor(File file) {
        this.file = file;
    }

    @Override
    public String name() {
        return file.getName();
    }

    @Override
    public boolean exist() {
        return file.exists();
    }
}
