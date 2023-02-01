package com.service;

import com.model.Blog;
import com.model.Category;
import com.repository.IBlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BlogService {
    @Autowired
    IBlogRepo iBlogRepo;

    public List<Blog> getAll(){
        return (List<Blog>) iBlogRepo.findAll();
    }

    public void save(Blog blog) {
        iBlogRepo.save(blog);
    }

    public void deleteById(int id){

        iBlogRepo.deleteById(id);
    }

    public Optional<Blog> findById(int id) {
        return  iBlogRepo.findById(id);
    }

}
