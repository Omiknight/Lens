package com.qiyi.lens.demo;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import android.widget.TextView;

public class BAC extends Activity {
    @Override
    public void onCreate(Bundle bd) {
        super.onCreate(bd);
        setContentView( new TextView(this));
        ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.WRITE_EXTERNAL_STORAGE }, 123);
    }
}
