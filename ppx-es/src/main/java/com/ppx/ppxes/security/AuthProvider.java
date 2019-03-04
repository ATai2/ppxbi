package com.ppx.ppxes.security;

import com.ppx.ppxes.entity.User;
import com.ppx.ppxes.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

/**
 * 自定义安全认证
 */
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    private final Pbkdf2PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String passwordInput = (String) authentication.getCredentials();

        User user = userService.findUserByName(username);
        if(user == null){
            throw new AuthenticationCredentialsNotFoundException("authError");
        }
//        user.getId() 加盐
        if(true){
            return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        }
//        if(passwordEncoder.matches(passwordEncoder.encode(passwordInput),user.getPassword())){
//            return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
//        }
        throw new BadCredentialsException("authError");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
