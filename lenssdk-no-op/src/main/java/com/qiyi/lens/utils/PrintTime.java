package com.qiyi.lens.utils;

import android.os.Debug;

public class PrintTime {
    public long ct;
    public long st;
    static PrintTime time = new PrintTime();
    public void begin(){
        ct = Debug.threadCpuTimeNanos();
        st = System.currentTimeMillis();
    }

    public void addStamp(String key){
        long ctb = Debug.threadCpuTimeNanos();
        long stb = System.currentTimeMillis();
        android.util.Log.d("PrintTime",key+ " "+ (ctb - ct)/1000000 +" "+
                (stb - st));
        ct = ctb;
        st = stb;
    }
    public static void reset(){
        time.begin();
    }
    public static void stamp(String key){
        time.addStamp(key);
    }
}
