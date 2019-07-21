package com.xue;

import cn.hutool.core.util.NetUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
public class App 
{
    public static void main( String[] args )
    {
        int port = 8021;
        if (!NetUtil.isUsableLocalPort(port)){
            System.out.printf("端口%d被占用",port);
            System.exit(1);
        }
        new SpringApplicationBuilder(App.class).properties("server.port="+port).run(args);
    }
}
