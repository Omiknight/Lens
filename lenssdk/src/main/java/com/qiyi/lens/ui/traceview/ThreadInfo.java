package com.qiyi.lens.ui.traceview;

import java.util.HashMap;
import java.util.LinkedList;

public class ThreadInfo {
    String threadName;
    long threadId;
    public int index;
    LinkedList<TimeStamp> stamps = new LinkedList<>();
    LinkedList<TimeGap> blocks = new LinkedList<>();
    private static HashMap<Long, String> threadCreateInfo = new HashMap<>();

    ThreadInfo(String name, long id) {
        threadName = name;
        threadId = id;
    }

    void addStamp(TimeStamp stamp) {

        stamps.add(stamp);
    }


    void addBlock(TimeGap gap) {
        blocks.addFirst(gap);
    }


    // 非线程安全
    public static void putThreadInfo(long tid, String info) {
        threadCreateInfo.put(tid, info);
    }

    static String getThreadInfo(long tid) {
        return threadCreateInfo.get(tid);
    }


}
