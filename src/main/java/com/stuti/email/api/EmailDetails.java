package com.stuti.email.api;

public class EmailDetails {
    private Long id;
    private String body;
    private String senderEmailId ;
    private String recipientMailId ;
    private String subject ;
    private EmailStatusType status ;

    public EmailDetails(Long id, String body, String senderEmailId, String recipientMailId, String subject) {
        this.id = id;
        this.body = body;
        this.senderEmailId = senderEmailId;
        this.recipientMailId = recipientMailId;
        this.subject = subject;
        this.status = EmailStatusType.PENDING;
    }

    public EmailDetails() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSenderEmailId() {
        return senderEmailId;
    }

    public void setSenderEmailId(String senderEmailId) {
        this.senderEmailId = senderEmailId;
    }

    public String getRecipientMailId() {
        return recipientMailId;
    }

    public void setRecipientMailId(String recipientMailId) {
        this.recipientMailId = recipientMailId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public EmailStatusType getStatus() {
        return status;
    }

    public void setStatus(EmailStatusType status) {
        this.status = status;
    }
}
