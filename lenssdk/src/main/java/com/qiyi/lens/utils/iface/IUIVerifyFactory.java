package com.qiyi.lens.utils.iface;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;

/**
 * UI 验收支持接口
 */
public interface IUIVerifyFactory {
    //让客户端自行定义JSON 数据的实现
    void onJsonBuild(Activity activity, IJsonCompiler json);

    //让客户端自行定义View传递的内容
    void onJsonBuildView(View view, IJsonCompiler json);

    //客户端分析Drawable
    boolean onJsonBuildDrawable(Drawable drawable, IJsonCompiler jsonCompiler);

    // 创建页面
    View onCreateView(IPanel panel, Context context);

    //当数据处理完成后调用。客户端使用这个数据进行投递
    void onDataPrepared(String data, String filePath);

}
