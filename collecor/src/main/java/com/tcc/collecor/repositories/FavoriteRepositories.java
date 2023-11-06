package com.tcc.collecor.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tcc.collecor.entities.Product;

public interface FavoriteRepositories extends JpaRepository<Product, Long> {
    //Custom query
    @Query(value = "SELECT product_id FROM user_product_favorite WHERE user_id = :userId", nativeQuery = true)  
    List<Long> findFavorites(@Param("userId") Long userId);

    //Custom query
    @Transactional
    @Modifying
    @Query(value = "Delete FROM user_product_favorite WHERE user_id = :userId and product_id = :prodId", nativeQuery = true)  
    void delete(@Param("prodId") Long prodId, @Param("userId") Long userId);
}
