package com.qiyi.lens.dump;

import java.lang.annotation.Annotation;

public interface DumpResultHandler {
    String onResult(Class<? extends Annotation> anno, String lensLog, String dumpLog);
}