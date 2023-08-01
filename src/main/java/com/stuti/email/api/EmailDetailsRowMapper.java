package com.stuti.email.api;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmailDetailsRowMapper implements RowMapper {
        public EmailDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
            EmailDetails emailDetails = new EmailDetails();
            emailDetails.setId(rs.getLong("email_status_id"));
            emailDetails.setBody(rs.getString("body"));
            emailDetails.setSenderEmailId(rs.getString("sender_email"));
            emailDetails.setRecipientMailId(rs.getString("recipient_mail"));
            emailDetails.setSubject(rs.getString("subject"));
            emailDetails.setStatus(EmailStatusType.valueOf(rs.getString("status").toUpperCase()));
            return emailDetails;
        }
}
