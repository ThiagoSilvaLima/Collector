package com.tcc.collecor.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.tcc.collecor.entities.Favorite;
import com.tcc.collecor.entities.Product;
import com.tcc.collecor.entities.User;
import com.tcc.collecor.repositories.FavoriteRepositories;
import com.tcc.collecor.repositories.ProductRepositories;
import com.tcc.collecor.repositories.UserRepositories;

@Configuration
@Profile("test")
public class testConfig implements CommandLineRunner {
    
    @Autowired
    private UserRepositories uRepositories;
    @Autowired
    private FavoriteRepositories fRepositories;
    @Autowired
    private ProductRepositories pRepositories;
    @Override
	public void run(String... args) throws Exception {
		
		User u1= new User("Joaquim","joaquim@gmail.com","link.com");
        User u2= new User("Mario","quimario@gmail.com","quetecomeuatrazdoarmario.com");

        uRepositories.saveAll(Arrays.asList(u1,u2));
	
        Favorite f1 = new Favorite(u2);
        Favorite f2 = new Favorite(u1);

        fRepositories.saveAll(Arrays.asList(f1,f2));

        Product p1 = new Product("Jão e Maria", "Irmão e irma se perdem em uma floresta, e se encontram com uma cabana de doce","joaogomes.com", 1);
        Product p2 = new Product("Corvos e castelo", "Corvos negros sobrevoando um castelo negro", "images.com", 3);

       pRepositories.saveAll(Arrays.asList(p1,p2));
    }    
}