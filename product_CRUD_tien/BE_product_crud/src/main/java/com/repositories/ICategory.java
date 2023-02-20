package com.repositories;

import com.entities.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICategory extends PagingAndSortingRepository<Category, Long> {
}
