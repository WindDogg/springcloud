package com.xue;

import cn.hutool.core.util.NetUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableDiscoveryClient
public class App 
{
    public static void main( String[] args )
    {
        int port = 8040;
        if (!NetUtil.isUsableLocalPort(port)){
            System.out.printf("端口%d被占用，服务无法启动",port);
            System.exit(1);
        }
        new SpringApplicationBuilder(App.class).properties("server.port="+port).run(args);
    }
}
