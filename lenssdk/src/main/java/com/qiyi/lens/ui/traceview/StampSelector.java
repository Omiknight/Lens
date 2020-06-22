package com.qiyi.lens.ui.traceview;

//[用于标记当前的选中状态， 只在图上展示已选中的内容的]
//stamp 选中后 将竖线 变高，变色；并执行闪烁动画
//block 选中后，block 显示为高亮色；并执行闪烁动画；
class StampSelector {
    private int _type = -1, _index = -1;

    public StampSelector() {
    }

    public boolean setSelected(int type, int index) {
        if (isSelected(type, index)) {
            return false;
        }
        _type = type;
        _index = index;
        return true;
    }

    public boolean isSelected(int type, int index) {
        return _type == type && index == _index;
    }

}
