package com.tcc.collecor.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.collecor.entities.Favorite;
import com.tcc.collecor.services.FavoriteServices;

@RestController
@RequestMapping("/favorites")
public class FavoriteResources {
    
    @Autowired
    FavoriteServices fService;

    @GetMapping
    public ResponseEntity<List<Favorite>> findAll () {
        List<Favorite> list = fService.findAll();
        return ResponseEntity.ok().body(list);
    }
}
