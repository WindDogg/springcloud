package com.xue;

import cn.hutool.core.util.NetUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
@EnableEurekaClient
public class App 
{
    public static void main( String[] args )
    {
        int port =8030;
        if (!NetUtil.isUsableLocalPort(port)){
            System.err.printf("端口%d被占用",port);
            System.exit(1);
        }
        new SpringApplicationBuilder(App.class).properties("server.port="+port).run(args);
    }
}
