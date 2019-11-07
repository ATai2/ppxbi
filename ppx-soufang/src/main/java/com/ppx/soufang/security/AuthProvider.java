package com.ppx.soufang.security;

import com.ppx.soufang.entity.User;
import com.ppx.soufang.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.Md4PasswordEncoder;

/**
 * 自定义认证实现
 * Created by 瓦力.
 */
public class AuthProvider implements AuthenticationProvider {
    @Autowired
    private IUserService userService;

    // MD5加密器
    private final Md4PasswordEncoder passwordEncoder = new Md4PasswordEncoder();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String inputPassword = (String) authentication.getCredentials();

        User user = userService.findUserByName(userName);
        if (user == null) {
            throw new AuthenticationCredentialsNotFoundException("authError");
        }
        if (this.passwordEncoder.matches(user.getPassword(), inputPassword)) {
            return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        }
        throw new BadCredentialsException("authError");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
