package com.xue.util;

import cn.hutool.http.HttpUtil;

import java.util.HashMap;

public class FreshConfigUtil {
    public static void main(String[] args) {
        HashMap<String,String> headers = new HashMap<>();
        headers.put("Content-Type","application/json; charset=utf-8");
        System.out.println("因为要去git获取，还要刷新server-config,时间会比较长");
        String result = HttpUtil.createPost("http://localhost:8012/actuator/bus-refresh").addHeaders(headers).execute().body();
        System.out.println("result:"+result);
        System.out.println("refresh完成");
    }
}
