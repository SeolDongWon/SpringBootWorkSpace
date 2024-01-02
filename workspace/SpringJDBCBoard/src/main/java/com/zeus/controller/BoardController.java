package com.zeus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zeus.Service.BoardService;
import com.zeus.domain.Board;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService service;

	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public String registerForm(Board board, Model model) throws Exception {
		log.info("registerForm");

		return "board/register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Board board, Model model) throws Exception {
		log.info("register");
		service.register(board);
		model.addAttribute("msg", "등록 완료");

		return "board/success";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) throws Exception {
		log.info("list");

		model.addAttribute("list", service.list());
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(int boardNo, Model model) throws Exception {
		log.info("read");

		model.addAttribute(service.read(boardNo));
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(int boardNo, Model model) throws Exception {
		log.info("remove");
		service.remove(boardNo);
		model.addAttribute("msg", "삭제 완료");

		return "board/success";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyForm(int boardNo, Model model) throws Exception {
		log.info("modifyForm");

		model.addAttribute(service.read(boardNo));
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(Board board, Model model) throws Exception {
		log.info("modify");
		service.modify(board);

		model.addAttribute("msg", "수정 완료");
		return "board/success";
	}
}
