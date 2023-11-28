package com.tcc.collecor.resources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
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
import com.tcc.collecor.repositories.ProductRepositories;
import com.tcc.collecor.services.FavoriteService;
import com.tcc.collecor.services.ProductService;
import com.tcc.collecor.services.UserService;


@RestController
@RequestMapping("/products")
public class ProductResources {
        
    @Autowired
    ProductService pService;
    @Autowired
    UserService uService;
    @Autowired
    ProductRepositories pRepositories;
    @Autowired
    FavoriteService fService;


    public static String DIRECTORYI = System.getProperty("user.dir") + "/src/main/resources/static/uploads/images";
    public static String DIRECTORYC = System.getProperty("user.dir") + "/src/main/resources/static/uploads/contents";

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
                    @RequestParam("type") Integer type, @RequestParam(name ="image", required=false) MultipartFile image, @RequestParam("userName") String userName) {

        try {
            if (file.isEmpty()) {
            return new ModelAndView("redirect:/upload");
            }
            if(type != null){
                switch (type) {
                    case 3:
                        image = file;    
                        break;
                    case 0:
                        return new ModelAndView("redirect:/upload");   
                default:
                    break;     
                }
            }
            
            long u = uService.findByName(userName);

            StringBuilder fileNames = new StringBuilder();

            Product product = new Product();
            product.setName(name);
            product.setDescription(description);
            product.setType(type);
            product.setIdUser(u);

            //thumbnail upload
            List<String> extensoesPermitidas = Arrays.asList(".jpg", ".jpeg", ".png", ".webp");
            String nomeOriginal = image.getOriginalFilename();
            if (image.isEmpty()) {
                product.setImagePath("/imgs/compartilhadas/sem-capa.png");
            } else if (image != null && extensoesPermitidas.stream().noneMatch(nomeOriginal::endsWith)) {
                ModelAndView mv = new ModelAndView("redirect:/upload");
                mv.addObject("error", "O tipo selecionado não é correto ou a capa fornecida tem formato incompatível");
                return mv;
            }
            else{
            Path imageNameAndPath = Paths.get(DIRECTORYI, image.getOriginalFilename());
            fileNames.append(image.getOriginalFilename());
            Files.write(imageNameAndPath, image.getBytes());
            product.setImagePath("/uploads/images/"+image.getOriginalFilename());
            }
            
            //file upload
            Path fileNameAndPath = Paths.get(DIRECTORYC, file.getOriginalFilename());
            fileNames.append(file.getOriginalFilename());
            Files.write(fileNameAndPath, file.getBytes());
            product.setContentPath("/uploads/contents/"+file.getOriginalFilename());

            try {
                pService.saveFile(product);
                return new ModelAndView("redirect:/loja");
            } catch (Exception e) {
                ModelAndView mv = new ModelAndView("redirect:/upload");
                mv.addObject("error","Já existe arquivo com este nomeaa");
                return mv;
            }
        } catch (IOException e) {
            ModelAndView mv = new ModelAndView("redirect:/upload");
            mv.addObject("error","Erro inesperado, verifique se os campos foram preeenchidos corretamente");
            return mv;
        }
    }

    @GetMapping(value="delete/{uAuth}/{idProduct}")
    public ModelAndView delete(@PathVariable String uAuth, @PathVariable Long idProduct, @RequestParam("image") String image, @RequestParam("content") String content) {
        Product p =  pService.findById(idProduct);
        if (p.getIdUser() == uService.findByName(uAuth)) {
            pRepositories.delete(p);
        }
        
        pService.deleteFiles(image, content);

        return new ModelAndView("redirect:/perfil");
    }
}
