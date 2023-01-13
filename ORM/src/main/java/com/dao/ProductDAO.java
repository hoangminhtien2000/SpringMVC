package com.dao;

import com.model.Product;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class ProductDAO {
    @Autowired
    EntityManager entityManager;

    public List<Product> getAll(){
        String sql = "Select p from Product p";
        List<Product> products =  entityManager.createQuery(sql).getResultList();
        return products;
    }

    public void save(Product product){
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.persist(product);
        txn.commit();
    }

    public void delete(Product product){
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.remove(product);
        txn.commit();
    }

    public void edit(Product product){
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.merge(product);
        txn.commit();
    }

    public Product findById(int id){
        String sql = "Select p from Product p where p.id = " + id;
        Product product = (Product) entityManager.createQuery(sql).getSingleResult();
        return product;
    }
}
