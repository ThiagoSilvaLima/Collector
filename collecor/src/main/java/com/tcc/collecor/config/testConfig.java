package com.tcc.collecor.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.tcc.collecor.entities.Favorite;
import com.tcc.collecor.entities.User;
import com.tcc.collecor.repositories.FavoriteRepositories;
import com.tcc.collecor.repositories.UserRepositories;

@Configuration
@Profile("test")
public class testConfig implements CommandLineRunner {
    
    @Autowired
    private UserRepositories uRepositories;
    @Autowired
    private FavoriteRepositories fRepositories;

    @Override
	public void run(String... args) throws Exception {
		
		User u1= new User("Joaquim","joaquim@gmail.com","link.com");
        User u2= new User("Mario","quimario@gmail.com","quetecomeuatrazdoarmario.com");

        uRepositories.saveAll(Arrays.asList(u1,u2));
	
        Favorite f1 = new Favorite(u2);
        Favorite f2 = new Favorite(u1);

        fRepositories.saveAll(Arrays.asList(f1,f2));
    }    
}