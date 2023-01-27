package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl {

	@Autowired
	private JavaMailSender mailSender;

	public String sendSimpleMail(String toEmail, String tosubject, String body) {

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("maheshgummula4@gmail.com");
		mailMessage.setTo(toEmail);
		mailMessage.setText(body);
		mailMessage.setSubject(tosubject);
		mailSender.send(mailMessage);
		return "sent successfully";

	}

}
