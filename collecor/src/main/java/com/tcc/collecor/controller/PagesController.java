package com.tcc.collecor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tcc.collecor.entities.Product;
import com.tcc.collecor.repositories.ProductRepositories;
import com.tcc.collecor.services.ProductService;

@Controller
public class PagesController {
    @Autowired
    ProductRepositories pRepo;
    @Autowired
    private ProductService pService;

    @GetMapping(path ={"loja"})
    public String productList(Model model) {
        List<Product> list = pService.findAll();
        model.addAttribute("list", list);

        return "loja";
    }
    @GetMapping("/perfil")
    public String perfil (){
        return "profile";
    }
    @GetMapping("/favoritos")
    public String favoritos (){
        return "favoritos";
    }
    @GetMapping("/sobre")
    public String sobre (){
        return "sobre";
    }
    @GetMapping("/home")
    public String home (){
        return "index";
    }
    @GetMapping("/upload")
    public String upload (){
        return "upload";
    }
    @GetMapping("/login")
    public String login (){
        return "login";
    }
    @RequestMapping(path = {"/","/search"})
    public String search(Product prod, Model model, String keyword) {
        keyword.toLowerCase();
        if(keyword!=null) {
            List<Product> list = pService.findByKeyword(keyword);
            model.addAttribute("list", list);
        }
            return "loja";
    }
    @RequestMapping(path = {"/","/search2"})
    public String searchBt(Product prod, Model model, int keywordBt) {

        if(keywordBt != 0) {
            List<Product> list = pService.findByKeywordType(keywordBt);
            model.addAttribute("list", list);
        }
        return "loja";
    }     
}
