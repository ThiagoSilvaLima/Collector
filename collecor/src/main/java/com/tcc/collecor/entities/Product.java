package com.tcc.collecor.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tcc.collecor.enums.TypeEnum;

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
    private String contentPath;
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
    public Product(String name, String description, String content, String imagePath, Integer type) {
        this.name = name;
        this.description = description;
        this.contentPath = content;
        this.imagePath = imagePath;
        this.type = type;
    }

    //Getters and Setters
    public TypeEnum getType() {
        return TypeEnum.valueOf(type);
    }
    public Integer getCode() {
        return this.type;
    }
}
