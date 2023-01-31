package com.controller;

import com.model.Blog;
import com.model.Category;
import com.service.BlogService;
import com.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;
    @Autowired
    CategoryService categoryService;
    @ModelAttribute("category")
    public List<Category> categoryList() {
        return (List<Category>) categoryService.findAll();
    }

    @GetMapping("/blog")
    public ModelAndView show(){
        ModelAndView modelAndView = new ModelAndView("showBlog");
        modelAndView.addObject("blogs",blogService.getAll());
        return modelAndView;
    }

//    @GetMapping("/create")
//    public ModelAndView saveBlog(@ModelAttribute("category") Category category) {
//        ModelAndView modelAndView = new ModelAndView("/create");
//        return modelAndView;
//    }
//
//    @PostMapping("/create")
//    public ModelAndView saveBlog(Blog blog, @RequestParam Integer idCategory) {
//        ModelAndView modelAndView = new ModelAndView("redirect:/blog");
//        blog.setCategory(categoryService.findById(idCategory).get());
//        blogService.save(blog);
//        return modelAndView;
//    }

    @GetMapping("/create")
    public ModelAndView saveBlog() {
        ModelAndView modelAndView = new ModelAndView("/create");
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView save(Blog blog, @Param("idCategory") Integer idCategory, @RequestParam MultipartFile upImg) {
        ModelAndView modelAndView = new ModelAndView("redirect:/blog") ;
        Category category = categoryService.findById(idCategory).get();
        blog.setCategory(category);
        String nameFile = upImg.getOriginalFilename();
        try {
            FileCopyUtils.copy(upImg.getBytes(), new File("D:\\webstorm\\SpringMVC\\Blog\\src\\main\\webapp\\WEB-INF\\image/" + nameFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
        blog.setImg("/image/"+ nameFile);
        blogService.save(blog);

        return  modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteBlog(@PathVariable int id ) {
        blogService.deleteById(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/blog");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@ModelAttribute("category") Category category,@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("e",blogService.findById(id).get());
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView edit(Blog blog, @Param("idCategory") Integer idCategory, @RequestParam MultipartFile upImg) {
        ModelAndView modelAndView = new ModelAndView("redirect:/blog") ;
        blog.setCategory(categoryService.findById(idCategory).get());
        String nameFile = upImg.getOriginalFilename();
        try {
            FileCopyUtils.copy(upImg.getBytes(), new File("D:\\webstorm\\SpringMVC\\Blog\\src\\main\\webapp\\WEB-INF\\image/" + nameFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
        blog.setImg("/image/"+ nameFile);
        blogService.save(blog);
        return  modelAndView;
    }

}
