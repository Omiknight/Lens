package com.qiyi.lens.utils.configs;

import com.qiyi.lens.utils.iface.INetConfig;

import java.util.LinkedList;

public class NetworkAnalyzeConfig {
    private static NetworkAnalyzeConfig config = new NetworkAnalyzeConfig();
    private String urlFilter;
    private String keyFilter;
    private boolean isUrlGrabeEnabled;
    private LinkedList<Pair > keyList = new LinkedList<>();
    private String defaultIPHosts;
    private String defaultUrlGrabFilter;

    public static NetworkAnalyzeConfig getInstance() {
        return config;
    }
    public NetworkAnalyzeConfig setDefaultUrlFilter(String reg){
        this.urlFilter = reg;
        return this;
    }

    public String getUrlFilter(){
        return urlFilter;
    }

    public NetworkAnalyzeConfig setDefaultUrlKeyFilter(String s) {
        keyFilter = s;
        return this;
    }

    public NetworkAnalyzeConfig setUrlGrabEnabled(boolean enabled){
        isUrlGrabeEnabled = enabled;
        return this;
    }

    public boolean isUrlGrabEnabled(){
        return isUrlGrabeEnabled;
    }

    public void setNetConfig(INetConfig config) {
    }


    /**
     * @hide
     * @param url
     */
    public void onRequest(String url){

        if(!keyList.isEmpty() && url != null) {
            for (Pair key: keyList) {
                String s = key.url;
                if(url.contains(s)) {
                    key.watch.onRequest(url);
                }
            }
        }
    }

    public String getUrlKeyFilter() {
        return keyFilter;
    }

    public NetworkAnalyzeConfig addNetRequestWatch(String key , RequestWatch watch){
        if(key == null) {
            keyList.clear();
        }else {
            keyList.add(new Pair(key, watch));
        }
        return this;
    }
    public interface RequestWatch{
        public void onRequest(String url);
    }

    private static class Pair{
        String url;
        RequestWatch watch;
        public Pair(String r, RequestWatch w) {
            this.url = r;
            this.watch = w;
        }
    }

    public void addDefaultIPHosts(String ipHosts) {
        this.defaultIPHosts = ipHosts;
    }

    public void setUrlFilter(String urls) {
        this.defaultUrlGrabFilter = urls;
    }

    public String getDefaultIPHosts() {
        return this.defaultIPHosts;
    }

    public String getDefaultUrlGrabFilter() {
        return this.defaultUrlGrabFilter;
    }

    public INetConfig getmNetConfig(){
        return null;
    }


}
