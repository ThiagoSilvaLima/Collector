package com.tcc.collecor.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tcc.collecor.controller.PagesController;
import com.tcc.collecor.entities.Product;
import com.tcc.collecor.entities.User;
import com.tcc.collecor.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResources {
    
    @Autowired
    UserService uService;
    PagesController pages = new PagesController();

    @GetMapping
    public ResponseEntity<List<User>> findAll () {
        List<User> list = uService.findAll();
        return ResponseEntity.ok().body(list);
    }
    @PostMapping(value = "/insert", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView insert(@RequestParam("username") String param1, @RequestParam("email") String param2, @RequestParam("password") String param3) {
        User user = new User();
        user.setUsername(param1);
        user.setEmail(param2);
        user.setPassword(param3);
        
        User obj = uService.createUser(user);
        ResponseEntity.ok().body(obj);
    
        return new ModelAndView("redirect:/perfil");
    }
    @PutMapping("/addFavorite/{userId}/{prodId}")
    public ResponseEntity<Product> addFavorites(@PathVariable Long userId , @PathVariable Long prodId){
        Product obj = uService.addFavorite( userId, prodId);
        return ResponseEntity.ok().body(obj);
    }
}
