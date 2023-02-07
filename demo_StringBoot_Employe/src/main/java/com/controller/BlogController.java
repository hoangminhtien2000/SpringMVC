package com.controller;

import com.model.Employ;
import com.model.Department;
import com.service.EmployService;
import com.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@CrossOrigin("*")
@RequestMapping("/employ")
@RestController
public class BlogController {
    @Autowired
    EmployService employService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    HttpSession httpSession;

    @ModelAttribute("department")
    public List<Department> departmentList() {

        return (List<Department>) departmentService.findAll();
    }

    @GetMapping
    public List<Employ> show() {

        return employService.findAll();
    }

    @PostMapping
    public Employ save(@RequestBody Employ employ) {
      return  employService.save(employ);

    }

    @GetMapping("/{id}")
    public Employ showEdit(@PathVariable String id){
        return  employService.findById(id);
    }


    @PutMapping("/{id}")
    public Employ edit(@RequestBody Employ employ) {
       return employService.save(employ);
    }



    @DeleteMapping("/{id}")
    public Employ delete(@PathVariable String id) {
       return employService.deleteById(id);
    }


}
