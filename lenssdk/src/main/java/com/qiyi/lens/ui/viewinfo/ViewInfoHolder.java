package com.qiyi.lens.ui.viewinfo;


public class ViewInfoHolder {

    private static ViewInfoHolder sInstant;

    public static ViewInfoHolder getInstant() {
        if (sInstant == null) {
            sInstant = new ViewInfoHolder();
        }
        return sInstant;
    }

    private Widget currentWidget;
    private WidgetSelectCallback widgetSelectCallback;

    private ViewInfoHolder() {
    }

    public void setCurrentWidget(Widget currentWidget) {
        this.currentWidget = currentWidget;
        if (widgetSelectCallback != null) {
            widgetSelectCallback.onWidgetSelect(currentWidget);
        }
    }

    public Widget getCurrentWidget() {
        return currentWidget;
    }

    public void setWidgetSelectCallback(WidgetSelectCallback widgetSelectCallback) {
        this.widgetSelectCallback = widgetSelectCallback;
    }

    public interface WidgetSelectCallback {
        void onWidgetSelect(Widget widget);
    }
}
