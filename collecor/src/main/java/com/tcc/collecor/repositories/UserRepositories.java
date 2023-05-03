package com.tcc.collecor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.collecor.entities.User;

public interface UserRepositories extends JpaRepository<User, Long> {

}