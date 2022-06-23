package com.codewithbihari.send.email.with.attachment.files;

import com.codewithbihari.send.email.with.attachment.files.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class SendEmailWithAttachmentFilesApplication {
	@Autowired
	private EmailService emailService;

	public static void main(String[] args) {
		SpringApplication.run(SendEmailWithAttachmentFilesApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void getEmail() throws MessagingException {
		emailService.sendEmailWithAttachment("This is a body","nkg012001@gmail.com",
				"Send Email With Attachment","C:\\Users\\gupta\\OneDrive\\Desktop\\add.pdf");
	}


}
