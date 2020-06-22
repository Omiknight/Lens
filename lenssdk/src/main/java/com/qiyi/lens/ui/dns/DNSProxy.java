package com.qiyi.lens.ui.dns;

import com.qiyi.lens.utils.Utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Dns;

public class DNSProxy implements Dns {
    private Dns ds;
    private HashMap<String, String> dnsMap;

    public DNSProxy(Dns dns, HashMap<String, String> map) {
        this.ds = dns;
        this.dnsMap = map;
    }

    @Override
    public List<InetAddress> lookup(String hostname) throws UnknownHostException {
        if (dnsMap != null) {
            String ip = dnsMap.get(hostname);
            if (Utils.isValidIP(ip)) {
                List<InetAddress> addressList = new ArrayList<>(1);
                addressList.add(InetAddress.getByName(ip));
                return addressList;
            }
        }
        if (ds != null)
            return ds.lookup(hostname);
        return Dns.SYSTEM.lookup(hostname);
    }

    private boolean isValidIP(String key) {
        return true;
    }
}
