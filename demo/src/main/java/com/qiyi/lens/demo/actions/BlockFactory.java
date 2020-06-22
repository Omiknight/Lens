package com.qiyi.lens.demo.actions;

import com.qiyi.lens.ui.devicepanel.blockInfos.AbsBlockInfo;
import com.qiyi.lens.utils.iface.ICustomBlockFactory;

/**
 * Lens 浮窗上支持自由添加展示模块的接口。 未测试，未支持
 */
public class BlockFactory implements ICustomBlockFactory {
    // called when a block is switch open
    @Override
    public AbsBlockInfo createBlockInfo(String key) {
        return null;
    }

    @Override
    public boolean onBlockSwitchChange(String key, boolean open) {
        return false;
    }
}
