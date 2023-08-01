package com.stuti.email.api;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmailService {
    private final EmailRepository emailRepository;
    private EmailDetails emailDetails;
    private JavaMailSender javaMailSender;

    public EmailService(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    public EmailDetails saveEmail(EmailDetails emailDetails){
        javaMailSender.send();
        return emailRepository.save(emailDetails);
    }

    public EmailDetails getEmailById(Long id){
        return emailRepository.findById(id);
    }

    public List<EmailDetails> getAllEmail(){
        return emailRepository.findAll();
    }

}
