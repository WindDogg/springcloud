package com.xue.util;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.http.HttpUtil;

public class AccessViewService {
    public static void main(String[] args) {
        while (true){
            ThreadUtil.sleep(1000);
            try{
                String html =HttpUtil.get("http://127.0.0.1:8012/products");
                System.out.println("html length:"+html.length());
            }catch (Exception e){
                System.err.println(e.getMessage());
            }

        }
    }

    public static void access(int port){
        try {
            String html = HttpUtil.get(String.format("http://127.0.0.1:%d/products",port));
            System.out.printf("%d 地址的视图服务访问成功，返回大小是 %d%n",port,html.length());
        }catch (Exception e){
            System.err.printf("%d 地址的视图服务无法访问%n",port);
        }
    }
}
