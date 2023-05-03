package com.tcc.collecor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.collecor.entities.Product;
import com.tcc.collecor.repositories.ProductRepositories;

@Service
public class ProductService {
        
    @Autowired
    ProductRepositories pRepositories;

    public List<Product> findAll() {
        return pRepositories.findAll();
    }
}
