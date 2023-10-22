package com.tcc.collecor.enums;

public enum Perfil {

    ADMIN("Adm"),
    USER("User");

    private String perfil;

    private Perfil(String perfil){
        this.perfil = perfil;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    
    
}