package com.zeus.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.zeus.common.security.CustomAccessDeniedHandler;
import com.zeus.common.security.CustomLoginSuccessHandler;
import com.zeus.common.security.CustomNoOpPasswordEncoder;
import com.zeus.common.security.CustomUserDetailsService;

import lombok.extern.java.Log;

@Log
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled=true, securedEnabled=true)
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
        
        /*//주석 팁
        http.authorizeHttpRequests().
        requestMatchers("/board/**").authenticated().
        requestMatchers("/manager/**").hasRole("MANAGER").
        requestMatchers("/admin/**").hasRole("ADMIN").
        anyRequest().permitAll();
        //*/
        
        // URI 접근제한 설정
//        http.authorizeHttpRequests().requestMatchers("/board/list").permitAll();
        //hasAnyRole : Role 여러개 설정
//        http.authorizeHttpRequests().requestMatchers("/board/register").hasAnyRole("ADMIN","MEMBER");
        http.authorizeHttpRequests().requestMatchers("/board/register").hasRole("MEMBER");
        
//        http.authorizeHttpRequests().requestMatchers("/notice/list").permitAll();
        //hasAnyRole : Role 1개 설정
//        http.authorizeHttpRequests().requestMatchers("/notice/register").hasRole("ADMIN");
        
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
//    	http.logout().logoutUrl("/logout").invalidateHttpSession(true);
    	// 로그아웃을 하면 자동 로그인에 사용하는 쿠키도 삭제해 주도록 한다. 
    	http.logout().logoutUrl("/logout").invalidateHttpSession(true).deleteCookies("remember-me","JSESSION_ID");
    	
    	// 데이터 소스를 지정하고 테이블을 이용해서 기존 로그인 정보를 기록
    	// 쿠키의 유효 시간을 지정한다(24시간). 
    	http.rememberMe()
    	.key("zeus")
    	.tokenRepository(createJDBCRepository())
    	.tokenValiditySeconds(20);

        
    	
    	
        return http.build();
    }
	
	
	private PersistentTokenRepository createJDBCRepository() { 
		JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl(); 
		repo.setDataSource(dataSource);
		return repo;
		}
	
	
	//@Autowired 를 진행하지 말 것
//	@Autowired 
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 지정된 아이디와 패스워드로 로그인이 가능하도록 설정한다. 
//		auth.inMemoryAuthentication().withUser("member").password("{noop}1234").roles("MEMBER");
//		auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("ADMIN");
		
		// JDBC 인증 제공자, 데이터 소스를 지정, 사용자가 정의한 비번 암호화 처리기를 지정한다.
//		auth.jdbcAuthentication()
//		.dataSource(dataSource)
//		.passwordEncoder(createPasswordEncoder());
		auth.userDetailsService(createUserDetailsService()).
		passwordEncoder(createPasswordEncoder());


    }
	
	// 스프링 시큐리티의 UserDetailsService를 구현한 클래스를 빈으로 등록한다. 
	@Bean
	public UserDetailsService createUserDetailsService() { 
	return new CustomUserDetailsService();
	}
	
	// CustomAccessDeniedHandler를 빈으로 등록한다.
	@Bean
	public AccessDeniedHandler createAccessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
	
	// CustomLoginSuccessHandler를 빈으로 등록한다.
	@Bean
	public AuthenticationSuccessHandler createAuthenticationSuccessHandler() {
		return  new CustomLoginSuccessHandler();
	}
	
	// 사용자가 정의한 비번 암호화 처리기를 빈으로 등록한다.
	@Bean
	public PasswordEncoder createPasswordEncoder() { 
	return new CustomNoOpPasswordEncoder();
	}

	
	

}
