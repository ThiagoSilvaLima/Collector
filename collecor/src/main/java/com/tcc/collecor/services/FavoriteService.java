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
    @Autowired
    ProductService pService;

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
    public Boolean delete (Long idUser, Long idProd) {
        List<Long> ids = fRepositories.findFavorites(idUser);
        for (Long long1 : ids) {
            if (long1 == idProd) {
                fRepositories.delete(idProd,idUser);
                return true;
            }
        }
        return false;
    }
}
