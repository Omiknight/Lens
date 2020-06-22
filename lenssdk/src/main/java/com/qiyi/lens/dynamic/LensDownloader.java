package com.qiyi.lens.dynamic;

import android.content.Context;
import android.os.Handler;

/*placeholder，保证 sdk 与 sdk-no-op 之间的切换*/
public class LensDownloader {
    public static LensDownloader get(Context context) {
        return new LensDownloader();
    }

    public void download(String url, String version) {
    }

    public static class OnResultCallback {

        public OnResultCallback() {
        }

        public OnResultCallback(Handler handler) {
        }

        public final void callOnStartCheck() {
        }

        public final void callOnNoUpdate() {
        }

        public final void callOnStartDownload(final String version, final String url) {
        }

        public final void callOnDownloadComplete() {
        }

        public final void callOnProgress(final long total, final long current) {
        }

        public final void callOnError(final Throwable e) {
        }

        protected void onStartCheck() {
        }

        protected void onNoUpdate() {
        }

        protected void onDownloadComplete() {
        }

        protected void onStartDownload(String version, String url) {
        }

        protected void onProgress(long total, long current) {
        }

        protected void onError(Throwable e) {
        }
    }
}
