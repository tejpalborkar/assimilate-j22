package com.assimilate.springboot.javafeb.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)  
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	 @Override
	   protected void configure(HttpSecurity http) throws Exception 
	    {
	        http
	         .csrf().disable()
	         .authorizeRequests().antMatchers("/api/helloWorld", "/message").permitAll()
	         .anyRequest().authenticated()
	         .and()
	         .formLogin().defaultSuccessUrl("/students");
	    }
	  
	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) 
	            throws Exception 
	    {
//	        auth.inMemoryAuthentication()
//	            .withUser("admin")
//	            .password("{noop}admin")
//	            .roles("ADMIN");
	    	// tejpal
	    	// 
	    	
	    	BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
	    	String encode = encoder.encode("tejpal");
	    	System.out.println(encode);
	    	
//	    	auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//	    		.dataSource(dataSource)
//	    		.usersByUsernameQuery("select username, password, enabled from users where username = ?")
//	    		.authoritiesByUsernameQuery("select username, role from users where username=?");
//	    	
	        
	    	auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	    	
	        
	    }
	    
	    // Authentication -> Its credentials are valid
	    // Authorization  -> Admin, User, 
	

}
