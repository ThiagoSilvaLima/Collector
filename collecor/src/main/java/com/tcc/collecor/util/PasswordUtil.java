package com.tcc.collecor.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {
    
    public static String encoder(String password){
        BCryptPasswordEncoder encoderSenha = new BCryptPasswordEncoder();
        return encoderSenha.encode(password);
    }
}