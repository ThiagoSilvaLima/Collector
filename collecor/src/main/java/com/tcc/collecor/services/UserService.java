package com.tcc.collecor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.collecor.entities.User;
import com.tcc.collecor.repositories.UserRepositories;

@Service
public class UserService {
    
    @Autowired
    UserRepositories uRepositories;


    public List<User> findAll() {
        return uRepositories.findAll();
    }
}
