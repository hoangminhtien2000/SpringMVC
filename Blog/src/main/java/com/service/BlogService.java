package com.service;

import com.model.Blog;
import com.model.Category;
import com.repository.IBlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BlogService {
    @Autowired
    IBlogRepo iBlogRepo;

    public Page<Blog> getAll(Pageable pageablea){
        return iBlogRepo.findAll(pageablea);
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
