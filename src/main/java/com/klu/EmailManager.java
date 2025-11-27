package com.klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailManager {
	@Autowired
	JavaMailSender jms;
	public String sendEmail(String toEmail, String sub, String msg) {
		try {
			SimpleMailMessage mailMsg=new SimpleMailMessage();
			mailMsg.setFrom("rupeshch584@gmail.com");
			mailMsg.setTo(toEmail);
			mailMsg.setSubject(sub);
			mailMsg.setText(msg);
			jms.send(mailMsg);
			return "200::Mail sent to Registered Mail";			
		}
		catch(Exception e) {
			return "400::" + e.getMessage();
		}
	}
}