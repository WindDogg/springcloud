package com.xue;

import cn.hutool.core.util.NetUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class App 
{
    public static void main( String[] args )
    {
        int port = 8020;
        if (!NetUtil.isUsableLocalPort(port)){
            System.out.printf("端口号%d已被占用",port);
            System.exit(1);
        }
        new SpringApplicationBuilder(App.class).properties("server.port="+port).run(args);

    }
}
