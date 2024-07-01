package com.skg.spring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {
    // Used for adding User and roles details with In memorry
    /*@Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails khawja = User.builder().username("khawja")
                .password("{noop}ghouse")
                .roles("EMPLOYEE")
                .build();
        UserDetails ghouse = User.builder().username("ghouse")
                .password("{noop}ghouse")
                .roles("EMPLOYEE,MANAGER")
                .build();
        UserDetails nadeem = User.builder().username("nadeem")
                .password("{noop}ghouse")
                .roles("EMPLOYEE,MANAGER,ADMIN")
                .build();

        return new InMemoryUserDetailsManager(khawja, ghouse, nadeem);
    }*/

    // No more Hard coded use the support for JDB
    // It uses default schema name and column names
//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource){
//        return new JdbcUserDetailsManager(dataSource);
//    }

    // To use custom tables and column names
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // define a query to find the user by username
        // user_id will be username from login
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from members where user_id=?"
        );

        // define a query to find authorities / roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id=?"
        );
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configure ->
                configure
                        .requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/api/employees/**   ").hasRole("ADMIN")
        );

        // use http  Basic authentication
        http.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request Forgrey (CSRF)
        // in general, not required for stateless REST API's that uses POST PUT DELETE and GET
        http.csrf(csrf-> csrf.disable());

        return http.build();
    }
}
