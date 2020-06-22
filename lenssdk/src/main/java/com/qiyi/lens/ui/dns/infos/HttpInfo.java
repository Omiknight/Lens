package com.qiyi.lens.ui.dns.infos;

import com.qiyi.lens.utils.reflect.Info;
import com.qiyi.lens.utils.reflect.Invalidate;
import com.qiyi.lens.utils.reflect.SpanableInfo;

import java.lang.ref.WeakReference;
import java.util.LinkedList;

public class HttpInfo extends Info {

    protected LinkedList<Info> infos = new LinkedList<>();
    //[if is not filtered , size is same as infos.size]
    int mNotFilteredSize;
    final int MAX_URLS = 80;


    public HttpInfo(Invalidate par) {
        super(par);
    }

    public HttpInfo(WeakReference<Invalidate> p) {
        super(p);
    }

    @Override
    protected void preBuildSpannables(StringBuilder stringBuilder, LinkedList<SpanableInfo> infosList) {

    }

    @Override
    protected void afterBuildSpannables(StringBuilder stringBuilder, LinkedList<SpanableInfo> infosList) {

    }


    @Override
    protected void makeList(LinkedList linkedList) {

        if (list == null) {
            list = new LinkedList<>();
        } else {
            list.clear();
        }

        if (infos != null) {
            for (Info info : infos) {
                if (info.isNotFiltered()) {
                    list.add(info);
                }
            }
        }

    }

    @Override
    public boolean isBasicType() {
        return false;
    }


    @Override//[if sth is not filtered , we should keep ,& display]
    public boolean isNotFiltered() {
        if (!UrlInfo.hasFilter()) {
            mNotFilteredSize = infos.size();
            return true;
        } else {
            mNotFilteredSize = 0;
            for (Info info : infos) {
                if (info.isNotFiltered()) {
                    mNotFilteredSize++;
                }
            }
            return mNotFilteredSize > 0;
        }

    }


    public void reset() {
        isExpand = false;
        if (infos != null) {
            for (Info info : infos) {
                info.reset();
            }
        }
    }

}
