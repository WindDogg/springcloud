package com.xue.client;

import com.xue.pojo.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ProductClientFeignHystrix implements ProductClientFeign {
    @Override
    public List<Product> listProducts() {
        List<Product> list = new ArrayList<>();
        list.add(new Product(0,"数据微服务暂不可用",0));
        return list;
    }
}
