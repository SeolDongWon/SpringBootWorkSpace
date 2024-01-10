package com.zeus.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.zeus.common.security.CustomAccessDeniedHandler;
import com.zeus.common.security.CustomLoginSuccessHandler;

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
        
        // URI 접근제한 설정
//        http.authorizeHttpRequests().requestMatchers("/board/list").permitAll();
        //hasAnyRole : Role 여러개 설정
//        http.authorizeHttpRequests().requestMatchers("/board/register").hasAnyRole("ADMIN","MEMBER");
        http.authorizeHttpRequests().requestMatchers("/board/register").hasRole("MEMBER");
        
//        http.authorizeHttpRequests().requestMatchers("/notice/list").permitAll();
        //hasAnyRole : Role 1개 설정
        http.authorizeHttpRequests().requestMatchers("/notice/register").hasRole("ADMIN");
        
        //모두 허용 / 이걸 쓰면 각 requestMatchers("**").permitAll();이 필요없다
        http.authorizeHttpRequests().anyRequest().permitAll();
        
        // 가입한 회원이 인가받지 않은 페이지에 접근하면 403 에러메세지를 /accessError로 대체한다
//    	http.exceptionHandling().accessDeniedPage("/accessError");
        // 위와 같은 경우에서 바로 페이지를 넘겨버리지 않고 로그를 남긴다
    	http.exceptionHandling().accessDeniedHandler(createAccessDeniedHandler());
        

        //폼 기반 인증기능 사용
//        http.formLogin();
    	
    	//개발자가 만든 로그인 페이지 사용
//        http.formLogin().loginPage("/login");
    	http.formLogin().loginPage("/login").successHandler(createAuthenticationSuccessHandler());
        
    	//로그아웃 처리를 위한 URI를 지정하고, 로그아웃한 후에 세션을 무효화한다.
    	http.logout().logoutUrl("/logout").invalidateHttpSession(true);
        
    
    	
        return http.build();
    }
	
	

	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 지정된 아이디와 패스워드로 로그인이 가능하도록 설정한다. 
		auth.inMemoryAuthentication()
		.withUser("member")
		.password("{noop}1234")
		.roles("MEMBER");
		
		auth.inMemoryAuthentication()
		.withUser("admin")
		.password("{noop}1234")
		.roles("ADMIN");
    }
	
	@Bean
	public AccessDeniedHandler createAccessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
	
	@Bean
	public AuthenticationSuccessHandler createAuthenticationSuccessHandler() {
		return  new CustomLoginSuccessHandler();
	}
}
