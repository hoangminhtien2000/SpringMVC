package com.repository;

import com.model.Department;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IDepartment extends PagingAndSortingRepository<Department, Integer> {
}