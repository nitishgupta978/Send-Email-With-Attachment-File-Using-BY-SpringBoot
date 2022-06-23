package com.codewithbihari.send.email.with.attachment.files.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmailWithAttachment(String body,
                                        String toEmail,
                                        String subject,
                                        String attachment) throws MessagingException {

        MimeMessage mimeMessage= javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);

        mimeMessageHelper.setFrom("nitishgupta9785@gmail.com");
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setSubject(subject);

        FileSystemResource fileSystemResource=new FileSystemResource(new File(attachment));
        mimeMessageHelper.addAttachment(fileSystemResource.getFilename(),fileSystemResource);
        javaMailSender.send(mimeMessage);
        System.out.println("Mail Send Successfully with Attachment Files");

    }
}
