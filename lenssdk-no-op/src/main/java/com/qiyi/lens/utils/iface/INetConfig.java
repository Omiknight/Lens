package com.qiyi.lens.utils.iface;

/**
 * 支持客户端 提供测试环境 IP 地址等
 */
public interface INetConfig {
    String loadTestEnvironmentData();
    String loadUrlFilterData();
}
