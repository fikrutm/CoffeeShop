package edu.mum.coffee.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserAuthenticationSuccessHandler successHandler;
	
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                                .antMatchers("/products/**").permitAll()
                                .antMatchers("/persons/**").permitAll()
                                .antMatchers("/orders/**").permitAll()
                                
                                .antMatchers("/user").hasRole("USER")
                				.antMatchers("/admin").hasRole("ADMIN")
                                
				                .antMatchers("/", "/home", "/index").permitAll()                
				                .anyRequest().authenticated()
				                .and().csrf().disable().headers().frameOptions().disable().and() 			                
            .formLogin()
                 .successHandler(successHandler)
            	.permitAll()
            	.and()
            .logout()
            	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            	.logoutSuccessUrl("/")
                .permitAll();
    }

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN").and()
		.withUser("user").password("user").roles("USER");
		
	}
	 @Autowired
	    private UserDetailsService userDetailsService;

	    @Bean
	    public BCryptPasswordEncoder bCryptPasswordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	 /*   @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	                .authorizeRequests()
	                    .antMatchers("/resources/**", "/registration").permitAll()
	                    .antMatchers("/products/**").permitAll()
                        .antMatchers("/persons/**").permitAll()
                        .antMatchers("/orders/**").permitAll()
                        
                        .antMatchers("/user").hasRole("USER")
        				.antMatchers("/admin").hasRole("ADMIN")
                        
		                .antMatchers("/", "/home", "/index").permitAll()
	                    
	                    .anyRequest().authenticated()
	                    .and()
	                .formLogin()
	                    .loginPage("/login")
	                    .permitAll()
	                    .and()
	                .logout()
	                    .permitAll();
	    }

	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	    }
	
*/	
}