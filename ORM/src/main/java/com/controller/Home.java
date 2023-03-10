package com.controller;

import com.model.Product;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
public class Home {
    @Autowired
    ProductService productService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("product", productService.getAll());
        return "home";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        productService.delete(id);
        return "redirect:/home";
    }

    @GetMapping("/create")
    public String create() {
        return "create";
    }

    @PostMapping("/create")
    public String create(Product product, @RequestParam MultipartFile upImg) {
        String nameFile = upImg.getOriginalFilename();
        try {
            FileCopyUtils.copy(upImg.getBytes(), new File("D:/webstorm/SpringMVC/ORM/src/main/webapp/WEB-INF/image/" + nameFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
        product.setImg("/image/"+ nameFile);
        productService.save(product);
        return "redirect:/home";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("e",productService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit( Product product,@RequestParam MultipartFile upImg ){
        String nameFile = upImg.getOriginalFilename();
        try {
            FileCopyUtils.copy(upImg.getBytes(), new File("D:/webstorm/SpringMVC/Views_Thymeleaf/src/main/webapp/WEB-INF/image/" + nameFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
        product.setImg("/image/"+ nameFile);
        productService.edit(product);
        return "redirect:/home";
    }

}
