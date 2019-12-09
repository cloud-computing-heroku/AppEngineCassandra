package com.example.hello.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncrytedUtils {
    public static String encoder(String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String code = bCryptPasswordEncoder.encode(password);
        System.out.println("code = " + code);
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String code = bCryptPasswordEncoder.encode("hai@123");
        System.out.println("code = " + code);
    }
}
