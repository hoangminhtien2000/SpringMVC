package com.service;

import com.model.Department;
import com.repository.IDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    IDepartment iDepartment;

    public List<Department> findAll(){
       return (List<Department>) iDepartment.findAll();
    }

    public Optional<Department> findById(int id) {
        return iDepartment.findById(id);
    }
}
