package com.views_thymeleaf.controller;

import com.views_thymeleaf.model.Product;
import com.views_thymeleaf.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Home {
    ProductService productService =new ProductService();

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("product", ProductService.products);
        return "home";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        productService.delete(id);
        return "redirect:/home";
    }

    @GetMapping("/create")
    public String create() {
        return "create";
    }

    @PostMapping("/create")
    public String create(Product product) {
        ProductService.products.add(product);
        return "redirect:/home";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam int id, Model model){
        model.addAttribute("e",productService.findByIndex(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit( Product product){
        int index= productService.findById(product.getId());
        ProductService.products.set(index,product);
        return "redirect:/home";
    }

}
