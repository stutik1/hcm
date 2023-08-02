package com.stuti.email.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import jakarta.mail.internet.MimeMessage;

import java.io.File;

@Service
public class EmailService {
    private final EmailRepository emailRepository;
    private EmailDetails emailDetails;
    private JavaMailSender javaMailSender;

    @Autowired
    public EmailService(EmailRepository emailRepository, JavaMailSender javaMailSender) {
        this.emailRepository = emailRepository;
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(String to, String subject, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("stuti.megha2@gmail.com");
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);

            javaMailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMessageWithAttachmentAndHTML(String to, String subject, String text, String pathToAttachment , String html) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("stuti.megha2@gmail.com");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(html,true);

            FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
            helper.addAttachment("Invoice", file);

            javaMailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public void sendMessageWithHTML(String to, String subject, String text, String html) {
//        try {
//            MimeMessage message = javaMailSender.createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(message, true);
//
//            helper.setFrom("stuti.megha2@gmail.com");
//            helper.setText(html, true);
//            helper.setTo(to);
//            helper.setSubject(subject);
//
//            javaMailSender.send(message);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public EmailDetails saveEmail(EmailDetails emailDetails) {
        return emailRepository.save(emailDetails);
    }

    public EmailDetails getEmailById(Long id) {
        return emailRepository.findById(id);
    }

    public List<EmailDetails> getAllEmail() {
        return emailRepository.findAll();
    }

}
