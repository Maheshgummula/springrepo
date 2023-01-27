package com.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.email.entity.EmailDetails;
@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value("{spring.mail.username}")
	private String sender;
	@Override
	public String sendSimpleMail(EmailDetails details) {
	
			
			SimpleMailMessage mailMessage=new SimpleMailMessage();
			mailMessage.setFrom(sender);
			mailMessage.setTo(details.getRecipient());
			mailMessage.setText(details.getMsgBody());
			mailMessage.setSubject(details.getSubject());
			javaMailSender.send(mailMessage);
			return "sent successfully";
		
	}

}
