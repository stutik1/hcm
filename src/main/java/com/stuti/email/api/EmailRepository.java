package com.stuti.email.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

@Repository
public class EmailRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmailRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public EmailDetails save(EmailDetails emailDetails){
        String sql = "INSERT INTO email_status (sender_email, recipient_mail, body, subject, status) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                emailDetails.getSenderEmailId(),
                emailDetails.getRecipientMailId(),
                emailDetails.getBody(),
                emailDetails.getSubject(),
                emailDetails.getStatus().toString()
               );

        return emailDetails;
    }

    public EmailDetails findById(Long id){
        String sql = "SELECT * FROM email_status WHERE email_status_id = ?";
        return (EmailDetails) jdbcTemplate.queryForObject(sql, new Object[]{ id }, new EmailDetailsRowMapper());
    }

    public List<EmailDetails> findAll() {
        String sql = "SELECT * FROM email_status";
        return jdbcTemplate.query(sql, new EmailDetailsRowMapper());
    }
}
