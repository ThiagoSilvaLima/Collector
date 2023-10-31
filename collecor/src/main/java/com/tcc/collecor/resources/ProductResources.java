package com.tcc.collecor.resources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import com.tcc.collecor.services.UserService;

@RestController
@RequestMapping("/products")
public class ProductResources {
        
    @Autowired
    ProductService pService;

    @Autowired
    UserService uService;

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
                                        @RequestParam("type") Integer type, @RequestParam("image") MultipartFile image, @RequestParam("userName") String userName ) {
        if (file.isEmpty()) {
            return new ModelAndView("redirect:/upload");
        }
        if(type != null){
            switch (type) {
                case 3:
                    image = file;    
                    break;
            default:
                 break;     
            }
        }else{return new ModelAndView("redirect:/upload");}

        try {

            long u = uService.findByName(userName);

            StringBuilder fileNames = new StringBuilder();

            Product product = new Product();
            product.setName(name);
            product.setDescription(description);
            product.setType(type);
            product.setIdUser(u);

            //thumbnail upload
            Path imageNameAndPath = Paths.get(DIRECTORYI, image.getOriginalFilename());
            fileNames.append(image.getOriginalFilename());
            Files.write(imageNameAndPath, image.getBytes());
            product.setImagePath("/uploads/images/"+image.getOriginalFilename());

            //file upload
            Path fileNameAndPath = Paths.get(DIRECTORYC, file.getOriginalFilename());
            fileNames.append(file.getOriginalFilename());
            Files.write(fileNameAndPath, file.getBytes());
            product.setContentPath("/uploads/contents/"+file.getOriginalFilename());

            pService.saveFile(product);
            return new ModelAndView("redirect:/loja");
        } catch (IOException e) {
            return new ModelAndView("redirect:/upload");
        }
    }
}
