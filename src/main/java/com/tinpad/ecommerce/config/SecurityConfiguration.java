package com.tinpad.ecommerce.config;

import com.tinpad.ecommerce.services.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//       http.authorizeRequests()
//               .antMatchers("/").permitAll()
//               .antMatchers("/api/products").hasRole("USER")
//               .antMatchers("/api/**").hasRole("MODERATOR")
//               .antMatchers("/**").hasRole("ADMIN")
//               .and().formLogin();
        http.authorizeRequests()
                .antMatchers("/auth/users/email/*").permitAll()
                .antMatchers("/auth/users/*").permitAll()
                .antMatchers("/api/**").permitAll()
                .antMatchers("/auth/**").authenticated()
                .antMatchers("/**").authenticated()
                .and().formLogin();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
//        return new BCryptPasswordEncoder();
        return NoOpPasswordEncoder.getInstance();
    }

}
