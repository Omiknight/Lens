package com.qiyi.lens.utils;

public class StateLatch {
    private int amount;

    public StateLatch(int count) {
        amount = count;
    }

    public synchronized boolean countDown() {
        amount--;
        return amount == 0;
    }
}
