package com.wipro.medicalbillingsystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.wipro.medicalbillingsystem.filter.JWTAuthFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	@Autowired()
	JWTAuthFilter authFilter;

	@Bean
	public UserDetailsService userDetailsService() {

		return new UserInfoUserDetailsService();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf().disable()
				.cors().and()
                .authorizeHttpRequests()
                .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-resources/**",
                        "/api/patients/authenticate", "/api/patients/add/new", "/api/patients/get/allpatients",
                        "/api/provider/authenticate", "/api/provider/add/provider",
                        "/api/companies/authenticate", "/api/companies/add/company",
                        "/api/admin/authenticate", "/api/admin/add", "/api/adminmedical/getallpatients", "/api/adminmedical/getallinsuranceplans",
                        "/api/provider/delete/provider/{providerId}",
                        "/api/insuranceclaims/add/newclaim", "/api/insuranceclaims/getallclaims/{claimStatus}"
                )
                .permitAll().and().authorizeHttpRequests()
                .requestMatchers("/api/admin/**","/api/patients/**", "/api/provider/**", "/api/companies/**",
                        "/api/insuranceplans/**", "/api/insuranceclaims/**", "/api/invoicedetails/**")
                .authenticated().and() // .formLogin().and().build();
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class).build();

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

	@Bean
	public AuthenticationManager getAuthenticateManager(AuthenticationConfiguration configure) throws Exception {
		return configure.getAuthenticationManager();
	}

}
