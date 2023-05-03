package com.tcc.collecor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.collecor.entities.Favorite;
import com.tcc.collecor.repositories.FavoriteRepositories;

@Service
public class FavoriteServices {
    
    @Autowired
    FavoriteRepositories fRepositories;

    public List<Favorite> findAll() {
        return fRepositories.findAll();
    }
}
