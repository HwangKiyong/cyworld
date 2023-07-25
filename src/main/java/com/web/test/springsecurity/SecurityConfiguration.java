package com.web.test.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableWebSecurity
public class SecurityConfiguration {

//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//	    http.authorizeRequests()
//	        .antMatchers("/").permitAll()
//	       .antMatchers(
//	                    "/css/**",
//	                    "/js/**",
//	                    "/images/**",
//	                    "/webjars/**",
//	                    "/favicon.*",
//	                    "/*/icon-*"
//	            ).permitAll()
//	            .antMatchers("/mypage").hasRole("USER")
//	            .antMatchers("/message").hasRole("MANAGER")
//	            .antMatchers("/config").hasRole("ADMIN")
//	            .anyRequest().authenticated();
//
//	    http.formLogin();
//
//	    return http.build();
//	}
}
