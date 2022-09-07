package com.codefellows.d15Security.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//TODO: Step 5: Make WebSecurityConfig extends WebSecurityConfigurerAdapter
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //TODO: Step5A: Wire up UserDetailsService
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    //TODO: Step5B: Wire up a passwordEncoder BEAN!!
    @Bean
    public PasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    //TODO: Step 5C: Link the userDetailsService and the passwordEncoder via a configure() method
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    //TODO: Step5D: Configure the security of our application via HttpSecurity
    // This is where we will do the work of how users can access the site
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests((requests) -> requests.anyRequest().authenticated());
        http
                .cors().disable()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/login", "/signup").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .and()
                .logout()
                .logoutSuccessUrl("/login");
    }
}
