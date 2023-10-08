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

    Product p1 = new Product("meninoecasa.jpg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse quis ante quis justo semper efficitur id in nulla. Donec imperdiet bibendum diam ut congue. Suspendisse potenti. Integer est augue.", "/uploads/contents/meninoecasa.jpg", "/uploads/contents/meninoecasa.jpg", 3);
    Product p2 = new Product("Briga Feia _ Mais Amor E Menos Drama - Ao Vivo - Henrique & Juliano.mp3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse quis ante quis justo semper efficitur id in nulla. Donec imperdiet bibendum diam ut congue. Suspendisse potenti. Integer est augue.", "/uploads/contents/Briga Feia _ Mais Amor E Menos Drama - Ao Vivo - Henrique & Juliano.mp3", "/uploads/contents/meninoecasa.jpg", 4);
    
    pRepositories.saveAll(Arrays.asList(p1,p2));
	}

}