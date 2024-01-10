package com.zeus.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	@RequestMapping("/list")
	public void list() {
		log.info("list : 모두 접근 가능");
	}
	
	// 관리지 권한을 가진 사용자만 접근이 가능하다.
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping("/register")
	public void register() {
		log.info("register : 로그인한 관리자만 가능");
	}

}
