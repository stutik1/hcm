package com.stuti.email.api;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmailRowMapper implements RowMapper {
    public EmailDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmailDetails emailDetails = new EmailDetails();
        EmailDetails.setId(rs.getLong("email_status_id"));
        EmailDetails.setSenderEmailId(rs.getString("sender_email"));
        EmailDetails.setRecipientMailId(rs.getString("recipient_mail"));
        EmailDetails.getBody(rs.getString("body"));
        EmailDetails.setSubject(rs.getString("subject"));
        EmailDetails.setStatus(rs.getString("status"));
        return EmailDetails;
    }
}
