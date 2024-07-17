package com.example.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetails(PasswordEncoder encoder) {

        UserDetails admin = User.builder()
                .username("anji")
                .password(encoder.encode("anji@2001"))
                .roles("ADMIN")
                .build();

        UserDetails user = User.builder()
                .username("veeru")
                .password(encoder.encode("veeru@2001"))
                .roles("USER")
                .build();

        InMemoryUserDetailsManager imdm = new InMemoryUserDetailsManager(admin, user);
        return imdm;
    }

   /* @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.disable())
                .authorizeHttpRequests(req -> req
                        .requestMatchers("/public/rest/*").permitAll()
                        .requestMatchers("/rest/getone/{id}").hasRole("ADMIN")
                        .requestMatchers("/rest/getall").hasAnyRole("ADMIN", "USER")
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }*/

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(req -> req
                        //.requestMatchers("/public/rest/*").permitAll()
                        .requestMatchers("/rest/msg").permitAll()
                        .requestMatchers("/rest/getall").hasRole( "USER")
                        .requestMatchers("/rest/**").hasAnyRole("ADMIN","USER")
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults());
        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}