package com.practic.Ram.practice;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class PasswordHashing {

    String password = "siddgrtf@1453";
    String password1 = "siddgrtf@14535";

    public static void main(String[] args) {

//POC -PROF OF CONCEPT6
        // Using BCrypt class

//        BCrypt bCrypt = new BCrypt();
//        String hashpw1 = bCrypt.hashpw("siddgrtf@1453",BCrypt.gensalt(5));
//       System.out.println(hashpw1);
        String hashpw = BCrypt.hashpw("siddgrtf@14535", BCrypt.gensalt(4));
        System.out.println(hashpw);
        //Using BCryptPasswordEncoder class

//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        String encode = bCryptPasswordEncoder.encode("siddgrtf@1453");
//        System.out.println(encode);
    }
}


