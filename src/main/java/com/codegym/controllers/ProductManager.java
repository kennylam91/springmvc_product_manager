package com.codegym.controllers;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductManager {

    @Autowired
    ProductService productService;

    @GetMapping
    public String list(Model model){
        List<Product> products=productService.findAllProduct();
        model.addAttribute("products",products);
        return "list";
    }
}
