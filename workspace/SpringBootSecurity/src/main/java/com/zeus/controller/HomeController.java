package com.zeus.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.java.Log;

@Log
@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.info("home : 모두 접근 가능");
		log.info(locale + "의 방문을 환영합니다.");
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		return "home";

	}

	@RequestMapping("/register")
	public void register() {
		log.info("register : 로그인한 관리자만 가능");
	}

//	@RequestMapping("/accessError")
//	public void accessError(Authentication auth, Model model) {
//		log.info("accessError : "+auth);
//		model.addAttribute("msg", "이 사이트는 회원 이상만 볼 수 있어요");
//	}
	

}
