package com.tcc.collecor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tcc.collecor.repositories.ProductRepositories;

@Controller
public class PagesController {
    @Autowired
    ProductRepositories pRepo;

    @GetMapping("loja")
    public ModelAndView productList(Model model) {
        ModelAndView mv = new ModelAndView("loja");
        mv.addObject("products", pRepo.findAll());
        return mv;
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
}
