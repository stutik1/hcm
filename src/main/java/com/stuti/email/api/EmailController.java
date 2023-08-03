package com.stuti.email.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

//    @PostMapping
//    public EmailDetails createEmailDetails(@RequestBody EmailDetails emailDetails) {
//        //// emailService.sendEmail(emailDetails.getRecipientMailId(), emailDetails.getSubject(), emailDetails.getBody());
//
//        File attachmentFile = new File("/Users/megha/Desktop/megha.txt");
//        String html = "<h3>Hello World!</h3>";
//        emailService.sendMessageWithAttachmentAndHTML(emailDetails.getRecipientMailId(), emailDetails.getSubject(), emailDetails.getBody(), String.valueOf(attachmentFile), html);
//
//        /////
////        String html = "<h3>Hello World!</h3>";
////        emailService.sendMessageWithHTML(emailDetails.getRecipientMailId(), emailDetails.getSubject(), emailDetails.getBody(), html);
//
//        return emailService.saveEmail(emailDetails);
//    }

    @PostMapping()
    public ResponseEntity<String> createEmail(@RequestBody EmailDetails emailDetails) {
        File attachmentFile = new File("/Users/megha/Desktop/megha.txt");
        String html = "<h3>Hello World!</h3>";
        emailService.sendMessageWithAttachmentAndHTML(emailDetails.getRecipientMailId(), emailDetails.getSubject(), emailDetails.getBody(), String.valueOf(attachmentFile), html);

        emailDetails.getSenderEmailId();
        emailDetails.setRecipientMailId(emailDetails.getRecipientMailId());
        emailDetails.setBody(emailDetails.getBody());
        emailDetails.setSubject(emailDetails.getSubject());
        emailDetails.setStatus(EmailStatusType.valueOf("PENDING"));
        emailService.saveEmail(emailDetails);
        return ResponseEntity.status(HttpStatus.CREATED).body("Email sent successfully.");

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
