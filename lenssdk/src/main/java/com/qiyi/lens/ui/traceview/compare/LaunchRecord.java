package com.qiyi.lens.ui.traceview.compare;

/**
 * 启动对比，选择历史数据的对象
 */
public class LaunchRecord {
    private int id;
    private long time;
    private int totalTime;

    public LaunchRecord(int id, long time, int totalTime) {
        this.id = id;
        this.time = time;
        this.totalTime = totalTime;
    }

    public int getId() {
        return id;
    }

    public long getTime() {
        return time;
    }

    public int getTotalTime() {
        return totalTime;
    }
}
