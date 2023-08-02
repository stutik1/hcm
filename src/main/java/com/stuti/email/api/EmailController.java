package com.stuti.email.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/api/EmailDetailStatus")
public class EmailController {
    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public EmailDetails createEmailDetails(@RequestBody EmailDetails emailDetails) {
        emailService.sendEmail(emailDetails.getRecipientMailId(), emailDetails.getSubject(), emailDetails.getBody());

        File attachmentFile = new File("/Users/megha/Desktop/megha.txt");

        emailService.sendMessageWithAttachment(emailDetails.getRecipientMailId(), emailDetails.getSubject(), emailDetails.getBody(), String.valueOf(attachmentFile));

        String html = "<h3>Hello World!</h3>";
        emailService.sendMessageWithHTML(emailDetails.getRecipientMailId(), emailDetails.getSubject(), emailDetails.getBody(), html);

        return emailService.saveEmail(emailDetails);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmailDetails> getEmployeeById(@PathVariable Long id) {
        EmailDetails emailDetails = emailService.getEmailById(id);
        if (emailDetails != null) {
            return ResponseEntity.ok(emailDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public List<EmailDetails> getAllEmailDetails() {
        return emailService.getAllEmail();
    }
}
