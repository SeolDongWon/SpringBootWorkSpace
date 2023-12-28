package com.zeus.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.tomcat.util.security.MD5Encoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zeus.domain.Card;
import com.zeus.domain.Member;

import lombok.extern.java.Log;

@Log // 로그파일을 화면에 남긴다
@Controller
@RequestMapping("/board")
public class BoardController {
	
	@GetMapping(value="/register")
	public String registerForm() {
		log.info("@GetMapping 방식 registerForm");
		return "success";
	}
	@PostMapping(value="/register")
	public String register() {
		log.info("@PostMapping 방식 registerForm");
		return "success";
	}
	@GetMapping(value="/modify")
	public String modifyForm() {
		log.info("@GetMapping 방식 modifyForm");
		return "success";
	}
	@PostMapping(value="/modify")
	public String modify() {
		log.info("@PostMapping 방식 modifyForm");
		return "success";
	}
	@PostMapping(value="/remove")
	public String remove() {
		log.info("@PostMapping 방식 remove");
		return "success";
	}
	@GetMapping(value="/list")
	public String list() {
		log.info("@GetMapping 방식 list");
		return "success";
	}
	
	
	


}
