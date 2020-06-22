package com.qiyi.lens.utils;

import android.os.AsyncTask;
import android.util.Log;

public class SimpleTask<Params, Result> extends AsyncTask<Params, Void, Result> {

    private static final String TAG = "SimpleTask";

    private Callback<Params, Result> callback;

    private Callback<Params, Result> getCallback() {
        return callback;
    }

    public SimpleTask(Callback<Params, Result> callback) {
        this.callback = callback;
    }

    @Override
    protected final void onPreExecute() {

    }

    @Override
    protected final Result doInBackground(Params[] params) {
        if (getCallback() != null) {
            try {
                return getCallback().doInBackground(params);
            } catch (Throwable t) {
                t.printStackTrace();
            }
        } else {
            Log.w(TAG, "doInBackground: getCallback() == null");
        }
        return null;
    }

    @Override
    protected final void onPostExecute(Result result) {
        if (getCallback() != null) {
            try {
                getCallback().onPostExecute(result);
            } catch (Throwable t) {
                t.printStackTrace();
            }
            callback = null;
        } else {
            Log.w(TAG, "onPostExecute: getCallback() == null");
        }
    }

    public interface Callback<T, K> {
        K doInBackground(T[] params);

        void onPostExecute(K result);
    }
}
