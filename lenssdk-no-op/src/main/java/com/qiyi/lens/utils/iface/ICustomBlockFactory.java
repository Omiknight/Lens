package com.qiyi.lens.utils.iface;

import com.qiyi.lens.ui.devicepanel.blockInfos.AbsBlockInfo;

public interface ICustomBlockFactory {
    AbsBlockInfo createBlockInfo(String key);
    boolean onBlockSwitchChange(String key, boolean open);
}
