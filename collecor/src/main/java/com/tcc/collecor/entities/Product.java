package com.tcc.collecor.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tcc.collecor.enums.TypeEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "product_tb")
public class Product {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String description;
    @Getter @Setter @Lob
    private byte[] content;
    @Getter @Setter
    private String imagePath;
    @Setter
    private Integer type;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "favoritesproducts")
    private List<User> userfavorite;
    //Constructors
    public Product() {
    }
    public Product(String name, String description, byte[] content, String imagePath, Integer type) {
        this.name = name;
        this.description = description;
        this.content = content;
        this.imagePath = imagePath;
        this.type = type;
    }

    //Getters and Setters
    public TypeEnum getType() {
        return TypeEnum.valueOf(type);
    }
}
