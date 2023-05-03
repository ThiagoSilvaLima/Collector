package com.tcc.collecor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.collecor.entities.Favorite;

public interface FavoriteRepositories extends JpaRepository<Favorite, Long> { 
}
