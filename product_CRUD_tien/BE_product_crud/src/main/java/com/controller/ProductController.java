package com.controller;

import com.entities.Category;
import com.entities.Product;
import com.services.CategoryService;
import com.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@CrossOrigin("*")
@RequestMapping("/products")
@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    HttpSession httpSession;

    @GetMapping("/category/category")
    public List<Category> categoryList() {

        return (List<Category>) categoryService.findAll();
    }

    @GetMapping
    public List<Product> show() {

        return productService.findAll();
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        return  productService.save(product);

    }

    @PostMapping("/upImg")
    public String upImg(@RequestParam MultipartFile fileImg) {
        String nameImg = fileImg.getOriginalFilename();
        try {
            FileCopyUtils.copy(fileImg.getBytes(), new File("D:\\webstorm\\product_CRUD_tien\\FE_Product\\img/" + nameImg));
            return "/img/" + nameImg;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @GetMapping("/{id}")
    public Product showEdit(@PathVariable Long id){
        return  productService.findById(id);
    }


    @PutMapping("/{id}")
    public Product edit(@RequestBody Product product) {
        return productService.save(product);
    }



    @DeleteMapping("/{id}")
    public Product delete(@PathVariable Long id) {
        return productService.deleteById(id);
    }

    @GetMapping("/check/{name}")
    public ResponseEntity  getCheckedName(@PathVariable  String name){
        if(productService.getCheckedName(name)!=null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
