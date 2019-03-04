package com.ppx.ppxes.security;

import com.ppx.ppxes.PpxEsApplicationTests;
import org.junit.Test;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import static org.junit.Assert.*;

public class AuthProviderTest  {
    @Test
    public void testPasswordEncoder() {
        Pbkdf2PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder();
        String a = passwordEncoder.encode("admin");
        System.out.println(a);
        String a1 = passwordEncoder.encode("admin");
        System.out.println(a1);
        System.out.println(passwordEncoder.encode("admin"));
        System.out.println(passwordEncoder.encode("admin"));
        System.out.println(passwordEncoder.matches("a",a));
    }
}