package com.services;

import com.entities.Product;
import com.repositories.IProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {
    @Autowired
    IProduct iProduct;

    public List<Product> findAll() {
        return (List<Product>) iProduct.findAll();
    }

    public Product save(Product product) {
        return iProduct.save(product);
    }

    public Product deleteById(Long id){
        Product product = iProduct.findById(id).get();
        iProduct.deleteById(id);
        return product;
    }

    public Product findById(Long id) {
        return   iProduct.findById(id).get();
    }

    public  Product getCheckedName(String name){
        return iProduct.getCheckedName(name);
    }

}
