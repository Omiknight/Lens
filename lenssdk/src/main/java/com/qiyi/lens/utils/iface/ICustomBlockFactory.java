package com.qiyi.lens.utils.iface;

import com.qiyi.lens.ui.devicepanel.blockInfos.AbsBlockInfo;

/**
 * 用于支持是设置页面，带开关部分逻辑的回调
 */
public interface ICustomBlockFactory {
    // 未测试，未支持： 创建自定义模块，用于展示在lens 顶级页面上
    AbsBlockInfo createBlockInfo(String key);

    // 未测试，已支持： 开关打开关闭的场景下调用。
    boolean onBlockSwitchChange(String key, boolean open);
}
