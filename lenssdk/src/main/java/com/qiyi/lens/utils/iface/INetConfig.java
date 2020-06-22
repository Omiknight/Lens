package com.qiyi.lens.utils.iface;

/**
 * 支持客户端 提供测试环境 IP 地址等
 */
public interface INetConfig {
    // 直接加载测试环境配置地址； []:{key,value , key, value}
    String loadTestEnvironmentData();

    String loadUrlFilterData();
}
