package com.tcc.collecor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {
    
    @GetMapping("/loja")
    public String loja (){
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
}
