package com.xue.controller;

import com.xue.pojo.Product;
import com.xue.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;
    @RequestMapping("/products")
    public Object products(Model model){
        List<Product> list = productService.listProducts();
        model.addAttribute("ps",list);
        return "products";
    }
}
