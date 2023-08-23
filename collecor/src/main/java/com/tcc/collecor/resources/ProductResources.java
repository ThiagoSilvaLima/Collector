package com.tcc.collecor.resources;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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
    public ResponseEntity<List<Product>> findByType (@PathVariable Integer type) {
        List<Product> list = pService.findByType(type);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/uploadArquivo")
    public ModelAndView uploadProduct(@RequestParam("file") MultipartFile file,  @RequestParam("name") String name, @RequestParam("description") String description,
                                        @RequestParam("type") Integer type, @RequestParam("image") MultipartFile image) {
        if (file.isEmpty()) {
            return new ModelAndView("redirect:/upload");
        }
        if (type == null) {
            return new ModelAndView("redirect:/upload");
        }
        try {
            Product product = new Product();
            product.setName(name);
            product.setDescription(description);
            product.setContent(file.getBytes());
            product.setType(type);
            product.setImage(image.getBytes());
            pService.saveFile(product);
            return new ModelAndView("redirect:/perfil");
        } catch (IOException e) {
            return new ModelAndView("redirect:/home");
        }
    }
}
