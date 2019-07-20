package com.xue.controller;

import com.xue.pojo.Product;
import com.xue.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RefreshScope
public class ProductController {

    @Autowired
    ProductService productService;

    @Value("${version}")
    String version;

    @RequestMapping("/products")
    public Object products(Model model){
        List<Product> list = productService.listProducts();
        model.addAttribute("ps",list);
        model.addAttribute("version",version);
        return "products";
    }
}
