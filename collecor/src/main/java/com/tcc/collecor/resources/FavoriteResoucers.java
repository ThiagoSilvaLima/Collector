package com.tcc.collecor.resources;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tcc.collecor.services.UserService;

@RestController
@RequestMapping("/fv")
public class FavoriteResoucers {

    @Autowired
    UserService uService;

    @PostMapping("/{userN}/{idProd}")
    public ModelAndView favorite(@PathVariable String userN, @PathVariable Long idProd, Model model, HttpServletRequest request){
        Long idU = uService.findByName(userN);
        uService.addFavorite(idU, idProd);

        model.addAttribute("reply","Adicionado aos favoritos");

        return new ModelAndView("redirect:/loja#"+idProd);
    }
}
