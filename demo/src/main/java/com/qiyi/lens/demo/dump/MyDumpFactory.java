package com.qiyi.lens.demo.dump;

import android.util.Log;

import com.qiyi.lens.demo.LensApp;
import com.qiyi.lens.demo.StaticDump;
import com.qiyi.lens.dump.AnnotationLogDumper;
import com.qiyi.lens.dump.DumpResultHandler;
import com.qiyi.lens.dump.ILogDumper;
import com.qiyi.lens.dump.ILogDumperFactory;

import java.lang.annotation.Annotation;

/**
 *  Lens data dump 对接入口
 */
public class MyDumpFactory implements ILogDumperFactory, DumpResultHandler {
    @Override
    public ILogDumper create() {
        return AnnotationLogDumper.create(this)
                .add(Dump.class, LensApp.getInstance(), StaticDump.class)
                .add(TMDump.class);
    }

    @Override
    public String onResult(Class<? extends Annotation> anno, String lensLog, String dumpLog) {
        Log.d("lens-dump", dumpLog);
        return dumpLog;
    }
}
