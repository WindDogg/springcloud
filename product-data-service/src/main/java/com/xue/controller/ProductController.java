package com.xue.controller;

import com.xue.pojo.Product;
import com.xue.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ProductController {

    @Resource
    ProductService productService;
    @RequestMapping("/products")
    public Object products(){
        List<Product> ps = productService.listProducts();
        return ps;
    }
}
