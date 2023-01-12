package com.views_thymeleaf.controller;

import com.views_thymeleaf.model.Product;
import com.views_thymeleaf.service.ProductService;
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
    ProductService productService =new ProductService();

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("product", ProductService.products);
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
            FileCopyUtils.copy(upImg.getBytes(), new File("D:/webstorm/SpringMVC/Views_Thymeleaf/src/main/webapp/WEB-INF/image/" + nameFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
        product.setImg("/image/"+ nameFile);
        ProductService.products.add(product);
        return "redirect:/home";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("e",productService.findByIndex(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit( Product product,@RequestParam MultipartFile upImg ){
        int index= productService.findById(product.getId());
        String nameFile = upImg.getOriginalFilename();
        try {
            FileCopyUtils.copy(upImg.getBytes(), new File("D:/webstorm/SpringMVC/Views_Thymeleaf/src/main/webapp/WEB-INF/image/" + nameFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
        product.setImg("/image/"+ nameFile);
        ProductService.products.set(index,product);
        return "redirect:/home";
    }

}
