package com.gl.collegefest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.gl.collegefest.service.UserServiceImpl;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf()
		.disable()
		.authorizeRequests()
		.antMatchers("/registration **").permitAll()
		.antMatchers("/showStudentFormAdd/","/student").hasAnyRole("ADMIN","USER")
		.antMatchers("/list/").hasAnyRole("ADMIN","USER")
		.antMatchers("/showStudentFormForEdit/**").hasRole("ADMIN")
		.antMatchers("/delete/**").hasRole("ADMIN")
		.anyrequest().authenticated()
		.and()
			.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/authenticateTheUser")
			.permitAll() .and() .logout().invalidateHttpSesion(true)
			.clearAuthentication(true).logoutRequestMatcher(new AntPathRequestMatcher ("/logout"))
			.logoutSuccessUrl("/login?logout").permitAll().and()
			.exceptionHandling()
			.accessDeniedPage("/access-denied");
			
	}
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
    public UserDetailsService getUserDetailsService() {
        return new UserServiceImpl ();
    }
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(this.getUserDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(this.passwordEncoder());
		return daoAuthenticationProvider;
		
	}
	private DaoAuthenticationProvider DaoAuthenticationProvider() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
