package com.qiyi.lens.dump;

import androidx.annotation.RestrictTo;

import com.qiyi.lens.dump.impl.LifecycleDumpHelper;
import com.qiyi.lens.dump.impl.LogcatHelper;
import com.qiyi.lens.dump.impl.anotaion.Crash;
import com.qiyi.lens.dump.impl.anotaion.LifecycleDump;
import com.qiyi.lens.dump.impl.anotaion.LogcatDump;

import java.lang.annotation.Annotation;

@RestrictTo(RestrictTo.Scope.LIBRARY)
public class LogDumperHolder implements ILogDumper {
    private static LogDumperHolder sInstance = new LogDumperHolder();
    private Class<? extends ILogDumperFactory> mFactoryClass;
    private static IDebugStatusChanged sDebugStatusChanged;

    public static LogDumperHolder getInstance() {
        return sInstance;
    }

    public boolean isEnabled() {
        return mFactoryClass != null;
    }

    public void setDumper(Class<? extends ILogDumperFactory> factoryClass) {
        mFactoryClass = factoryClass;
    }


    private ILogDumper createInstance() {
        if (mFactoryClass != null) {
            try {
                return mFactoryClass.newInstance().create()
                        .add("Lifecycle", LifecycleDump.class, LifecycleDumpHelper.class)
                        .add("Log", LogcatDump.class, LogcatHelper.class)
                        .add("Crash", Crash.class, LifecycleDumpHelper.class)
                        ;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public String dump() {
        ILogDumper dumper = createInstance();
        if (dumper != null) {
            return dumper.dump();
        }
        return "";
    }

    @Override
    public String[] getDumpTags() {
        ILogDumper dumper = createInstance();
        if (dumper != null) {
            return dumper.getDumpTags();
        }
        return null;
    }

    @Override
    public String dump(int index) {
        ILogDumper dumper = createInstance();
        if (dumper != null) {
            return dumper.dump(index);
        }
        return "";
    }

    @Override
    public ILogDumper add(String name, Class<? extends Annotation> anno, Object... dpRoot) {
        return this;
    }

    @Override
    public ILogDumper add(Class<? extends Annotation> anno, Object... dpRoot) {
        return this;
    }

    public static IDebugStatusChanged getDebugStatusChanged() {
        return sDebugStatusChanged;
    }

    public static void setDebugStatusChanged(IDebugStatusChanged debugStatusChanged) {
        sDebugStatusChanged = debugStatusChanged;
    }
}
