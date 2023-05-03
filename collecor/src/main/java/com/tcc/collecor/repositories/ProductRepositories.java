package com.tcc.collecor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.collecor.entities.Product;

public interface ProductRepositories extends JpaRepository<Product, Long> {
}
