package com.qiyi.lens.ui.traceview;

public class TimeStamp {
    long threadId;
    public long timeStamp;
    private long cpuTimeStamp;
    public String tag;
    public int functionIndex;
    public long startTime;

    public TimeStamp(String tag, long tid, long timeStamp, long cpuTimeStamp, long startTime) {
        threadId = tid;
        this.timeStamp = timeStamp;
        this.cpuTimeStamp = cpuTimeStamp;
        this.startTime = startTime;
        this.tag = tag;
    }

    boolean isMainThread(long mainThreadId) {
        return threadId == mainThreadId;
    }


}
