package com.tcc.collecor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tcc.collecor.entities.ProductUserDetailImpl;
import com.tcc.collecor.entities.User;
import com.tcc.collecor.repositories.UserRepositories;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService{

    @Autowired
    UserRepositories userRepositories;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepositories.findByName(username)
        .orElseThrow( () -> new UsernameNotFoundException("Usuario não encontrado"));
        return new ProductUserDetailImpl(user);
    }
    
}
