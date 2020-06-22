package com.qiyi.lens.dump;

import androidx.annotation.RestrictTo;

import java.lang.annotation.Annotation;

@RestrictTo(RestrictTo.Scope.LIBRARY)
public interface ILogDumper {
    String dump();

    String[] getDumpTags();

    String dump(int index);

    ILogDumper add(String name, Class<? extends Annotation> anno, Object... dpRoot);

    ILogDumper add(Class<? extends Annotation> anno, Object... dpRoot);
}
