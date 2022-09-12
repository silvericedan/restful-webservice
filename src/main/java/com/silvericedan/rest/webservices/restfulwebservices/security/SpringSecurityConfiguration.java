package com.silvericedan.rest.webservices.restfulwebservices.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    //All request should be authenticated
    http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
    //If a request its not authorized, show a popup asking for username and password
    http.httpBasic(withDefaults());
    //CRSF -> POST,PUT
    http.csrf().disable();
    return http.build();
  }

}
