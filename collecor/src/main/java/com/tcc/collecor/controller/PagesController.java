package com.tcc.collecor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tcc.collecor.entities.Product;
import com.tcc.collecor.repositories.ProductRepositories;
import com.tcc.collecor.services.ProductService;
import com.tcc.collecor.services.UserService;

@Controller
public class PagesController {
    @Autowired
    ProductRepositories pRepo;
    @Autowired
    private ProductService pService;
    @Autowired
    private UserService uService;

    @GetMapping(path ={"loja"})
    public String productList(Model model) {
        List<Product> list = pService.findAll();
        model.addAttribute("list", list);

        return "loja";
    }
    @GetMapping("/perfil")
    public String perfil(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // Obtendo informações do usuário autenticado
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();

        Long id = uService.findByName(username);
        List<Product> list = pService.findByUserId(id);
        model.addAttribute("list", list);

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
    @GetMapping("/register")
    public String register (){
        return "register";
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
    public String searchBt(Product prod, Model model, Integer keywordBt) {

        if(keywordBt != null) {
            List<Product> list = pService.findByKeywordType(keywordBt);
            model.addAttribute("list", list);
        }else{
            List<Product> list = pService.findAll();
            model.addAttribute("list", list);
        }
        return "loja";
    }     
}
