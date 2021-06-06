package com.unla.proyectosoftware.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private UserDetailsService userDetails;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder(4);
	}
	//Necesario para evitar que la seguridad se aplique a los resources Como los css, imagenes y javascripts
	String[] resources = new String[]{
			"/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**"
	};	
	//Registra el service para usuarios y el encriptador de contrasena
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetails).passwordEncoder(passwordEncoder());     
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() 
			.antMatchers(resources).permitAll()
			.antMatchers("/").permitAll()
			.antMatchers("/user/**").hasRole("USER")
			.antMatchers("/admin/**").hasRole("ADMIN") 
			.anyRequest().authenticated()
		.and()
			.formLogin()
			.loginPage("/login")
			.permitAll().defaultSuccessUrl("/login/success")
			.failureUrl("/login?error=true")
			.usernameParameter("username")
			.passwordParameter("password")
		.and()
			.logout().permitAll().logoutSuccessUrl("/");
}
	

}