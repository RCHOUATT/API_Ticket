package com.APITickets.API_Tickets.Security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class ConfigSecurityApp{
    private DetailServiceImpl detailService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.userDetailsService(detailService);
        return httpSecurity
                //.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(registry -> {
                    registry.requestMatchers("/notif/**").permitAll()
                            .requestMatchers("/User/**").hasRole("ADMIN")
                            .requestMatchers("/Users/**").hasAnyRole("FORMATEUR", "APPRENANT")
                            .requestMatchers("/BDCon/**").hasRole("FORMATEUR")
                            .requestMatchers("/BDCons/**").hasRole("APPRENANT")
                            .requestMatchers("/ticket/**").hasRole("APPRENANT")
                            .requestMatchers("/tickets/**").hasRole("FORMATEUR")
                            .anyRequest().authenticated();
                })
                .httpBasic(Customizer.withDefaults())
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(detailService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails AdminUser = User.builder()
                .username("Admin")
                .password("$2a$12$.V5E3AFqJSBMniXglCP70OSktgwYexEuy5YSjQnGBLDRxB0JPX0Lm")
                .build();
        return new InMemoryUserDetailsManager( AdminUser);
    }
}