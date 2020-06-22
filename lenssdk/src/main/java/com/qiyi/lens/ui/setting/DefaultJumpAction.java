package com.qiyi.lens.ui.setting;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;

import com.qiyi.lens.utils.ApplicationLifecycle;
import com.qiyi.lens.utils.LensConfig;
import com.qiyi.lens.utils.iface.IJumpAction;
import com.qiyi.lenssdk.R;

/**
 * Lens 设置页面快速跳转能力支持
 */
public class DefaultJumpAction implements IJumpAction {
    private IJumpAction customJump;

    DefaultJumpAction() {
        customJump = LensConfig.getInstance().getCustomJumpAction();
    }

    @Override
    public boolean jump(Context context, String key, int eventId) {
        if (customJump != null && customJump.jump(context, key, eventId)) {
            return true;
        }
        // handle default:
        handleInnerEvent(eventId);
        return true;
    }

    private void handleInnerEvent(int vid) {
        if (vid == R.string.lens_block_app_setting_detail) {
            openSystemAppDetail();
        } else if (vid == R.string.lens_block_app_developer_option) {
            openDeveloperOption();
        } else if (vid == R.string.lens_block_app_change_language) {
            goSystemSetting(Settings.ACTION_LOCALE_SETTINGS);
        } else if (vid == R.string.lens_setting_system_setting) {
            goSystemSetting(Settings.ACTION_SETTINGS);
        } else if (vid == R.string.lens_setting_wifi_setting) {
            goSystemSetting(Settings.ACTION_WIFI_SETTINGS);
        } else if (vid == R.string.lens_setting_date_setting) {
            goSystemSetting(Settings.ACTION_DATE_SETTINGS);
        }
    }

    /**
     * 打开系统应用详情
     */
    private void openSystemAppDetail() {
        Intent localIntent = new Intent();
        Context context = ApplicationLifecycle.getInstance().getContext();
        localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        localIntent.setData(Uri.fromParts("package", context.getPackageName(), null));
        startActivity(localIntent);
    }

    /**
     * 打开开发者模式界面
     */
    private void openDeveloperOption() {
        try {
            ComponentName componentName = new ComponentName("com.android.settings",
                    "com.android.settings.DevelopmentSettings");
            Intent intent = new Intent();
            intent.setComponent(componentName);
            intent.setAction("android.intent.action.View");
            startActivity(intent);
        } catch (Exception e) {
            try {
                //部分小米手机采用这种方式跳转
                Intent intent = new Intent("com.android.settings.APPLICATION_DEVELOPMENT_SETTINGS");
                startActivity(intent);
            } catch (Exception ignored) {
            }
        }
    }

    /**
     * 打开系统语言设置
     */
    private void goSystemSetting(String action) {
        Intent intent = new Intent(action);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void startActivity(Intent intent) {
        Activity activity = ApplicationLifecycle.getInstance().getCurrentActivity();
        if (activity != null) {
            activity.startActivity(intent);
        }
    }


}
