package com.tcc.collecor.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.collecor.entities.User;

public interface UserRepositories extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username); 
}