package com.qiyi.lens.ui.viewinfo.json;

import android.graphics.Rect;

public class Frame implements IJson {
    private Rect rect;

    public Frame(Rect rect) {
        this.rect = rect;
    }

    @Override
    public String toJson() {
        JsonCompiler compiler = new JsonCompiler();
        compiler.addPair("x", rect.left);
        compiler.addPair("y", rect.top);
        compiler.addPair("width", rect.width());
        compiler.addPair("height", rect.height());
        return compiler.value();
    }

    @Override
    public void toJson(StringBuilder builder) {
        builder.append(toJson());
    }
}
