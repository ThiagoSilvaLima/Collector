package com.tcc.collecor.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.tcc.collecor.entities.Product;
import com.tcc.collecor.repositories.ProductRepositories;

@Service
public class ProductService {
        
    @Autowired
    ProductRepositories pRepositories;

    public List<Product> findAll() {
        return pRepositories.findAll();
    }

    public List<Product> findByType(@PathVariable Integer type ) {
        List<Product> obj = pRepositories.findAll();
        List<Product> result = new ArrayList<>();
        
        for (Product p : obj) {
            if(p.getType().getCode() == type){
                result.add(p);
            }
        }
        return result;
    }

    public void saveFile(Product p){
        pRepositories.save(p);
    }
}
