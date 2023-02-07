package com.repository;

import com.model.Employ;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IEmploy extends PagingAndSortingRepository<Employ, String> {
}
