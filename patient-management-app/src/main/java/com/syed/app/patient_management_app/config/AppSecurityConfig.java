package com.syed.app.patient_management_app.config;

public class AppSecurityConfig {

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

    @Configuration
    public class AppSecurityConfig {

        @Bean
        public UserDetailsService userDetailsService(){

            UserDetails doctor = User.withUsername("doctor")
                    .password(passwordEncoder()
                            .encode("Doctor_Password"))
                    .roles("DOCTOR")
                    .build();

            UserDetails patient = User.withUsername("patient")
                    .password(passwordEncoder()
                            .encode("Password_Patient"))
                    .roles("PATIENT")
                    .build();
            return new InMemoryUserDetailsManager(doctor,patient);
        }
        @Bean
        public PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();
        }

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
            http.csrf(csrf -> csrf.disable())
                    .authorizeHttpRequests(auth -> auth
                                    .requestMatchers("/*/all").hasAnyRole("PATIENT","DOCTOR")
                                    .requestMatchers("/**").hasRole("DOCTOR")
//
                    )
                    .httpBasic(Customizer.withDefaults());
            return http.build();
        }

        @Bean
        public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception{
            return authConfig.getAuthenticationManager();
        }
    }
}
