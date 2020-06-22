package com.qiyi.lens.ui.database.protocol;

/**
 * associated with Driver, can be used to carry some information of the database
 */

public interface IDescriptor {
    String name();

    boolean exist();
}
