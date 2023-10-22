package com.tcc.collecor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tcc.collecor.entities.Product;

public interface ProductRepositories extends JpaRepository<Product, Long> {
    //Custom query
    @Query(value = "SELECT * FROM product_tb WHERE LOWER(name) LIKE LOWER(CONCAT('%', :keyword, '%'))", nativeQuery = true)  
    List<Product> findByKeyword(@Param("keyword") String keyword);
    //Custom query
    @Query(value = "SELECT * FROM product_tb WHERE type = :keywordBt", nativeQuery = true)  
    List<Product> findByKeywordType(@Param("keywordBt") int keywordBt);
    
}
