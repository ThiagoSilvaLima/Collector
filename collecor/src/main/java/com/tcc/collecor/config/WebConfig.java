package com.tcc.collecor.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.tcc.collecor.services.UserDetailsServiceS;

@Configuration
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserDetailsServiceS userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests(requests -> requests
                .antMatchers("/imgs/**").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/fonts/**").permitAll()
                .antMatchers("/uploads/**").permitAll()
                .antMatchers("/loja/**").permitAll()
                .antMatchers("/home/**").permitAll()
                .antMatchers("/sobre/**").permitAll()
                .antMatchers("/search/**").permitAll()
                .antMatchers("/search2/**").permitAll()
                .antMatchers("/users/insert/**").permitAll()
                .antMatchers("/register/**").permitAll()
                .anyRequest().authenticated());


        http.formLogin(login -> login
                .loginPage("/login")
                .defaultSuccessUrl("/perfil")
                .permitAll());

        http.logout(logout -> logout
                .logoutRequestMatcher(
                        new AntPathRequestMatcher("/logout", "GET")
                ).logoutSuccessUrl("/home"));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
        .passwordEncoder(new BCryptPasswordEncoder());
    }
}