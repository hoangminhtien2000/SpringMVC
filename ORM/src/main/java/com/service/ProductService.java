package com.service;

import com.dao.ProductDAO;
import com.model.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductService {
    @Autowired
    ProductDAO productDAO;

    public List<Product> getAll(){
        return productDAO.getAll();
    }

    public void delete(int id){
        productDAO.delete(productDAO.findById(id));
    }

    public void edit(Product product){
        productDAO.edit(product);
    }

    public void save(Product product){
        productDAO.save(product);
    }

    public Product findById(int id){
return productDAO.findById(id);
    }


}
