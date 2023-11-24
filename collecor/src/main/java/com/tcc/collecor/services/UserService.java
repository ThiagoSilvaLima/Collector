package com.tcc.collecor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.collecor.entities.Product;
import com.tcc.collecor.entities.User;
import com.tcc.collecor.repositories.ProductRepositories;
import com.tcc.collecor.repositories.UserRepositories;

@Service
public class UserService {
    
    @Autowired
    UserRepositories uRepositories;
    @Autowired
    ProductRepositories pRepositories;

    public List<User> findAll() {
        return uRepositories.findAll();
    }
    public void createUser(User user) {
        uRepositories.save(user);
    }
    public Product addFavorite(Long userId, Long prodId) {
        List<User> obj = uRepositories.findAll();
        Product pr = null;
        for (User u : obj) {
            if(u.getId() == userId){
                List<Product> prod = pRepositories.findAll();
                for (Product p : prod) {
                    if(p.getId() == prodId){
                        u.getFavoritesproducts().add(p);
                        pr =p;
                        uRepositories.save(u);
                    }
                }
            }
        }
        return pr;
    }
    public Long findByName(String name) {
        List<User> obj = uRepositories.findAll();
        User result = null;
        
        for (User u : obj) {
            if(u.getUsername().equals(name)){
                result=u;
            }
        }
        if(result == null){
            long erro = 0;
            return erro;
        }
        return result.getId();
    }
    public User findById(long id) {
        List<User> obj = uRepositories.findAll();
        User result = null;
        
        for (User u : obj) {
            if(u.getId() == id){
                result=u;
            }
        }
        return result;
    }

    public void editProfile(long id, String userName, String imgPath){
        User u = findById(id);
        if (userName == "") {
            u.setImgProfilePath(imgPath);
        }
        if (imgPath == "") {
            u.setUsername(userName);
        }
        else{
            u.setImgProfilePath(imgPath);
            u.setUsername(userName);
        }
        uRepositories.save(u);
    }
    
}
