package com.Kotori.server;

import com.Kotori.service.UserService;
import com.Kotori.service.UserServiceImpl;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;

import java.io.IOException;
import java.util.List;

public class KServer {

    public static void main(String[] args) throws IOException {
        new KServer().openService(20880);
        System.in.read();
    }

    public void openService(int port) {
        ServiceConfig serviceConfig = new ServiceConfig();

        // 设置使用的协议
        serviceConfig.setProtocol(new ProtocolConfig("dubbo",port));

        // 设置属于哪个应用
        serviceConfig.setApplication(new ApplicationConfig("KServer-app"));

        // 设置一个注册中心
        serviceConfig.setRegistry(new RegistryConfig("multicast://224.1.1.1:1111"));

        // 设置调用的接口
        serviceConfig.setInterface(UserService.class);

        // 设置调用的接口具体实现
        UserServiceImpl ref = new UserServiceImpl();
        serviceConfig.setRef(ref);

        // 暴露接口
        serviceConfig.export();

        List<URL> urls = serviceConfig.getExportedUrls();
        ref.setPort(urls.get(0).getPort());

        System.out.println("服务已经开启，端口号为" + port);
    }
}
