package com.tcc.collecor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tcc.collecor.entities.User;
import com.tcc.collecor.entities.UserDetailImpl;
import com.tcc.collecor.repositories.UserRepositories;



@Service
public class UserDetailsServiceS implements UserDetailsService{

    @Autowired
    private UserRepositories uRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = uRepository.findByUsername(username)
        .orElseThrow( () -> new UsernameNotFoundException("Usuário não foi encontrado na base de dados"));
        return new UserDetailImpl(user);
    }
    
}