package com.qiyi.lens.utils;

public class KeyLogConfig {


    public KeyLogConfig(){

    }

    /**
     * 支持添多个 filter
     * @return
     */
    public KeyLogConfig addFilter(String key){
        return this;
    }


    public KeyLogConfig setMaxLine(int line){

        return this;
    }

    public KeyLogConfig setBreifLine(int line) {

        return this;
    }

    public static KeyLogConfig builder(){
        return new KeyLogConfig();
    }

}
