package com.springsecurity.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

	// configure SecurityFilterChain
	@Bean
	public SecurityFilterChain filterChanin(HttpSecurity httpSecurity) throws Exception {

//		httpSecurity
//		.csrf()
//		.disable()
//		.authorizeRequests()
//		.antMatchers("/")
//		.permitAll()
//		.antMatchers("/user").hasRole("USER")
//		.antMatchers("/admin").hasRole("ADMIN")
//		.anyRequest() 
//		.authenticated()
//		.and()
//		.httpBasic();
//		
//		return httpSecurity.build();

		return httpSecurity.csrf(csrf -> csrf.disable()).authorizeHttpRequests(auth -> {
			auth.antMatchers("/user").hasRole("USER");
			auth.antMatchers("/admin").hasRole("ADMIN");
		}).httpBasic(Customizer.withDefaults()).build();
	}

	@Bean
	public UserDetailsService userDetailsService(BCryptPasswordEncoder bCryptPasswordEncoder) {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		// Adding a normal user who has only USER role.
		manager.createUser(
				User.withUsername("user").password(bCryptPasswordEncoder.encode("userPass")).roles("USER").build());
		// Adding a admin user who has both USER and ADMIN role
		manager.createUser(User.withUsername("admin").password(bCryptPasswordEncoder.encode("adminPass"))
				.roles("USER", "ADMIN").build());
		return manager;
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
