package com.tcc.collecor.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.tcc.collecor.entities.Product;
import com.tcc.collecor.repositories.ProductRepositories;

@Configuration
@Profile("test")
public class testConfig implements CommandLineRunner {

    @Autowired
    private ProductRepositories pRepositories;

    @Override
	public void run(String... args) throws Exception {

    Product p1 = new Product("meninoecasa.jpg", "l", "/uploads/contents/meninoecasa.jpg", "/uploads/contents/meninoecasa.jpg", 3);
    
    pRepositories.saveAll(Arrays.asList(p1));
	}

}