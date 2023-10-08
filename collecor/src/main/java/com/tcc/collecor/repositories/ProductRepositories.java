package com.tcc.collecor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tcc.collecor.entities.Product;

public interface ProductRepositories extends JpaRepository<Product, Long> {
    //Custom query
    @Query(value = "select * from product_tb s where lower(s.name) like LOWER('%' || :keyword || '%')", nativeQuery = true)   
    List<Product> findByKeyword(@Param("keyword") String keyword);
}
