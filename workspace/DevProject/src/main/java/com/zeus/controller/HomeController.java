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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zeus.domain.Board;
import com.zeus.domain.Card;
import com.zeus.domain.Member;

import lombok.extern.java.Log;

@Log // 로그파일을 화면에 남긴다
@Controller
public class HomeController {
	// 롬복을 못쓰면 이렇게 해야한다. 왠만하면 롬복쓰자
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homeIndex(Locale locale, Model model) {
		log.info("log: 환영합니다. 당신의 지역은 " + locale);
		logger.info("logger: 환영합니다. 당신의 지역은 " + locale);
		return "home";
	}
	
	@RequestMapping(value = "/board/read/{boardNo}", method = RequestMethod.GET)
	public String home(@PathVariable("boardNo") int boardNo) {
		log.info("boardNo : " + boardNo);
		return "home";
	}
	
	@GetMapping(value="/formHome")
	public String forHome() {
		log.info("GET 방식 forHome");
		return "formHome";
	}
	
	@RequestMapping(value="/ajaxHome", method = RequestMethod.GET)
	public String ajaxHome() {
		log.info("call ajaxHome.jsp");
		return "ajaxHome";
	}
	
	@PutMapping(value="/board/{boardNo}")
	public ResponseEntity<String> boardModify(@PathVariable("boardNo") int boardNo,@RequestBody Board board) {
		log.info("boardModify : "+ boardNo +" "+ board.toString());
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		return entity;
	}
	
	@GetMapping(value="/board/{boardNo}")
	public ResponseEntity<Board> boardSelect(@PathVariable("boardNo") int boardNo) {
		log.info("boardSelect : "+ boardNo +" ");
		Board board = new Board();
		board.setBoardNo(20);
		board.setTitle("ajaxGetTest");
		board.setWriter("seol1");
		board.setContent("good");
		board.setRegDate(new Date());
		
		ResponseEntity<Board> entity = new ResponseEntity<Board>(board,HttpStatus.OK);
		return entity;
	}
	
	
	@GetMapping("/home3304")
	public String home3304(Model model) {
		Date date = new Date();
		model.addAttribute("now", date);
		return "home3304";
	}
}
