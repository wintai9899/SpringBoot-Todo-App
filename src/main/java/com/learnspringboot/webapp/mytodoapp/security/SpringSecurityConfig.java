package com.learnspringboot.webapp.mytodoapp.security;

import java.util.function.Function;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfig {
	//LDAP or Database
	// In Memory 
	

	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		
		UserDetails user1 = createNewUser("wentai9899", "password1");
		UserDetails user2 = createNewUser("tommy123", "password2");
		
		
		return new InMemoryUserDetailsManager(user1, user2);
		
	}
	@Bean 
	public PasswordEncoder myPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	private UserDetails createNewUser(String username, String password) {
		Function<String, String> passwordEncoder = input -> myPasswordEncoder().encode(input);
		
		UserDetails userDetails = User.builder()
									.passwordEncoder(passwordEncoder)
									.username(username)
									.password(password)
									.roles("USER", "ADMIN")
									.build();
		
		return userDetails;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		// authorize all http requests
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated());
		// display login form for unauthorized users
		http.formLogin(withDefaults());
		// disable csrf
		http.csrf().disable();
		// enable frames
		http.headers().frameOptions().disable();
		
		return http.build();
	}
}
