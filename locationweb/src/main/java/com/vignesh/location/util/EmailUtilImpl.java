package com.vignesh.location.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtilImpl implements EmailUtill {
	
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendEmail(String toAddress, String subject, String body) {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		try {
		helper.setTo(toAddress);
		helper.setSubject(subject);
		helper.setText(body);
		} catch (MessagingException exception) {
			exception.getStackTrace();
		}
		
		mailSender.send(message);
	}

}
