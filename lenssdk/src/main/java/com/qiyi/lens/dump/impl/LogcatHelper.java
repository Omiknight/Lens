package com.qiyi.lens.dump.impl;

import android.content.Context;

import com.qiyi.lens.dump.impl.anotaion.LogcatDump;
import com.qiyi.lens.utils.ApplicationLifecycle;
import com.qiyi.lens.utils.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * dump logcat info
 */
public class LogcatHelper {

    private static LogFilter logFilter;

    public interface LogFilter {
        boolean accept(String line);
    }

    public static String get(Context context, LogFilter filter) {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        try {
            File dest = new File(context.getCacheDir(), "_logcat.log");
            if (dest.exists()) {
                dest.delete();
            }
            String[] cmd = new String[]{
                    "logcat",
                    "-d",
                    "-v",
                    "time",
                    "-f",
                    dest.getAbsolutePath()
            };
            Process process = Runtime.getRuntime().exec(cmd);
            process.waitFor();
            br = new BufferedReader(new InputStreamReader(new FileInputStream(dest)));
            String line;
            while ((line = br.readLine()) != null) {
                if (filter == null || filter.accept(line)) {
                    sb.append(line).append('\n');
                }
            }
        } catch (IOException ignored) {
        } catch (InterruptedException ignored) {
        } finally {
            FileUtils.closeSafely(br);
        }
        return sb.toString();
    }

    public static void setLogFilter(LogFilter filter) {
        logFilter = filter;
    }

    @LogcatDump
    public static String getLog() {
        return get(ApplicationLifecycle.getInstance().getContext(), logFilter);
    }
}
