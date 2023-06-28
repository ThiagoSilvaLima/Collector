package com.tcc.collecor.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tcc.collecor.enums.TypeEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_tb")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String link;
    private Integer type;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "favoritesproducts")
    private List<User> userfavorite;
    //Constructors
    public Product() {
    }
    public Product(String name, String description, String link, Integer type) {
        this.name = name;
        this.description = description;
        this.link = link;
        this.type = type;
    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }
    public TypeEnum getType() {
        return TypeEnum.valueOf(type);
    }
    public void setType(TypeEnum type) {
        this.type = type.getCode();
    }
    
    public List<User> getUserfavorite() {
        return userfavorite;
    }
    public void setUserfavorite(List<User> userfavorite) {
        this.userfavorite = userfavorite;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }
    
    
    
}
