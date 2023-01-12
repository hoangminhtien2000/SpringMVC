package com.views_thymeleaf.service;

import com.views_thymeleaf.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1,"Bim Bim","https://web.hn.ss.bfcplatform.vn/mkmart/product1/bb-orion-swing-bit-tet.jpg",10,true));
        products.add(new Product(2, "Kẹo","https://www.anlocviet.vn/upload/images/sugus-2.jpg", 20, false));
    }

    public void delete(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.remove(i);
            }
        }
    }

    public int findById(int id){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public Product findByIndex(int id){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return products.get(i);
            }
        }
        return null;
    }


}
