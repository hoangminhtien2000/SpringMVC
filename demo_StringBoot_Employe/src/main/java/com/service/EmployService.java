package com.service;

import com.model.Employ;
import com.repository.IEmploy;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployService {
    @Autowired
    IEmploy iEmploy;

//    public Page<Employ> getAll(Pageable pageablea){
//        return iEmploy.findAll(pageablea);
//    }


    public List<Employ> findAll() {
        return (List<Employ>) iEmploy.findAll();
    }

    public Employ save(Employ employ) {
        return iEmploy.save(employ);
    }

    public Employ deleteById(String id){
       Employ employ = iEmploy.findById(id).get();
       iEmploy.deleteById(id);
       return employ;
    }

    public Employ findById(String id) {
        return   iEmploy.findById(id).get();
    }

}
