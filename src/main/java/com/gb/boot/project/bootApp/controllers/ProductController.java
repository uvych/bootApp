package com.gb.boot.project.bootApp.controllers;

import com.gb.boot.project.bootApp.model.Product;
import com.gb.boot.project.bootApp.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/allProduct")
    public String getAllProduct(Model model){
        model.addAttribute("products", productService.getAllProduct());
        return "product-page";
    }

    @PostMapping("product/add")
    public String addNewProduct(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/allProduct";
    }

    @GetMapping("product/edit/{id}")
    public String showEditProduct(@PathVariable Long id, Model model) {
        model.addAttribute("product",  productService.getProductById(id));
        return "product-edit-page";
    }

    @PostMapping("product/edit")
    public String editProduct(@ModelAttribute Product product) {
        productService.saveOrUpdate(product);
        return "redirect:/allProduct";
    }

    @GetMapping("product/remove/{id}")
    public String removeProductById(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/allProduct";
    }

    @GetMapping("product/find")
    public String findByID(@RequestParam(required = false) Long id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "product-by-id";
    }
}
