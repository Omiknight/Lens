package com.qiyi.lens.ui.traceview;

public class TimeGap extends TimeStamp {
    long endTime;
    public int level;
    public int duration;
    public int cpuDuration;

    TimeGap(String tag, long tid, long startTime, long endTime, int level, long cpuStartTime, long cpuEndTime, long time) {
        super(tag, tid, startTime, cpuStartTime, time);
        this.endTime = endTime;
        this.level = level;
        duration = (int) (endTime - startTime);
        cpuDuration = (int) (cpuEndTime - cpuStartTime);
    }
}
