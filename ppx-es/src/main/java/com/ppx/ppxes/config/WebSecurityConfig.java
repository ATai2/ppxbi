package com.ppx.ppxes.config;


import com.ppx.ppxes.security.AuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 权限配置
 *
 * @since 1.0
 *
 * @version 1.0
 *
 * @author gegf
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * HTTP权限控制
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/admin/login").permitAll()
                .antMatchers("/static/**").permitAll()
                .antMatchers("/user/login").permitAll()
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("ADMIN","USER")
                .antMatchers("/api/user/**").hasAnyRole("ADMIN","USER")
                .and()
                .formLogin()
                .loginProcessingUrl("/login")  //配置入口角色登录
//                .failureHandler(authFailHandler())
                .and()
                ;
//                .logout()
//                .logoutSuccessUrl("/logout/page")
//                .deleteCookies("JSESSIONID")
//                .invalidateHttpSession(true).and()
//                 .exceptionHandling().authenticationEntryPoint(urlEntryPoint())
//                 .accessDeniedPage("/403");


        http.csrf().disable();
        http.headers().frameOptions().sameOrigin();
    }

    @Autowired
    public void configGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider()).eraseCredentials(true);
//        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN").and();
    }

    @Bean
    public AuthProvider authProvider(){
        return new AuthProvider();
    }
//
//    @Bean
//    public LoginUrlEntryPoint urlEntryPoint(){
//        return new LoginUrlEntryPoint("/user/login");
//    }
//
//    @Bean
//    public LoginAuthFailHandler authFailHandler(){
//        return new LoginAuthFailHandler(urlEntryPoint());
//    }

}
