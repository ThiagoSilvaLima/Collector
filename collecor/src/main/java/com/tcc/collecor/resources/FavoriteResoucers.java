package com.tcc.collecor.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tcc.collecor.services.FavoriteService;
import com.tcc.collecor.services.UserService;

@RestController
@RequestMapping("/fv")
public class FavoriteResoucers {

    @Autowired
    UserService uService;
    @Autowired
    FavoriteService fService;

    @PostMapping("/{userN}/{idProd}")
    public ModelAndView favorite(@PathVariable String userN, @PathVariable Long idProd, Model model){
        Long idU = uService.findByName(userN);

        Boolean delete = fService.delete(idU,idProd);
        
        if (delete == false) {
            uService.addFavorite(idU, idProd);
        }

        model.addAttribute("reply","Adicionado aos favoritos");

        return new ModelAndView("redirect:/loja#"+idProd);
    }
    @PostMapping("/favorite/{userN}/{idProd}")
    public ModelAndView onFavoritePage(@PathVariable String userN, @PathVariable Long idProd, Model model){
        Long idU = uService.findByName(userN);

        fService.delete(idU,idProd);

        model.addAttribute("reply","deletado");

        return new ModelAndView("redirect:/favoritos");
    }
}
