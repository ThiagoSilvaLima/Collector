package com.tcc.collecor.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tcc.collecor.controller.PagesController;
import com.tcc.collecor.entities.Product;
import com.tcc.collecor.entities.User;
import com.tcc.collecor.enums.Perfil;
import com.tcc.collecor.services.UserService;
import com.tcc.collecor.util.PasswordUtil;

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
    @PostMapping(value = "/insert")
    public ModelAndView register(@ModelAttribute User user, Model model) {
        ModelAndView mv = new ModelAndView("redirect:/register");
        String hashPass = PasswordUtil.encoder(user.getPassword());
        user.setPassword(hashPass);
        user.setRules(Perfil.USER);
        try {
            uService.createUser(user);
            return new ModelAndView("redirect:/perfil"); 
        } catch (Exception e) {
            mv.addObject("error",true);
            return mv;
        }
    }
    @PutMapping("/addFavorite/{userId}/{prodId}")
    public ResponseEntity<Product> addFavorites(@PathVariable Long userId , @PathVariable Long prodId){
        Product obj = uService.addFavorite( userId, prodId);
        return ResponseEntity.ok().body(obj);
    }
}
