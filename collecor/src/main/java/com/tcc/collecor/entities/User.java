package com.tcc.collecor.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_users")
public class User implements Serializable{

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String email;
    String imgProfile;


    
    
    public User() {
    }

    public User(String username, String email, String imgProfile) {
        this.username = username;
        this.email = email;
        this.imgProfile = imgProfile;
    }

    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getImgProfile() {
        return imgProfile;
    }
    public void setImgProfile(String imgProfile) {
        this.imgProfile = imgProfile;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        User other = (User) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
    
    
}
