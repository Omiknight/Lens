package com.qiyi.lens.demo;

import com.qiyi.lens.demo.dump.Dump;

public class StaticDump {
    @Dump
    public static String dump() {
        return "this is static dump";
    }
}
