package com.zeus.common.security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;

@Log
@Controller
public class CommonController {

	@RequestMapping("/accessError")
	public void accessError(Authentication auth, Model model) {
		log.info("accessError : "+auth);
		model.addAttribute("msg", "이 페이지에 접근권한이 없어요");
	}
	

}
