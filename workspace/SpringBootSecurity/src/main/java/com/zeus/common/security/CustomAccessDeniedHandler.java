package com.zeus.common.security;

import java.io.IOException;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.java.Log;

@Log
public class CustomAccessDeniedHandler implements AccessDeniedHandler {@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
	//내가 안가받지 않은 회원이 권한없는 페이지에 접근할 때 정보를 점검 및 저장한다
	log.info("인가받지 않은 접근 발생");
	response.sendRedirect("/accessError");
	}

}
