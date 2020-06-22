package com.qiyi.lens.ui.dns.infos;

import com.qiyi.lens.utils.reflect.Info;
import com.qiyi.lens.utils.reflect.Invalidate;

public class UrlCollector extends HttpInfo {

    public UrlCollector(Invalidate par) {
        super(par);
    }

    public void addHostInfo(HostInfo info) {
        infos.add(info);
    }


    @Override
    public String toString() {
        return "总共 " + infos.size() + " 项";
    }

    @Override
    public boolean isBasicType() {
        return false;
    }


    public HostInfo getHostInfo(String host) {
        for (Info info : infos) {
            HostInfo hostInfo = (HostInfo) info;
            if (host.equals(hostInfo.host)) {
                return hostInfo;
            }
        }
        return null;
    }


}
