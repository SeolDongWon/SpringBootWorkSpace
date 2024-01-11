package com.project.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.java.Log;

@Log
@Configuration
@EnableWebSecurity
public class SecurityConfig 
//extends WebSecurityConfiguration
{
	@Autowired
	DataSource dataSource;
	
	@Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        log.info("security config ...");
        
        // csrf 토큰 비활성화
        http.csrf().disable();
        
        //주석 팁
        //* 관리자전체페이지를 권한을 인가요청할 때 http.authorizehttpRequests().
        http.authorizeHttpRequests().
        requestMatchers("/board/**").authenticated().
        requestMatchers("/manager/**").hasRole("MANAGER").
        requestMatchers("/admin/**").hasRole("ADMIN").
        anyRequest().permitAll();
        //*/
        
    	
    	//개발자가 만든 로그인 페이지 사용
        http.formLogin().loginPage("/login");
    	
    	
        return http.build();
    }
	
	@Bean
	public PasswordEncoder createPasswordEncoder() {
	return new BCryptPasswordEncoder();
	}
	

}
