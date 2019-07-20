package com.xue;

import brave.sampler.Sampler;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.NetUtil;
import cn.hutool.core.util.NumberUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class App 
{
    public static void main( String[] args )
    {
        //判断rabbitMQPort是否启动
        int rabbitMQPort = 5672;
        if (NetUtil.isUsableLocalPort(rabbitMQPort)){
            System.out.printf("未在端口%d,发现rabbitMQ服务启动",rabbitMQPort);
            System.exit(1);
        }

        int port =0 ;
        int defaultPort = 8012;
        Future<Integer> future = ThreadUtil.execAsync(() ->{
            int p=0;
            System.out.println("请于5秒钟之内输入端口号，超时将使用默认端口号"+defaultPort);
            Scanner scanner = new Scanner(System.in);
            while (true){
                String strPort =scanner.nextLine();
                if (!NumberUtil.isInteger(strPort)){
                    System.err.println("只能是数字");
                    continue;
                }else{
                    p=Convert.toInt(strPort);
                    scanner.close();
                    break;
                }

            }
           return p;
        });
        try {
            port = future.get(5,TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException |TimeoutException e) {
            port =defaultPort;
        }
        if (!NetUtil.isUsableLocalPort(port)){
            System.err.printf("端口号%d被占用，无法启动",port);
            System.exit(1);
        }
        new SpringApplicationBuilder(App.class).properties("server.port="+port).run(args);
    }
    //配置Sampler抽样策略
    @Bean
    public Sampler dafaultSampler(){
        //持续抽样
        return Sampler.ALWAYS_SAMPLE;
    }
}
