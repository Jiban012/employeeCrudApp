//package com.employee.security;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .csrf().disable()  // Disable CSRF for simplicity (you may enable it as per your need)
//            .authorizeRequests()
//            .antMatchers("/api/employees/**").authenticated()  // Only authenticated users can access this
//            .and()
//            .httpBasic();  // Enable Basic Authentication
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // In-memory authentication for simplicity (you can replace it with DB or LDAP authentication)
//        auth.inMemoryAuthentication()
//            .withUser("user").password("{noop}password").roles("USER")
//            .and()
//            .withUser("admin").password("{noop}adminpassword").roles("ADMIN");
//    }
//}
//
//
