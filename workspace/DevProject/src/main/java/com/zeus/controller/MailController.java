package com.zeus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.zeus.domain.MailDto;
import com.zeus.service.EmailService;

@Controller
public class MailController {
	private final EmailService emailService;
	 
    public MailController(EmailService emailService) {
        this.emailService = emailService;
    }
 
    @GetMapping("/mail/send")
    public String main() {
        return "redirect:/sendMail.jsp";
    }
 
    @PostMapping("/mail/send")
    public String sendMail(MailDto mailDto) {
    	System.out.println("메일 전송 시작");
        emailService.sendSimpleMessage(mailDto);
        System.out.println("메일 전송 완료");
        return "redirect:/sendMail.jsp";
    }
}
