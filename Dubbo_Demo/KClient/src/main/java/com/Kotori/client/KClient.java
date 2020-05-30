package com.Kotori.client;

import com.Kotori.service.UserService;
import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;


public class KClient {
    public static void main(String[] args) throws InterruptedException {
        KClient client = new KClient();

        String url = new String("dubbo://127.0.0.1:20880/com.Kotori.service.UserService");

        UserService userService = client.buildRemoteService(url);
        userService.doSomething();
    }

    /***
     * 基于remoteUrl构建远程服务
     * @params remoteUrl
     * @return UserService
     */
    public UserService buildRemoteService(String remoteUrl) {
        ReferenceConfig<UserService> referenceConfig = new ReferenceConfig();

        // 设置接口
        referenceConfig.setInterface(UserService.class);

        // 设置一个注册中心
        referenceConfig.setRegistry(new RegistryConfig("multicast://224.1.1.1:1111"));

        // 设置调用服务地址
        referenceConfig.setUrl(null);

        // 设置应用
        referenceConfig.setApplication(new ApplicationConfig("KClient-app"));

        return referenceConfig.get();
    }

}
