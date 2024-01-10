package com.zeus.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.zeus.domain.MailDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmailService {
	private JavaMailSender emailSender;
	 
    public void sendSimpleMessage(MailDto mailDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("seol1");
        message.setTo(mailDto.getAddress());
        message.setSubject(mailDto.getTitle());
        message.setText(mailDto.getContent());
        emailSender.send(message);
    }
}
