package com.qiyi.lens.dump;

import androidx.annotation.RestrictTo;

import java.lang.annotation.Annotation;

/**
 * 基于注解的 ILogDumper
 */
public class AnnotationLogDumper implements ILogDumper {
    private DumpResultHandler mDumpResultHandler;

    public AnnotationLogDumper(DumpResultHandler dumpResultHandler) {
    }

    public static AnnotationLogDumper create(DumpResultHandler handler) {
        return new AnnotationLogDumper(handler);
    }

    public AnnotationLogDumper add(Class<? extends Annotation> anno, Object... dpRoot) {
        return this;
    }

    public AnnotationLogDumper add(String name, Class<? extends Annotation> anno, Object... dpRoot) {
        return this;
    }

    @Override
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    public String dump() {
        return "";
    }
}
