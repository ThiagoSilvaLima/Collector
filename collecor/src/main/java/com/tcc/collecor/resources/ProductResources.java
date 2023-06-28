package com.tcc.collecor.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.collecor.entities.Product;
import com.tcc.collecor.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductResources {
        
    @Autowired
    ProductService pService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll () {
        List<Product> list = pService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/findType/{type}")
    public ResponseEntity<List<Product>> findByType (@PathVariable Long type) {
        List<Product> list = pService.findByType(type);
        return ResponseEntity.ok().body(list);
    }
}
