package com.tcc.collecor.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.collecor.entities.Product;
import com.tcc.collecor.repositories.FavoriteRepositories;
import com.tcc.collecor.repositories.ProductRepositories;

@Service
public class FavoriteService {
    
    @Autowired
    FavoriteRepositories fRepositories;
    @Autowired
    ProductRepositories pRepositories;

    public List<Product> findByKeyword(Long userId, String keyword) {
        List<Long> l = fRepositories.findFavorites(userId);
        List<Product> p = pRepositories.findByKeyword(keyword);

        List<Product> filteredProducts = p.stream()
            .filter(product -> l.contains(product.getId()))
            .collect(Collectors.toList());


        return filteredProducts;
    }
    public List<Product> findByKeywordBt(Long userId, Integer keyword) {
        List<Long> l = fRepositories.findFavorites(userId);
        List<Product> p = pRepositories.findByKeywordType(keyword);
        List<Product> filteredProducts = p.stream()
            .filter(product -> l.contains(product.getId()))
            .collect(Collectors.toList());


        return filteredProducts;
    }
}
