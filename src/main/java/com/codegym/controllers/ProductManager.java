package com.codegym.controllers;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }

    @PostMapping("/save")
    public String createNewProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        Map<Integer,Product> products=productService.createNewProduct(product);
        redirectAttributes.addFlashAttribute("newProductName",product.getName());
        return "redirect:/product";
    }

    @GetMapping("/view")
    public String viewProduct(@RequestParam int productId,Model model){
        Product product=productService.findProductById(productId);
        model.addAttribute("product",product);
        return "view";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam int productId,RedirectAttributes redirectAttributes){
        productService.deleteProduct(productId);
        return "redirect:/product";
    }

}
