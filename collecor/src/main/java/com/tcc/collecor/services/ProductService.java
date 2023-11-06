package com.tcc.collecor.services;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.tcc.collecor.entities.Product;
import com.tcc.collecor.repositories.ProductRepositories;

@Service
public class ProductService {
        
    @Autowired
    ProductRepositories pRepositories;

    public List<Product> findAll() {
        return pRepositories.findAll();
    }

    public List<Product> findByType(@PathVariable Integer type ) {
        List<Product> obj = pRepositories.findAll();
        List<Product> result = new ArrayList<>();
        
        for (Product p : obj) {
            if(p.getType().getCode() == type){
                result.add(p);
            }
        }
        return result;
    }

    public Product findById(@PathVariable Long id ) {
        List<Product> obj = pRepositories.findAll();
        Product result = null;
        
        for (Product p : obj) {
            if(p.getId() == id){
                result=p;
            }
        }
        return result;
    }
    public List<Product> findByUserId(@PathVariable Long id ) {
        List<Product> obj = pRepositories.findAll();
        List<Product> result = new ArrayList<>();
        
        for (Product p : obj) {
            if(p.getIdUser() == id){
                result.add(p);
            }
        }
        return result;
    }
    public Product findByname(@PathVariable String name ) {
        List<Product> obj = pRepositories.findAll();
        Product result = null;
        
        for (Product p : obj) {
            if(p.getName() == name){
                result=p;
            }
        }
        return result;
    }

    public List<Product> findByKeyword(String keyword) {
        return pRepositories.findByKeyword(keyword);
    }

    public List<Product> findByKeywordType(int keywordBt) {
        return pRepositories.findByKeywordType(keywordBt);
    }

    public void saveFile(Product p){
        pRepositories.save(p);
    }

    public void deleteFiles(String image, String content) {
        // Caminho dos arquivos a serem deletados
        String uploadPath = "src/main/resources/static/uploads/";
        String imagePath = uploadPath + image;
        String contentPath = uploadPath + content;
    
        try {
            // Deleta o arquivo de imagem se existir
            File imageFile = new File(imagePath);
            if (imageFile.exists()) {
                imageFile.delete();
            }
    
            // Deleta o arquivo de conteúdo se existir
            File contentFile = new File(contentPath);
            if (contentFile.exists()) {
                contentFile.delete();
            }
        } catch (Exception e) {
            // Lidar com qualquer exceção ao tentar excluir os arquivos
            e.printStackTrace();
        }
    }
}
