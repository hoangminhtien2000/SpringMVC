package com.bai123.crud_bai123.controller;


import com.bai123.crud_bai123.model.Product;
import com.bai123.crud_bai123.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Home {
    ProductService productService=new ProductService();
    @GetMapping("/home")
    public String show(Model model) {
        model.addAttribute("products", ProductService.products);
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
        productService.products.add(product);
        return "redirect:/home";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam int id,Model model){
    model.addAttribute("e",productService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit( Product product){
        int index= productService.findIndexbyId(product.getId());
        ProductService.products.set(index,product);
        return "redirect:/home";
    }

}
