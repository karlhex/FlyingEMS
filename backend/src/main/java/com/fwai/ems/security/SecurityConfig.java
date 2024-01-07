package com.fwai.ems.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * SecurityConfig
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

		@Bean
		public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
				http
						.csrf(AbstractHttpConfigurer::disable)
						.authorizeHttpRequests((authorize) -> authorize
																	.requestMatchers("/hello").permitAll()
																	.anyRequest().authenticated()
																	)
						.sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
						.httpBasic(Customizer.withDefaults())
						.formLogin(Customizer.withDefaults());
				return http.build();
		}

		@Bean
		public PasswordEncoder passwordEncoder() {
				return new BCryptPasswordEncoder();
		}

		@Bean
		public UserDetailsService userDetailsService() {
				UserDetails userDetails;

				userDetails = User.withDefaultPasswordEncoder()
						.username("user")
						.password("password")
						.roles("USER")
						.build();

				return new InMemoryUserDetailsManager(userDetails);

		}
}
