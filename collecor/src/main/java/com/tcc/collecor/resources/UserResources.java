package com.tcc.collecor.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.collecor.entities.Product;
import com.tcc.collecor.entities.User;
import com.tcc.collecor.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResources {
    
    @Autowired
    UserService uService;

    @GetMapping
    public ResponseEntity<List<User>> findAll () {
        List<User> list = uService.findAll();
        return ResponseEntity.ok().body(list);
    }
    @PostMapping("/insert")
    public ResponseEntity<User> insert(@RequestBody User user) {
        User obj = uService.createUser(user);
        return ResponseEntity.ok().body(obj);
    }
    @PutMapping("/addFavorite/{userId}/{prodId}")
    public ResponseEntity<Product> addFavorites(@PathVariable Long userId , @PathVariable Long prodId){
        Product obj = uService.addFavorite( userId, prodId);
        return ResponseEntity.ok().body(obj);
    }
}
