package com.services;

import com.entities.Category;
import com.repositories.ICategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    ICategory iCategory;
    public List<Category> findAll() {
        return (List<Category>) iCategory.findAll();
    }
}
